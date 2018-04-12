package com.fpliu.newton.ui.list;

import android.os.Bundle;
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
public abstract class PullableScrollViewFragment extends LazyFragment implements RefreshOrLoadMoreCallback<ScrollView> {

    private PullableScrollViewImpl pullable;

    @Override
    protected void onCreateViewLazy(BaseView baseView, Bundle savedInstanceState) {
        super.onCreateViewLazy(baseView, savedInstanceState);

        pullable = new PullableScrollViewImpl();
        baseView.addViewInBody(pullable.init(getActivity()));
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

    public PullableViewContainer<ScrollView> getPullableViewContainer() {
        return pullable.getPullableViewContainer();
    }

    public void addViewInScrollView(View view, ScrollView.LayoutParams lp) {
        pullable.addViewInScrollView(view, lp);
    }

    public void addViewInScrollView(View view) {
        pullable.addViewInScrollView(view);
    }

    public <V extends View> V addViewInScrollView(int layoutId) {
        return pullable.addViewInScrollView(layoutId);
    }
}
