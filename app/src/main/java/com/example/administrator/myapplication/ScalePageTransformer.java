package com.example.administrator.myapplication;

import android.os.Build;
import android.support.v4.view.ViewPager;
import android.view.View;

/**
 *
 * description:  其实核心代码就是这个动画实现部分，这里设置了一个最大缩放和最小缩放比例，
 * 当处于最中间的view往左边滑动时，它的position值是小于0的，
 * 并且是越来越小,它右边的view的position是从1逐渐减小到0的
 */
public class ScalePageTransformer implements ViewPager.PageTransformer {

    public static final float MAX_SCALE = 1.2f;
    public static final float MIN_SCALE = 0.65f;
    /**核心就是实现transformPage(View page, float position)这个方法**/
    @Override
    public void transformPage(View page, float position) {

        if (position < -1) {
            position = -1;
        } else if (position > 1) {
            position = 1;
        }

        float tempScale = position < 0 ? 1 + position : 1 - position;

        float slope = (MAX_SCALE - MIN_SCALE) / 1;
        //一个公式
        float scaleValue = MIN_SCALE + tempScale * slope;
        page.setScaleX(scaleValue);
        page.setScaleY(scaleValue);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
            page.getParent().requestLayout();
        }
    }
}
