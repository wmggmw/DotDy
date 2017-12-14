package com.wmg.ddd.dotdy.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
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

    /**
     * 累计位移
     */
    private float accumDis = 0;

    private float delDis = 0;

    //用于记录正常的布局位置
    private Rect originalRect = new Rect();

    //手指按下时记录是否可以继续下拉
    private boolean canPullDown = false;

    //手指按下时记录是否可以继续上拉
    private boolean canPullUp = false;

    //在手指滑动的过程中记录是否移动了布局
    private boolean isMoved = false;

    private ViewConfiguration viewConfiguration;

//    private MulFingerSet mulFingerSet;

    private RecyclerViewCanScroll rvBottomListener;

    /**
     * 滑动状态记录
     * -1-位于顶部 0-位于之间 1-位于底部
     */
    private int scrollState = 0;

    private final int TOP = -1, MIDDLE = 0, BOTTOM = 1;

    private RecyclerView recyclerView;

    public ReboundScrollView(Context context) {
        super(context);
    }

    public ReboundScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        viewConfiguration = ViewConfiguration.get(context);
//        mulFingerSet = new MulFingerSet();
    }

    /**
     * 设置是否滑动到底部或顶部的监听器
     * @param recyveclerView
     * @param listener
     */
    public void addRecyclerViewReachBottomListener(RecyclerView recyveclerView, RecyclerViewCanScroll listener){
        this.recyclerView = recyveclerView;
        this.rvBottomListener = listener;
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
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

        switch (action & MotionEvent.ACTION_MASK) {
//            case MotionEvent.ACTION_POINTER_DOWN:
//
//                startY = ev.getY();
//
//                if( ev.getPointerCount() > mulFingerSet.getFingerCount()){
//                    //新手指加入
//                    mulFingerSet.addNewFinger(startY);
//                }
//
//
//                Log.i("wmgPoint", "ACTION_POINTER_DOWN" + "   startY= "+startY);
//                delDis = accumDis;
//                break;
//            case MotionEvent.ACTION_POINTER_UP:
//                //有一个手指释放，根据此时的startY值，判断是哪一个手指，remove
//                mulFingerSet.releaseFinger(startY);
//                break;
            case MotionEvent.ACTION_DOWN:
                //判断是否可以上拉和下拉
                canPullDown = isCanPullDown();
                canPullUp = isCanPullUp();

                //记录按下时的Y值
//                if( rvBottomListener != null){
//                    if( !rvBottomListener.canScroll(1)) {
//                        //RecyclerView是否位于底部
//                        scrollState = BOTTOM;
//                        startY = ev.getY();
//                    } else if( !rvBottomListener.canScroll(-1)){
//                        //RecyclerView是否位于顶部
//                        scrollState = TOP;
//                        startY = ev.getY();
//                    } else {
//                        scrollState = MIDDLE;
//                        startY = -1;
//                    }
//                } else {
//                    startY = ev.getY();
//                }
                startY = ev.getY();
                Log.i("wmgPoint", "ACTION_DOWN" + "   startY= "+startY);
                break;

            case MotionEvent.ACTION_UP:
                accumDis = 0;
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
                //计算手指移动的距离
                float nowY = ev.getY();
                int deltaY = 0;
                //注意，RecyvlerView位于顶部时，向上滑，RecyclerView动，ScrollView不动
                //RecyvlerView位于底部时，向下滑，RecyclerView动，ScrollView不动
                if( rvBottomListener != null){
                    if( (!rvBottomListener.canScroll(1))){
                        //位于底部
                        if( ev.getY() - startY < 0){
                            //向上滑，可行
                            deltaY = (int) (nowY - startY);
                            if( recyclerView != null) {
//                                recyclerView.setFocusable(false);
//                                setFocusable(true);
//                                setFocusableInTouchMode(true);
//                                requestFocus();
                            }
                        } else {
                            //向下滑，不可行
                            deltaY = 0;
                        }
                    } if( (!rvBottomListener.canScroll(-1))){
                        //位于顶部
                        if( ev.getY() - startY > 0){
                            //向下滑，可行
                            deltaY = (int) (nowY - startY);
                        } else {
                            //不可行
                            deltaY = 0;
                        }
                    }else {
                        //位于中间
                        deltaY = (int) (nowY - startY);
                    }
                } else {

                }
//                Log.i("wmgPoint", "ACTION_MOVE");

//                //手指在移动之前，根据ev.getY()判断是哪一个手指，得到它的endY，对startY进行重新赋值
//                startY = mulFingerSet.recoverStartY(ev.getY());

                //在移动的过程中， 既没有滚动到可以上拉的程度， 也没有滚动到可以下拉的程度
                if(!canPullDown && !canPullUp) {
                    startY = ev.getY();
                    canPullDown = isCanPullDown();
                    canPullUp = isCanPullUp();

                    break;
                }

//                accumDis += deltaY;
                Log.i("wmgDel", "nowY= " + nowY + "  startY= " + startY + "  deltaY= " + deltaY);
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

    private boolean isSlideToBottom(RecyclerView recyclerView) {
        if (recyclerView == null) return false;
        if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset()
                >= recyclerView.computeVerticalScrollRange())
            return true;
        return false;
    }


    //判断是否滚动到顶部
    private boolean isCanPullDown() {
        //
        Log.i("wmgDam", "damValue getScrollY()= "+getScrollY());
        return getScrollY() == 0 ||
                contentView.getHeight() < getHeight() + getScrollY();
    }

    //判断是否滚动到底部
    private boolean isCanPullUp() {
        Log.i("wmgDam", "damValue getScrollY()2= "+getScrollY());
        return  contentView.getHeight() <= getHeight() + getScrollY();
    }

    public interface RecyclerViewCanScroll{
        /**
         * 是否到达了底部或顶部
         * @param direction 方向，-1-向顶部滑 1-向底部滑
         * @return 返回false表示不能往上滑动，即代表到底部了;
         *          返回false表示不能往下滑动，即代表到顶部了
         */
        boolean canScroll(int direction);
    }
}

