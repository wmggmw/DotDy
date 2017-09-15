package com.wmg.ddd.dotdy.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

/**
 * 仿ios可上提下拉的ScrollView
 * Ref: http://blog.csdn.net/u014733374/article/details/42739345
 * Bug：1.双击会动
 *        在move处加上判断代码
 *        if( Math.abs(deltaY) < viewConfiguration.getScaledTouchSlop()) break;
 *        这段代码起作用的原因是，break之后，isMove值不会改，还是默认的false；up那里，由于isMove为false，break，不会执行后续
 *      2.滑动到底部后，会先往下位移一定距离，然后向上回弹；在回弹到初始位置的下面时，停住，然后回到初始位置
 *        这是因为它的移动动画 new TranslateAnimation(0, 0, contentView.getTop(), originalRect.top)
 *        首先要知道getTop是相对于父容器而言的，而不是相对于整个屏幕
 *        子view我设置了margin，所以originalRect.top不为0，所以contentView.getTop() = 移动的距离 + originalRect.top
 *        所以才会先向下面移动originalRect.top
 */
public class ReboundScrollView extends ScrollView {

    private static final String TAG = "ElasticScrollView";

    //移动因子, 是一个百分比, 比如手指移动了100px, 那么View就只移动50px
    //目的是达到一个延迟的效果
    private static final float MOVE_FACTOR = 0.5f;

    //松开手指后, 界面回到正常位置需要的动画时间
    private static final int ANIM_TIME = 1000;

    //ScrollView的子View， 也是ScrollView的唯一一个子View
    private View contentView;

    //手指按下时的Y值, 用于在移动时计算移动距离
    //如果按下时不能上拉和下拉， 会在手指移动时更新为当前手指的Y值
    private float startY;

    //用于记录正常的布局位置
    private Rect originalRect = new Rect();

    //手指按下时记录是否可以继续下拉
    private boolean canPullDown = false;

    //手指按下时记录是否可以继续上拉
    private boolean canPullUp = false;

    //在手指滑动的过程中记录是否移动了布局
    private boolean isMoved = false;

    private ViewConfiguration viewConfiguration;

    public ReboundScrollView(Context context) {
        super(context);
    }

    public ReboundScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        viewConfiguration = ViewConfiguration.get(context);
    }

    @Override
    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            contentView = getChildAt(0);
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if(contentView == null) return;

        //ScrollView中的唯一子控件的位置信息, 这个位置信息在整个控件的生命周期中保持不变
        originalRect.set(contentView.getLeft(), contentView.getTop(), contentView
                .getRight(), contentView.getBottom());
    }

    //在触摸事件中, 处理上拉和下拉的逻辑
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Log.i("wmgEvent", "手指数目："+ev.getPointerCount());
        if (contentView == null) {
            return super.dispatchTouchEvent(ev);
        }

        int action = ev.getAction();

        switch (action) {
            case MotionEvent.ACTION_POINTER_DOWN:

                break;
            case MotionEvent.ACTION_POINTER_UP:

                break;
            case MotionEvent.ACTION_DOWN:
                Log.i("wmgPoint", "ACTION_DOWN");
                //判断是否可以上拉和下拉
                canPullDown = isCanPullDown();
                canPullUp = isCanPullUp();

                //记录按下时的Y值
                startY = ev.getY();
                break;

            case MotionEvent.ACTION_UP:
                Log.i("wmgPoint", "ACTION_UP");
                if(!isMoved) break;  //如果没有移动布局， 则跳过执行

                // 设置回到正常的布局位置
                contentView.layout(originalRect.left, originalRect.top,
                        originalRect.right, originalRect.bottom);

                // 开启动画
                //1.作者的代码，在当前位置下originalRect.top处开始回弹，回弹到原位置下originalRect.top，然后回到原位置
                //如果，没有设置margin，即originalRect.top为0，看起来是没问题的
//                TranslateAnimation anim = new TranslateAnimation(0, 0, contentView.getTop(), originalRect.top);
                //2.这个是最正确的，从当前位置开始回弹，正好回弹到原位置处，然后回到原位置
                //无论是否设置margin都适用
                TranslateAnimation anim = new TranslateAnimation(0, 0, contentView.getTop()-originalRect.top, 0);
                //3.这个是测试辅助用的，迅速闪到原位置，继续向上弹，出界，最后回到原位置
//                TranslateAnimation anim = new TranslateAnimation(0, 0, 0, (originalRect.top-contentView.getTop()));
                //4.这个是测试辅助用的，迅速闪到原位置，然后就在那里，没有然后了
//                TranslateAnimation anim = new TranslateAnimation(0, 0, 0, 0);
//                anim.setFillAfter(true);
                anim.setDuration(ANIM_TIME);
                contentView.startAnimation(anim);

                // 设置回到正常的布局位置
//                contentView.layout(originalRect.left, originalRect.top,
//                        originalRect.right, originalRect.bottom);

                //将标志位设回false
                canPullDown = false;
                canPullUp = false;
                isMoved = false;

                break;
            case MotionEvent.ACTION_MOVE:
//                Log.i("wmgPoint", "ACTION_MOVE");
                //在移动的过程中， 既没有滚动到可以上拉的程度， 也没有滚动到可以下拉的程度
                if(!canPullDown && !canPullUp) {
                    startY = ev.getY();
                    canPullDown = isCanPullDown();
                    canPullUp = isCanPullUp();

                    break;
                }

                //计算手指移动的距离
                float nowY = ev.getY();
                int deltaY = (int) (nowY - startY);

//                if( Math.abs(deltaY) < viewConfiguration.getScaledTouchSlop())
//                    break;

                //是否应该移动布局
                boolean shouldMove =
                        (canPullDown && deltaY > 0)    //可以下拉， 并且手指向下移动
                                || (canPullUp && deltaY< 0)    //可以上拉， 并且手指向上移动
                                || (canPullUp && canPullDown); //既可以上拉也可以下拉（这种情况出现在ScrollView包裹的控件比ScrollView还小）

                if(shouldMove){
                    //计算偏移量
                    int offset = (int)(deltaY * MOVE_FACTOR);
                    //随着手指的移动而移动布局
                    contentView.layout(originalRect.left, originalRect.top + offset,
                            originalRect.right, originalRect.bottom + offset);
                    isMoved = true;  //记录移动了布局
                }

                break;
            default:
                break;
        }

        return super.dispatchTouchEvent(ev);
    }


    //判断是否滚动到顶部
    private boolean isCanPullDown() {
        return getScrollY() == 0 ||
                contentView.getHeight() < getHeight() + getScrollY();
    }

    //判断是否滚动到底部
    private boolean isCanPullUp() {
        return  contentView.getHeight() <= getHeight() + getScrollY();
    }
}
