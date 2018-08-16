package com.fpliu.newton.ui.list;

import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.widget.ScrollView;

import com.fpliu.newton.ui.base.BaseView;
import com.fpliu.newton.ui.base.LazyFragment;
import com.fpliu.newton.ui.pullable.PullableViewContainer;
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback;

/**
 * 可以下拉刷新和上拉加载更多
 *
 * @author 792793182@qq.com 2016-06-06.
 */
public abstract class PullableScrollViewFragment extends LazyFragment implements RefreshOrLoadMoreCallback<NestedScrollView> {

    private PullableScrollViewImpl pullable;

    @Override
    protected void onCreateViewLazy(BaseView baseView, Bundle savedInstanceState) {
        super.onCreateViewLazy(baseView, savedInstanceState);

        pullable = new PullableScrollViewImpl();

        View contentView = pullable.init(getActivity());
        CoordinatorLayout.LayoutParams lp = new CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT, CoordinatorLayout.LayoutParams.MATCH_PARENT);
        lp.setBehavior(new AppBarLayout.ScrollingViewBehavior());
        baseView.addView(contentView, lp);

        setRefreshOrLoadMoreCallback(this);
    }

    public void canPullDown(boolean canPullDown) {
        pullable.canPullDown(canPullDown);
    }

    public void canPullUp(boolean canPullUp) {
        pullable.canPullUp(canPullUp);
    }

    public void setRefreshOrLoadMoreCallback(RefreshOrLoadMoreCallback callback) {
        pullable.setRefreshOrLoadMoreCallback(callback);
    }

    public PullableViewContainer<NestedScrollView> getPullableViewContainer() {
        return pullable.getPullableViewContainer();
    }

    public void addViewInScrollView(View view, NestedScrollView.LayoutParams lp) {
        pullable.addViewInScrollView(view, lp);
    }

    public void addViewInScrollView(View view) {
        pullable.addViewInScrollView(view);
    }

    public <V extends View> V addViewInScrollView(int layoutId) {
        return pullable.addViewInScrollView(layoutId);
    }
}
