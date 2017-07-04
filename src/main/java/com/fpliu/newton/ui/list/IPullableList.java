package com.fpliu.newton.ui.list;

import android.view.View;

import com.fpliu.newton.ui.pullable.PullableViewContainer;
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback;
import com.fpliu.newton.ui.pullable.Type;

import java.util.List;

/**
 * @author 792793182@qq.com 2017-06-29.
 */
public interface IPullableList<T, V extends View> extends ICommon<T> {

    PullableViewContainer<V> getPullableViewContainer();

    void canPullDown(boolean canPullDown);

    void canPullUp(boolean canPullUp);

    void finishRequestSuccess(Type type, List<T> items);

    void setRefreshOrLoadMoreCallback(final RefreshOrLoadMoreCallback callback);

    void refresh();
}
