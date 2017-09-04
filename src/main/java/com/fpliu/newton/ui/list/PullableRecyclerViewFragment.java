package com.fpliu.newton.ui.list;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.fpliu.newton.ui.base.BaseView;
import com.fpliu.newton.ui.base.LazyFragment;
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
 * @author 792793182@qq.com 2016-06-06.
 */
public abstract class PullableRecyclerViewFragment<T, H extends ItemViewHolderAbs> extends LazyFragment
        implements IPullable<T, RecyclerView>, IRecyclerView<T, H>,
        OnItemClickListener<T, H>, RefreshOrLoadMoreCallback<RecyclerView> {

    private IPullable<T, RecyclerView> pullable;
    private IRecyclerView<T, H> recyclerView;

    @Override
    protected void onCreateViewLazy(BaseView baseView, Bundle savedInstanceState) {
        super.onCreateViewLazy(baseView, savedInstanceState);

        Activity activity = getActivity();

        pullable = new PullableRecyclerViewImpl<>();
        recyclerView = (IRecyclerView<T, H>) pullable;
        addContentView(recyclerView.init(activity));
        setItemAdapter(new ItemAdapter<T, H>(null) {
            @Override
            public H onCreateViewHolder(ViewGroup parent, int viewType) {
                return PullableRecyclerViewFragment.this.onCreateViewHolder(parent, viewType);
            }

            @Override
            public void onBindViewHolder(H holder, int position, T item) {
                PullableRecyclerViewFragment.this.onBindViewHolder(holder, position, item);
            }

            @Override
            public int getItemViewType(int position) {
                return PullableRecyclerViewFragment.this.getItemViewType(position);
            }
        });
        setOnItemClickListener(this);
        setRefreshOrLoadMoreCallback(this);
    }

    @Override
    public void canPullDown(boolean canPullDown) {
        pullable.canPullDown(canPullDown);
    }

    @Override
    public void canPullUp(boolean canPullUp) {
        pullable.canPullUp(canPullUp);
    }

    @Override
    public void finishRequestSuccess(PullType type, List<T> items) {
        pullable.finishRequestSuccess(type, items);
    }

    @Override
    public void finishRequestSuccessWithErrorMessageIfItemsEmpty(PullType type, List<T> items, String messageWhenItemsEmpty) {
        pullable.finishRequestSuccessWithErrorMessageIfItemsEmpty(type, items, messageWhenItemsEmpty);
    }

    @Override
    public void finishRequestSuccessWithErrorImageIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty) {
        pullable.finishRequestSuccessWithErrorImageIfItemsEmpty(type, items, imageResIdWhenItemsEmpty);
    }

    @Override
    public void finishRequestSuccessWithErrorImageAndMessageIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty, String messageWhenItemsEmpty) {
        pullable.finishRequestSuccessWithErrorImageAndMessageIfItemsEmpty(type, items, imageResIdWhenItemsEmpty, messageWhenItemsEmpty);
    }

    @Override
    public void finishRequestSuccessWithRefreshActionIfItemsEmpty(PullType type, List<T> items, String messageWhenItemsEmpty) {
        pullable.finishRequestSuccessWithRefreshActionIfItemsEmpty(type, items, messageWhenItemsEmpty);
    }

    @Override
    public void finishRequestSuccessWithRefreshActionIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty) {
        pullable.finishRequestSuccessWithRefreshActionIfItemsEmpty(type, items, imageResIdWhenItemsEmpty);
    }

    @Override
    public void finishRequestSuccessWithRefreshActionIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty, String messageWhenItemsEmpty) {
        pullable.finishRequestSuccessWithRefreshActionIfItemsEmpty(type, items, imageResIdWhenItemsEmpty, messageWhenItemsEmpty);
    }

    @Override
    public void finishRequestSuccessWithActionIfItemsEmpty(PullType type, List<T> items, String messageWhenItemsEmpty, String actionText, Runnable action) {
        pullable.finishRequestSuccessWithActionIfItemsEmpty(type, items, messageWhenItemsEmpty, actionText, action);
    }

    @Override
    public void finishRequestSuccessWithActionIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty, String actionText, Runnable action) {
        pullable.finishRequestSuccessWithActionIfItemsEmpty(type, items, imageResIdWhenItemsEmpty, actionText, action);
    }

    @Override
    public void finishRequestSuccessWithActionIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty, String messageWhenItemsEmpty, String actionText, Runnable action) {
        pullable.finishRequestSuccessWithActionIfItemsEmpty(type, items, imageResIdWhenItemsEmpty, messageWhenItemsEmpty, actionText, action);
    }

    @Override
    public boolean removeThenShowMessageIfEmpty(T item, CharSequence message) {
        return pullable.removeThenShowMessageIfEmpty(item, message);
    }

    @Override
    public boolean removeThenShowImageIfEmpty(T item, int imageResId) {
        return pullable.removeThenShowImageIfEmpty(item, imageResId);
    }

    @Override
    public boolean removeThenShowImageAndTextIfEmpty(T item, int imageResId, CharSequence message) {
        return pullable.removeThenShowImageAndTextIfEmpty(item, imageResId, message);
    }

    @Override
    public boolean removeThenShowRefreshActionIfEmpty(T item, CharSequence message) {
        return pullable.removeThenShowRefreshActionIfEmpty(item, message);
    }

    @Override
    public boolean removeThenShowRefreshActionIfEmpty(T item, int imageResId) {
        return pullable.removeThenShowRefreshActionIfEmpty(item, imageResId);
    }

    @Override
    public boolean removeThenShowRefreshActionIfEmpty(T item, int imageResId, CharSequence message) {
        return pullable.removeThenShowRefreshActionIfEmpty(item, imageResId, message);
    }

    @Override
    public boolean removeThenShowActionIfEmpty(T item, CharSequence message, String actionText, Runnable action) {
        return pullable.removeThenShowActionIfEmpty(item, message, actionText, action);
    }

    @Override
    public boolean removeThenShowActionIfEmpty(T item, int imageResId, String actionText, Runnable action) {
        return pullable.removeThenShowActionIfEmpty(item, imageResId, actionText, action);
    }

    @Override
    public boolean removeThenShowActionIfEmpty(T item, int imageResId, CharSequence message, String actionText, Runnable action) {
        return pullable.removeThenShowActionIfEmpty(item, imageResId, message, actionText, action);
    }

    @Override
    public void clearThenShowMessage(CharSequence message) {
        pullable.clearThenShowMessage(message);
    }

    @Override
    public void clearThenShowImage(int imageResId) {
        pullable.clearThenShowImage(imageResId);
    }

    @Override
    public void clearThenShowImageAndText(int imageResId, CharSequence message) {
        pullable.clearThenShowImageAndText(imageResId, message);
    }

    @Override
    public void clearThenShowRefreshAction(CharSequence message) {
        pullable.clearThenShowRefreshAction(message);
    }

    @Override
    public void clearThenShowRefreshAction(int imageResId) {
        pullable.clearThenShowRefreshAction(imageResId);
    }

    @Override
    public void clearThenShowRefreshAction(int imageResId, CharSequence message) {
        pullable.clearThenShowRefreshAction(imageResId, message);
    }

    @Override
    public void clearThenShowAction(CharSequence message, String actionText, Runnable action) {
        pullable.clearThenShowAction(message, actionText, action);
    }

    @Override
    public void clearThenShowAction(int imageResId, String actionText, Runnable action) {
        pullable.clearThenShowAction(imageResId, actionText, action);
    }

    @Override
    public void clearThenShowAction(int imageResId, CharSequence message, String actionText, Runnable action) {
        pullable.clearThenShowAction(imageResId, message, actionText, action);
    }

    @Override
    public void setRefreshOrLoadMoreCallback(RefreshOrLoadMoreCallback callback) {
        pullable.setRefreshOrLoadMoreCallback(callback);
    }

    @Override
    public PullableViewContainer<RecyclerView> getPullableViewContainer() {
        return pullable.getPullableViewContainer();
    }

    @Override
    public void refresh() {
        pullable.refresh();
    }

    @Override
    public View init(Context context) {
        return recyclerView.init(context);
    }

    @Override
    public void setItemAdapter(ItemAdapter<T, H> itemAdapter) {
        recyclerView.setItemAdapter(itemAdapter);
    }

    @Override
    public ItemAdapter<T, H> getItemAdapter() {
        return recyclerView.getItemAdapter();
    }

    @Override
    public void setItems(List<T> items) {
        recyclerView.setItems(items);
    }

    @Override
    public List<T> getItems() {
        return recyclerView.getItems();
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return recyclerView.addAll(collection);
    }

    @Override
    public boolean add(T item) {
        return recyclerView.add(item);
    }

    @Override
    public T set(int location, T item) {
        return recyclerView.set(location, item);
    }

    @Override
    public boolean remove(T item) {
        return recyclerView.remove(item);
    }

    @Override
    public void clear() {
        recyclerView.clear();
    }

    @Override
    public T getItem(int position) {
        return recyclerView.getItem(position);
    }

    @Override
    public int getItemCount() {
        return recyclerView.getItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        return recyclerView.getItemViewType(position);
    }

    @Override
    public void notifyDataSetChanged() {
        recyclerView.notifyDataSetChanged();
    }


    @Override
    public void setViewBeforeBody(int layoutId) {
        recyclerView.setViewBeforeBody(layoutId);
    }

    @Override
    public void setViewBeforeBody(View view) {
        recyclerView.setViewBeforeBody(view);
    }

    @Override
    public void setViewAfterBody(int layoutId) {
        recyclerView.setViewAfterBody(layoutId);
    }

    @Override
    public void setViewAfterBody(View view) {
        recyclerView.setViewAfterBody(view);
    }

    @Override
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        recyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    public void removeItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        recyclerView.removeItemDecoration(itemDecoration);
    }

    @Override
    public ArrayList<RecyclerView.ItemDecoration> getItemDecorations() {
        return recyclerView.getItemDecorations();
    }

    @Override
    public void clearItemDecorations() {
        recyclerView.clearItemDecorations();
    }

    @Override
    public void setItemAnimator(RecyclerView.ItemAnimator itemAnimator) {
        recyclerView.setItemAnimator(itemAnimator);
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener<T, H> onItemClickListener) {
        recyclerView.setOnItemClickListener(onItemClickListener);
    }

    @Override
    public void onItemClick(H holder, int position, T item) {

    }
}
