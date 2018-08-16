package com.fpliu.newton.ui.list;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
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
public abstract class PullableRecyclerViewActivity<T> extends BaseActivity
    implements IPullableRecyclerView<T>,
    OnItemClickListener<T>, RefreshOrLoadMoreCallback<RecyclerView> {

    private IPullableRecyclerView<T> pullableRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pullableRecyclerView = new PullableRecyclerViewImpl<>();

        View contentView = pullableRecyclerView.init(this);
        CoordinatorLayout.LayoutParams lp = new CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT, CoordinatorLayout.LayoutParams.MATCH_PARENT);
        lp.setBehavior(new AppBarLayout.ScrollingViewBehavior());
        addContentView(contentView, lp);

        setItemAdapter(new ItemAdapter<T>(null) {

            @Override
            public int onBindLayout(ViewGroup parent, int viewType) {
                return PullableRecyclerViewActivity.this.onBindLayout(parent, viewType);
            }

            @Override
            public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                ItemViewHolder itemViewHolder = super.onCreateViewHolder(parent, viewType);
                PullableRecyclerViewActivity.this.onCreateViewHolder(itemViewHolder, parent, viewType);
                return itemViewHolder;
            }

            public void onBindViewHolder(ItemViewHolder holder, int position, T item) {
                PullableRecyclerViewActivity.this.onBindViewHolder(holder, position, item);
            }

            @Override
            public int getItemViewType(int position) {
                return PullableRecyclerViewActivity.this.getItemViewType(position);
            }
        });
        setOnItemClickListener(this);
        setRefreshOrLoadMoreCallback(this);
    }

    @Override
    public void canPullDown(boolean canPullDown) {
        pullableRecyclerView.canPullDown(canPullDown);
    }

    @Override
    public void canPullUp(boolean canPullUp) {
        pullableRecyclerView.canPullUp(canPullUp);
    }

    @Override
    public void finishRequestSuccess(PullType type, List<T> items) {
        pullableRecyclerView.finishRequestSuccess(type, items);
    }

    @Override
    public void finishRequestSuccessWithErrorMessageIfItemsEmpty(PullType type, List<T> items, String messageWhenItemsEmpty) {
        pullableRecyclerView.finishRequestSuccessWithErrorMessageIfItemsEmpty(type, items, messageWhenItemsEmpty);
    }

    @Override
    public void finishRequestSuccessWithErrorImageIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty) {
        pullableRecyclerView.finishRequestSuccessWithErrorImageIfItemsEmpty(type, items, imageResIdWhenItemsEmpty);
    }

    @Override
    public void finishRequestSuccessWithErrorImageAndMessageIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty, String messageWhenItemsEmpty) {
        pullableRecyclerView.finishRequestSuccessWithErrorImageAndMessageIfItemsEmpty(type, items, imageResIdWhenItemsEmpty, messageWhenItemsEmpty);
    }

    @Override
    public void finishRequestSuccessWithRefreshActionIfItemsEmpty(PullType type, List<T> items, String messageWhenItemsEmpty) {
        pullableRecyclerView.finishRequestSuccessWithRefreshActionIfItemsEmpty(type, items, messageWhenItemsEmpty);
    }

    @Override
    public void finishRequestSuccessWithRefreshActionIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty) {
        pullableRecyclerView.finishRequestSuccessWithRefreshActionIfItemsEmpty(type, items, imageResIdWhenItemsEmpty);
    }

    @Override
    public void finishRequestSuccessWithRefreshActionIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty, String messageWhenItemsEmpty) {
        pullableRecyclerView.finishRequestSuccessWithRefreshActionIfItemsEmpty(type, items, imageResIdWhenItemsEmpty, messageWhenItemsEmpty);
    }

    @Override
    public void finishRequestSuccessWithActionIfItemsEmpty(PullType type, List<T> items, String messageWhenItemsEmpty, String actionText, Runnable action) {
        pullableRecyclerView.finishRequestSuccessWithActionIfItemsEmpty(type, items, messageWhenItemsEmpty, actionText, action);
    }

    @Override
    public void finishRequestSuccessWithActionIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty, String actionText, Runnable action) {
        pullableRecyclerView.finishRequestSuccessWithActionIfItemsEmpty(type, items, imageResIdWhenItemsEmpty, actionText, action);
    }

    @Override
    public void finishRequestSuccessWithActionIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty, String messageWhenItemsEmpty, String actionText, Runnable action) {
        pullableRecyclerView.finishRequestSuccessWithActionIfItemsEmpty(type, items, imageResIdWhenItemsEmpty, messageWhenItemsEmpty, actionText, action);
    }

    @Override
    public boolean removeThenShowMessageIfEmpty(T item, CharSequence message) {
        return pullableRecyclerView.removeThenShowMessageIfEmpty(item, message);
    }

    @Override
    public boolean removeThenShowImageIfEmpty(T item, int imageResId) {
        return pullableRecyclerView.removeThenShowImageIfEmpty(item, imageResId);
    }

    @Override
    public boolean removeThenShowImageAndTextIfEmpty(T item, int imageResId, CharSequence message) {
        return pullableRecyclerView.removeThenShowImageAndTextIfEmpty(item, imageResId, message);
    }

    @Override
    public boolean removeThenShowRefreshActionIfEmpty(T item, CharSequence message) {
        return pullableRecyclerView.removeThenShowRefreshActionIfEmpty(item, message);
    }

    @Override
    public boolean removeThenShowRefreshActionIfEmpty(T item, int imageResId) {
        return pullableRecyclerView.removeThenShowRefreshActionIfEmpty(item, imageResId);
    }

    @Override
    public boolean removeThenShowRefreshActionIfEmpty(T item, int imageResId, CharSequence message) {
        return pullableRecyclerView.removeThenShowRefreshActionIfEmpty(item, imageResId, message);
    }

    @Override
    public boolean removeThenShowActionIfEmpty(T item, CharSequence message, String actionText, Runnable action) {
        return pullableRecyclerView.removeThenShowActionIfEmpty(item, message, actionText, action);
    }

    @Override
    public boolean removeThenShowActionIfEmpty(T item, int imageResId, String actionText, Runnable action) {
        return pullableRecyclerView.removeThenShowActionIfEmpty(item, imageResId, actionText, action);
    }

    @Override
    public boolean removeThenShowActionIfEmpty(T item, int imageResId, CharSequence message, String actionText, Runnable action) {
        return pullableRecyclerView.removeThenShowActionIfEmpty(item, imageResId, message, actionText, action);
    }

    @Override
    public void clearThenShowMessage(CharSequence message) {
        pullableRecyclerView.clearThenShowMessage(message);
    }

    @Override
    public void clearThenShowImage(int imageResId) {
        pullableRecyclerView.clearThenShowImage(imageResId);
    }

    @Override
    public void clearThenShowImageAndText(int imageResId, CharSequence message) {
        pullableRecyclerView.clearThenShowImageAndText(imageResId, message);
    }

    @Override
    public void clearThenShowRefreshAction(CharSequence message) {
        pullableRecyclerView.clearThenShowRefreshAction(message);
    }

    @Override
    public void clearThenShowRefreshAction(int imageResId) {
        pullableRecyclerView.clearThenShowRefreshAction(imageResId);
    }

    @Override
    public void clearThenShowRefreshAction(int imageResId, CharSequence message) {
        pullableRecyclerView.clearThenShowRefreshAction(imageResId, message);
    }

    @Override
    public void clearThenShowAction(CharSequence message, String actionText, Runnable action) {
        pullableRecyclerView.clearThenShowAction(message, actionText, action);
    }

    @Override
    public void clearThenShowAction(int imageResId, String actionText, Runnable action) {
        pullableRecyclerView.clearThenShowAction(imageResId, actionText, action);
    }

    @Override
    public void clearThenShowAction(int imageResId, CharSequence message, String actionText, Runnable action) {
        pullableRecyclerView.clearThenShowAction(imageResId, message, actionText, action);
    }

    @Override
    public void setRefreshOrLoadMoreCallback(RefreshOrLoadMoreCallback callback) {
        pullableRecyclerView.setRefreshOrLoadMoreCallback(callback);
    }

    @Override
    public PullableViewContainer<RecyclerView> getPullableViewContainer() {
        return pullableRecyclerView.getPullableViewContainer();
    }

    @Override
    public RecyclerView getRecyclerView() {
        return pullableRecyclerView.getRecyclerView();
    }

    @Override
    public void refresh() {
        pullableRecyclerView.refresh();
    }

    @Override
    public View init(Context context) {
        return pullableRecyclerView.init(context);
    }

    @Override
    public void setItemAdapter(ItemAdapter<T> itemAdapter) {
        pullableRecyclerView.setItemAdapter(itemAdapter);
    }

    @Override
    public ItemAdapter<T> getItemAdapter() {
        return pullableRecyclerView.getItemAdapter();
    }

    @Override
    public void setItems(List<T> items) {
        pullableRecyclerView.setItems(items);
    }

    @Override
    public List<T> getItems() {
        return pullableRecyclerView.getItems();
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return pullableRecyclerView.addAll(collection);
    }

    @Override
    public boolean add(T item) {
        return pullableRecyclerView.add(item);
    }

    @Override
    public T set(int location, T item) {
        return pullableRecyclerView.set(location, item);
    }

    @Override
    public T removeAt(int position) {
        return pullableRecyclerView.removeAt(position);
    }

    @Override
    public T removeLastItem() {
        return pullableRecyclerView.removeLastItem();
    }

    @Override
    public boolean remove(T item) {
        return pullableRecyclerView.remove(item);
    }

    @Override
    public void clear() {
        pullableRecyclerView.clear();
    }

    @Override
    public T getItem(int position) {
        return pullableRecyclerView.getItem(position);
    }

    @Override
    public T getLastItem() {
        return pullableRecyclerView.getLastItem();
    }

    @Override
    public int getItemCount() {
        return pullableRecyclerView.getItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        return pullableRecyclerView.getItemViewType(position);
    }

    @Override
    public void notifyDataSetChanged() {
        pullableRecyclerView.notifyDataSetChanged();
    }

    @Override
    public View setViewBeforeBody(int layoutId) {
        return pullableRecyclerView.setViewBeforeBody(layoutId);
    }

    @Override
    public void setViewBeforeBody(View view) {
        pullableRecyclerView.setViewBeforeBody(view);
    }

    @Override
    public View setViewAfterBody(int layoutId) {
        return pullableRecyclerView.setViewAfterBody(layoutId);
    }

    @Override
    public void setViewAfterBody(View view) {
        pullableRecyclerView.setViewAfterBody(view);
    }

    @Override
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        pullableRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void setItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        pullableRecyclerView.setItemDecoration(itemDecoration);
    }

    @Override
    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        pullableRecyclerView.addItemDecoration(itemDecoration);
    }

    @Override
    public void removeItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        pullableRecyclerView.removeItemDecoration(itemDecoration);
    }

    @Override
    public ArrayList<RecyclerView.ItemDecoration> getItemDecorations() {
        return pullableRecyclerView.getItemDecorations();
    }

    @Override
    public void clearItemDecorations() {
        pullableRecyclerView.clearItemDecorations();
    }

    @Override
    public void setItemAnimator(RecyclerView.ItemAnimator itemAnimator) {
        pullableRecyclerView.setItemAnimator(itemAnimator);
    }

    @Override
    public void asList() {
        pullableRecyclerView.asList();
    }

    @Override
    public void asGrid(int columnNumber) {
        pullableRecyclerView.asGrid(columnNumber);
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        pullableRecyclerView.setOnItemClickListener(onItemClickListener);
    }

    @Override
    public void onCreateViewHolder(ItemViewHolder holder, ViewGroup parent, int viewType) {

    }

    @Override
    public void onItemClick(ItemViewHolder holder, int position, T item) {

    }
}
