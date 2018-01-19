package com.fpliu.newton.ui.list;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.fpliu.newton.ui.pullable.PullableViewContainer;
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback;

/**
 * @author 792793182@qq.com 2017-06-29.
 */
public class PullableScrollViewImpl {

    private PullableViewContainer<ScrollView> pullableViewContainer;

    public View init(Context context) {
        pullableViewContainer = new PullableViewContainer<>(context, ScrollView.class);
        ScrollView scrollView = pullableViewContainer.getPullableView();
        scrollView.setFillViewport(true);

        LinearLayout contentView = new LinearLayout(context);
        contentView.setOrientation(LinearLayout.VERTICAL);
        scrollView.addView(contentView, new ScrollView.LayoutParams(ScrollView.LayoutParams.MATCH_PARENT, ScrollView.LayoutParams.MATCH_PARENT));

        return pullableViewContainer;
    }

    public PullableViewContainer<ScrollView> getPullableViewContainer() {
        return pullableViewContainer;
    }

    public void canPullDown(boolean canPullDown) {
        pullableViewContainer.getRefreshLayout().setEnableRefresh(canPullDown);
    }

    public void canPullUp(boolean canPullUp) {
        pullableViewContainer.getRefreshLayout().setEnableLoadmore(canPullUp);
    }

    public void setRefreshOrLoadMoreCallback(RefreshOrLoadMoreCallback callback) {
        pullableViewContainer.setRefreshOrLoadMoreCallback(callback);
    }
}
