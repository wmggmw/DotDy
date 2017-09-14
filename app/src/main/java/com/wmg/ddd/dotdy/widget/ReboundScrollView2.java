package com.wmg.ddd.dotdy.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ScrollView;

/**
 * 仿ios可上提下拉的ScrollView
 * Ref: http://blog.csdn.net/u013598660/article/details/43950219
 */
public class ReboundScrollView2 extends ScrollView {


    private View inner;
    private float y;
    private Rect normal = new Rect();
    private static final int size = 1;

    public ReboundScrollView2(Context context) {
        super(context);
    }

    public ReboundScrollView2(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 获得第一个view
     */
    @Override
    protected void onFinishInflate() {
        if (getChildCount() > 0) {
            inner = getChildAt(0);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (inner == null) {
            return super.onTouchEvent(ev);
        } else {
            commOnTouchEvent(ev);
        }
        return super.onTouchEvent(ev);
    }

    /**
     * 添加手势响应事件
     * @param ev
     */
    public void commOnTouchEvent(MotionEvent ev) {
        int action = ev.getAction();
        switch (action) {
            case MotionEvent.ACTION_POINTER_DOWN:
                break;
            case MotionEvent.ACTION_DOWN:
                y = ev.getY();
                break;
            case MotionEvent.ACTION_UP:
                if (isNeedAnimation()) {
                    animation();
                }
                break;
            case MotionEvent.ACTION_MOVE:
                final float preY = y;
                float nowY = ev.getY();
                int deltaY = (int) (preY - nowY) / size;
                y = nowY;
                // 当滚动到最上或者最下时就不会再滚动，这时移动布局
                if (true) {
                    Log.i("wmgTest", "normal= " + normal.isEmpty());
                    if (normal.isEmpty()) {
                        // 保存正常的布局位置
                        Log.i("wmgTest", "             inner.getTop()= " + inner.getTop());
                        normal.set(inner.getLeft(), inner.getTop(),
                                inner.getRight(), inner.getBottom());
                        return;
                    }
                    Log.i("wmgTest", "                     inner.getTop()= " + inner.getTop() + "deltaY= " + deltaY);
                    //这里移动布局
                    inner.layout(inner.getLeft(), inner.getTop() - deltaY, inner.getRight(),
                            inner.getBottom() - deltaY);
                }
                break;
        }
    }

    // 开启动画移动
    public void animation() {
        // 开启移动动画
        TranslateAnimation ta = new TranslateAnimation(0, 0, inner.getTop() - normal.top, 0);
//        TranslateAnimation ta = new TranslateAnimation(0, 0, 0, 0);
        ta.setDuration(3000);
        inner.startAnimation(ta);
        // 设置回到正常的布局位置
        inner.layout(normal.left, normal.top, normal.right, normal.bottom);
        normal.setEmpty();
    }

    // 是否需要开启动画
    public boolean isNeedAnimation() {
        return !normal.isEmpty();
    }

    // 是否需要移动布局
    public boolean isNeedMove() {
        //inner.getMeasureHeight()是ScrollView内布局的高度，是一个恒定不变的值
        //getHeight是ScrollView的视图高度，移动的是ScrollView的内容，ScrollView是不动的，因而这也是一个定值
        int offset = inner.getMeasuredHeight() - getHeight();
        //getScrollY()是当前视图，也就是ScrollView的Y方向移动距离，由于ScrollView不动，所以这里恒为0
        int scrollY = getScrollY();
        //我去NMD，当LZ是SB？什么代码
        Log.i("wmgTest", "offset = " + offset + " scrollY = " + scrollY);
        if (scrollY == 0 || scrollY == offset) {
            return true;
        }
        return false;
    }

}
