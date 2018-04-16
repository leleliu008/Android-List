package com.fpliu.newton.ui.list;

import android.view.View;

import com.fpliu.newton.ui.pullable.PullType;
import com.fpliu.newton.ui.pullable.PullableViewContainer;
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback;

import java.util.List;

/**
 * @author 792793182@qq.com 2017-06-29.
 */
public interface IPullable<T, V extends View> {

    PullableViewContainer<V> getPullableViewContainer();


    void canPullDown(boolean canPullDown);

    void canPullUp(boolean canPullUp);


    void finishRequestSuccess(PullType type, List<T> items);


    void finishRequestSuccessWithErrorImageIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty);

    void finishRequestSuccessWithErrorMessageIfItemsEmpty(PullType type, List<T> items, String messageWhenItemsEmpty);

    void finishRequestSuccessWithErrorImageAndMessageIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty, String messageWhenItemsEmpty);


    void finishRequestSuccessWithRefreshActionIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty);

    void finishRequestSuccessWithRefreshActionIfItemsEmpty(PullType type, List<T> items, String messageWhenItemsEmpty);

    void finishRequestSuccessWithRefreshActionIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty, String messageWhenItemsEmpty);


    void finishRequestSuccessWithActionIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty, String actionText, Runnable action);

    void finishRequestSuccessWithActionIfItemsEmpty(PullType type, List<T> items, String messageWhenItemsEmpty, String actionText, Runnable action);

    void finishRequestSuccessWithActionIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty, String messageWhenItemsEmpty, String actionText, Runnable action);



    boolean removeThenShowMessageIfEmpty(T item, CharSequence message);

    boolean removeThenShowImageIfEmpty(T item, int imageResId);

    boolean removeThenShowImageAndTextIfEmpty(T item, int imageResId, CharSequence message);


    boolean removeThenShowRefreshActionIfEmpty(T item, CharSequence message);

    boolean removeThenShowRefreshActionIfEmpty(T item, int imageResId);

    boolean removeThenShowRefreshActionIfEmpty(T item, int imageResId, CharSequence message);


    boolean removeThenShowActionIfEmpty(T item, int imageResId, final String actionText, final Runnable action);

    boolean removeThenShowActionIfEmpty(T item, CharSequence message, final String actionText, final Runnable action);

    boolean removeThenShowActionIfEmpty(T item, int imageResId, CharSequence message, final String actionText, final Runnable action);


    void clearThenShowMessage(CharSequence message);

    void clearThenShowImage(int imageResId);

    void clearThenShowImageAndText(int imageResId, CharSequence message);


    void clearThenShowRefreshAction(CharSequence message);

    void clearThenShowRefreshAction(int imageResId);

    void clearThenShowRefreshAction(int imageResId, CharSequence message);


    void clearThenShowAction(int imageResId, final String actionText, final Runnable action);

    void clearThenShowAction(CharSequence message, final String actionText, final Runnable action);

    void clearThenShowAction(int imageResId, CharSequence message, final String actionText, final Runnable action);



    void setRefreshOrLoadMoreCallback(final RefreshOrLoadMoreCallback<V> callback);

    void refresh();
}
