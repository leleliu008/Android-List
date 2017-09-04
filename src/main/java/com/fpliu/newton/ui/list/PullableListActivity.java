package com.fpliu.newton.ui.list;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.fpliu.newton.ui.base.BaseActivity;
import com.fpliu.newton.ui.pullable.PullType;
import com.fpliu.newton.ui.pullable.PullableViewContainer;
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback;

import java.util.Collection;
import java.util.List;

/**
 * 可以下拉刷新和上拉加载更多
 *
 * @author 792793182@qq.com 2016-06-06.
 */
public abstract class PullableListActivity<T> extends BaseActivity
        implements IPullable<T, ListView>, IList<T, ListView>,
        AdapterView.OnItemClickListener, RefreshOrLoadMoreCallback<ListView> {

    private IPullable<T, ListView> pullable;
    private IList<T, ListView> list;

    private View headerView;

    private Object headerData;

    private boolean headerIsSelectable;

    private View footerView;

    private Object footerData;

    private boolean footerIsSelectable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pullable = new PullableListImpl<>();
        list = (IList<T, ListView>) pullable;
        addContentView(list.init(this));
        setOnItemClickListener(this);

        if (headerView != null) {
            list.addHeaderView(headerView, headerData, headerIsSelectable);
        }

        if (footerView != null) {
            list.addHeaderView(footerView, footerData, footerIsSelectable);
        }

        setItemAdapter(new ItemAdapter<T>(null) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return PullableListActivity.this.getItemView(position, convertView, parent);
            }

            @Override
            public int getViewTypeCount() {
                return PullableListActivity.this.getItemViewTypeCount();
            }

            @Override
            public int getItemViewType(int position) {
                return PullableListActivity.this.getItemViewType(position);
            }
        });
        setRefreshOrLoadMoreCallback(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

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
    public PullableViewContainer<ListView> getPullableViewContainer() {
        return pullable.getPullableViewContainer();
    }

    @Override
    public void refresh() {
        pullable.refresh();
    }

    @Override
    public View init(Context context) {
        return list.init(context);
    }

    @Override
    public ListView getListView() {
        return list.getListView();
    }

    @Override
    public void setItemAdapter(ItemAdapter<T> itemAdapter) {
        list.setItemAdapter(itemAdapter);
    }

    @Override
    public ItemAdapter<T> getItemAdapter() {
        return list.getItemAdapter();
    }

    @Override
    public void setItems(List<T> items) {
        list.setItems(items);
    }

    @Override
    public List<T> getItems() {
        return list.getItems();
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return list.addAll(collection);
    }

    @Override
    public boolean add(T item) {
        return list.add(item);
    }

    @Override
    public T set(int location, T item) {
        return list.set(location, item);
    }

    @Override
    public boolean remove(T item) {
        return list.remove(item);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public T getItem(int position) {
        return list.getItem(position);
    }

    @Override
    public int getItemCount() {
        return list.getItemCount();
    }

    @Override
    public int getItemViewTypeCount() {
        return list.getItemViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        return list.getItemViewType(position);
    }

    @Override
    public void notifyDataSetChanged() {
        list.notifyDataSetChanged();
    }

    @Override
    public void setDividerHeight(int height) {
        list.setDividerHeight(height);
    }

    @Override
    public void setViewBeforeBody(int layoutId) {
        list.setViewBeforeBody(layoutId);
    }

    @Override
    public void setViewBeforeBody(View view) {
        list.setViewBeforeBody(view);
    }

    @Override
    public void setViewAfterBody(int layoutId) {
        list.setViewAfterBody(layoutId);
    }

    @Override
    public void setViewAfterBody(View view) {
        list.setViewAfterBody(view);
    }

    //必须在super.onCreate()之前调用
    @Override
    public void addHeaderView(View view, Object data, boolean isSelectable) {
        this.headerView = view;
        this.headerData = data;
        this.headerIsSelectable = isSelectable;
    }

    //必须在super.onCreate()之前调用
    @Override
    public void addFooterView(View view, Object data, boolean isSelectable) {
        this.footerView = view;
        this.footerData = data;
        this.footerIsSelectable = isSelectable;
    }

    @Override
    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        list.setOnItemClickListener(listener);
    }
}
