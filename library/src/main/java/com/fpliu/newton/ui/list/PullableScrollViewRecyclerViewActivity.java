package com.fpliu.newton.ui.list;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.fpliu.newton.ui.base.BaseActivity;
import com.fpliu.newton.ui.pullable.PullType;
import com.fpliu.newton.ui.pullable.PullableViewContainer;
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback;
import com.fpliu.newton.ui.recyclerview.OnItemClickListener;
import com.fpliu.newton.ui.recyclerview.adapter.ItemAdapter;
import com.fpliu.newton.ui.recyclerview.holder.ItemViewHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 可以下拉刷新和上拉加载更多
 *
 * @author 792793182@qq.com 2016-06-06.
 */
public abstract class PullableScrollViewRecyclerViewActivity<T> extends BaseActivity
    implements IPullableScrollViewRecyclerView<T>,
    OnItemClickListener<T>, RefreshOrLoadMoreCallback<NestedScrollView> {

    private IPullableScrollViewRecyclerView<T> pullable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pullable = new PullableScrollViewRecyclerViewImpl<>();

        View contentView = pullable.init(this);
        CoordinatorLayout.LayoutParams lp = new CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT, CoordinatorLayout.LayoutParams.MATCH_PARENT);
        lp.setBehavior(new AppBarLayout.ScrollingViewBehavior());
        addContentView(contentView, lp);

        setItemAdapter(new ItemAdapter<T>(null) {

            @Override
            public int onBindLayout(ViewGroup parent, int viewType) {
                return PullableScrollViewRecyclerViewActivity.this.onBindLayout(parent, viewType);
            }

            @Override
            public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                ItemViewHolder itemViewHolder = super.onCreateViewHolder(parent, viewType);
                PullableScrollViewRecyclerViewActivity.this.onCreateViewHolder(itemViewHolder, parent, viewType);
                return itemViewHolder;
            }

            public void onBindViewHolder(ItemViewHolder holder, int position, T item) {
                PullableScrollViewRecyclerViewActivity.this.onBindViewHolder(holder, position, item);
            }

            @Override
            public int getItemViewType(int position) {
                return PullableScrollViewRecyclerViewActivity.this.getItemViewType(position);
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
    public PullableViewContainer<NestedScrollView> getPullableViewContainer() {
        return pullable.getPullableViewContainer();
    }

    @Override
    public RecyclerView getRecyclerView() {
        return pullable.getRecyclerView();
    }

    @Override
    public void refresh() {
        pullable.refresh();
    }

    @Override
    public View init(Context context) {
        return pullable.init(context);
    }

    @Override
    public void setItemAdapter(ItemAdapter<T> itemAdapter) {
        pullable.setItemAdapter(itemAdapter);
    }

    @Override
    public ItemAdapter<T> getItemAdapter() {
        return pullable.getItemAdapter();
    }

    @Override
    public void setItems(List<T> items) {
        pullable.setItems(items);
    }

    @Override
    public List<T> getItems() {
        return pullable.getItems();
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return pullable.addAll(collection);
    }

    @Override
    public boolean add(T item) {
        return pullable.add(item);
    }

    @Override
    public T set(int location, T item) {
        return pullable.set(location, item);
    }

    @Override
    public T removeAt(int position) {
        return pullable.removeAt(position);
    }

    @Override
    public T removeLastItem() {
        return pullable.removeLastItem();
    }

    @Override
    public boolean remove(T item) {
        return pullable.remove(item);
    }

    @Override
    public void clear() {
        pullable.clear();
    }

    @Override
    public T getItem(int position) {
        return pullable.getItem(position);
    }

    @Override
    public T getLastItem() {
        return pullable.getLastItem();
    }

    @Override
    public int getItemCount() {
        return pullable.getItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        return pullable.getItemViewType(position);
    }

    @Override
    public void notifyDataSetChanged() {
        pullable.notifyDataSetChanged();
    }

    @Override
    public View setViewBeforeBody(int layoutId) {
        return pullable.setViewBeforeBody(layoutId);
    }

    @Override
    public void setViewBeforeBody(View view) {
        pullable.setViewBeforeBody(view);
    }

    @Override
    public View setViewAfterBody(int layoutId) {
        return pullable.setViewAfterBody(layoutId);
    }

    @Override
    public void setViewAfterBody(View view) {
        pullable.setViewAfterBody(view);
    }

    @Override
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        pullable.setLayoutManager(layoutManager);
    }

    @Override
    public void setItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        pullable.setItemDecoration(itemDecoration);
    }

    @Override
    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        pullable.addItemDecoration(itemDecoration);
    }

    @Override
    public void removeItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        pullable.removeItemDecoration(itemDecoration);
    }

    @Override
    public ArrayList<RecyclerView.ItemDecoration> getItemDecorations() {
        return pullable.getItemDecorations();
    }

    @Override
    public void clearItemDecorations() {
        pullable.clearItemDecorations();
    }

    @Override
    public void setItemAnimator(RecyclerView.ItemAnimator itemAnimator) {
        pullable.setItemAnimator(itemAnimator);
    }

    @Override
    public void asList() {
        pullable.asList();
    }

    @Override
    public void asGrid(int columnNumber) {
        pullable.asGrid(columnNumber);
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        pullable.setOnItemClickListener(onItemClickListener);
    }

    @Override
    public void onCreateViewHolder(ItemViewHolder holder, ViewGroup parent, int viewType) {

    }

    @Override
    public void onItemClick(ItemViewHolder holder, int position, T item) {

    }
}
