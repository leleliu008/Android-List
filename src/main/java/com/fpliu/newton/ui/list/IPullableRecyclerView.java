package com.fpliu.newton.ui.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.fpliu.newton.ui.pullable.PullType;
import com.fpliu.newton.ui.pullable.PullableViewContainer;
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback;
import com.fpliu.newton.ui.recyclerview.ItemAdapter;
import com.fpliu.newton.ui.recyclerview.ItemViewHolderAbs;
import com.fpliu.newton.ui.recyclerview.OnItemClickListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author 792793182@qq.com 2017-06-29.
 */
public interface IPullableRecyclerView<T, H extends ItemViewHolderAbs> {

    View init(Context context);

    void setOnItemClickListener(OnItemClickListener<T, H> onItemClickListener);

    void setItemAdapter(ItemAdapter<T, H> itemAdapter);

    ItemAdapter<T, H> getItemAdapter();

    void setItems(List<T> items);

    List<T> getItems();

    boolean addAll(Collection<? extends T> collection);

    boolean add(T item);

    T set(int location, T item);

    boolean remove(T item);

    void clear();

    boolean removeThenShowMessageIfEmpty(T item, CharSequence message);

    boolean removeThenShowImageIfEmpty(T item, int imageResId);

    boolean removeThenShowRefreshActionIfEmpty(T item, CharSequence message);

    boolean removeThenShowRefreshActionIfEmpty(T item, int imageResId);

    boolean removeThenShowActionIfEmpty(T item, CharSequence message, final String actionText, final Runnable action);

    void clearThenShowMessage(CharSequence message);

    void clearThenShowImage(int imageResId);

    void clearThenShowRefreshAction(CharSequence message);

    void clearThenShowRefreshAction(int imageResId);

    void clearThenShowAction(CharSequence message, final String actionText, final Runnable action);

    int getItemCount();

    T getItem(int position);

    int getItemViewType(int position);

    H onCreateViewHolder(ViewGroup parent, int viewType);

    void onBindViewHolder(H holder, int position, T item);

    void notifyDataSetChanged();

    void setViewBeforeBody(int layoutId);

    void setViewBeforeBody(View view);

    void setViewAfterBody(int layoutId);

    void setViewAfterBody(View view);

    PullableViewContainer<RecyclerView> getPullableViewContainer();

    void canPullDown(boolean canPullDown);

    void canPullUp(boolean canPullUp);

    void finishRequestSuccess(PullType type, List<T> items);

    void finishRequestSuccessWithMessageIfItemsEmpty(PullType type, List<T> items, String messageWhenItemsEmpty);

    void finishRequestSuccessWithMessageIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty);

    void finishRequestSuccessWithRefreshActionIfItemsEmpty(PullType type, List<T> items, String messageWhenItemsEmpty);

    void finishRequestSuccessWithRefreshActionIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty);

    void finishRequestSuccessWithActionIfItemsEmpty(PullType type, List<T> items, String messageWhenItemsEmpty, String actionText, Runnable action);

    void finishRequestSuccessWithActionIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty, String actionText, Runnable action);

    void setRefreshOrLoadMoreCallback(final RefreshOrLoadMoreCallback callback);

    void refresh();

    void setLayoutManager(RecyclerView.LayoutManager layoutManager);

    void addItemDecoration(RecyclerView.ItemDecoration itemDecoration);

    void removeItemDecoration(RecyclerView.ItemDecoration itemDecoration);

    ArrayList<RecyclerView.ItemDecoration> getItemDecorations();

    void clearItemDecorations();

    void setItemAnimator(RecyclerView.ItemAnimator itemAnimator);
}
