package com.fpliu.newton.ui.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import com.fpliu.newton.ui.pullable.PullableViewContainer;
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback;
import com.fpliu.newton.ui.stateview.StateView;

import androidx.core.widget.NestedScrollView;

/**
 * @author 792793182@qq.com 2017-06-29.
 */
public class PullableScrollViewImpl {

    private PullableViewContainer<MyNestedScrollView> pullableViewContainer;

    public View init(Context context) {
        pullableViewContainer = new PullableViewContainer<>(MyNestedScrollView.class, new StateView(context));
        NestedScrollView scrollView = pullableViewContainer.getPullableView();
        scrollView.setFillViewport(true);
        return pullableViewContainer;
    }

    public PullableViewContainer<MyNestedScrollView> getPullableViewContainer() {
        return pullableViewContainer;
    }

    public void canPullDown(boolean canPullDown) {
        pullableViewContainer.setEnableRefresh(canPullDown);
    }

    public void canPullUp(boolean canPullUp) {
        pullableViewContainer.setEnableLoadMore(canPullUp);
    }

    public void setRefreshOrLoadMoreCallback(RefreshOrLoadMoreCallback<ScrollView> callback) {
        pullableViewContainer.setRefreshOrLoadMoreCallback(callback);
    }

    public void addViewInScrollView(View view, NestedScrollView.LayoutParams lp) {
        NestedScrollView scrollView = pullableViewContainer.getPullableView();
        scrollView.addView(view, lp);
    }

    public void addViewInScrollView(View view) {
        NestedScrollView scrollView = pullableViewContainer.getPullableView();
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        if (lp == null) {
            scrollView.addView(view, new NestedScrollView.LayoutParams(ScrollView.LayoutParams.MATCH_PARENT, ScrollView.LayoutParams.MATCH_PARENT));
        } else {
            scrollView.addView(view, new NestedScrollView.LayoutParams(lp.width, lp.height));
        }
    }

    /**
     * 注意：这几个重载的方法不同互相调用，因为子类可能会重写，会出现不肯想象的结果
     *
     * @param layoutId 布局文件的ID
     */
    public <V extends View> V addViewInScrollView(int layoutId) {
        NestedScrollView scrollView = pullableViewContainer.getPullableView();
        View.inflate(scrollView.getContext(), layoutId, scrollView);
        return (V) scrollView.getChildAt(0);
    }
}
