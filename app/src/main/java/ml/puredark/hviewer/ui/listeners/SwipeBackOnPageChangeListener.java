package ml.puredark.hviewer.ui.listeners;


import androidx.viewpager.widget.ViewPager;

import ml.puredark.hviewer.libraries.swipeback.dispatchactivity.SwipeBackActivity;

/**
 * Created by PureDark on 2016/9/29.
 */

public class SwipeBackOnPageChangeListener implements ViewPager.OnPageChangeListener {
    private SwipeBackActivity mActivity;

    public SwipeBackOnPageChangeListener(SwipeBackActivity activity) {
        mActivity = activity;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        if (mActivity == null)
            return;
        if (position == 0)
            mActivity.setSwipeBackEnable(true);
        else
            mActivity.setSwipeBackEnable(false);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
