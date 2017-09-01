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
        implements IPullableList<T, ListView>,
        AdapterView.OnItemClickListener, RefreshOrLoadMoreCallback<ListView> {

    private IPullableList<T, ListView> pullableList;

    private View headerView;

    private Object headerData;

    private boolean headerIsSelectable;

    private View footerView;

    private Object footerData;

    private boolean footerIsSelectable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pullableList = new PullableListImpl<>();
        addContentView(pullableList.init(this));
        setOnItemClickListener(this);

        if (headerView != null) {
            pullableList.addHeaderView(headerView, headerData, headerIsSelectable);
        }

        if (footerView != null) {
            pullableList.addHeaderView(footerView, footerData, footerIsSelectable);
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
        pullableList.canPullDown(canPullDown);
    }

    @Override
    public void canPullUp(boolean canPullUp) {
        pullableList.canPullUp(canPullUp);
    }

    @Override
    public void finishRequestSuccess(PullType type, List<T> items) {
        pullableList.finishRequestSuccess(type, items);
    }

    @Override
    public void finishRequestSuccessWithMessageIfItemsEmpty(PullType type, List<T> items, String messageWhenItemsEmpty) {
        pullableList.finishRequestSuccessWithMessageIfItemsEmpty(type, items, messageWhenItemsEmpty);
    }

    @Override
    public void finishRequestSuccessWithMessageIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty) {
        pullableList.finishRequestSuccessWithMessageIfItemsEmpty(type, items, imageResIdWhenItemsEmpty);
    }

    @Override
    public void finishRequestSuccessWithRefreshActionIfItemsEmpty(PullType type, List<T> items, String messageWhenItemsEmpty) {
        pullableList.finishRequestSuccessWithRefreshActionIfItemsEmpty(type, items, messageWhenItemsEmpty);
    }

    @Override
    public void finishRequestSuccessWithRefreshActionIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty) {
        pullableList.finishRequestSuccessWithRefreshActionIfItemsEmpty(type, items, imageResIdWhenItemsEmpty);
    }

    @Override
    public void finishRequestSuccessWithActionIfItemsEmpty(PullType type, List<T> items, String messageWhenItemsEmpty, String actionText, Runnable action) {
        pullableList.finishRequestSuccessWithActionIfItemsEmpty(type, items, messageWhenItemsEmpty, actionText, action);
    }

    @Override
    public void finishRequestSuccessWithActionIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty, String actionText, Runnable action) {
        pullableList.finishRequestSuccessWithActionIfItemsEmpty(type, items, imageResIdWhenItemsEmpty, actionText, action);
    }

    @Override
    public void setRefreshOrLoadMoreCallback(RefreshOrLoadMoreCallback callback) {
        pullableList.setRefreshOrLoadMoreCallback(callback);
    }

    @Override
    public View init(Context context) {
        return pullableList.init(context);
    }

    @Override
    public PullableViewContainer<ListView> getPullableViewContainer() {
        return pullableList.getPullableViewContainer();
    }

    @Override
    public void setItemAdapter(ItemAdapter<T> itemAdapter) {
        pullableList.setItemAdapter(itemAdapter);
    }

    @Override
    public ItemAdapter<T> getItemAdapter() {
        return pullableList.getItemAdapter();
    }

    @Override
    public void setItems(List<T> items) {
        pullableList.setItems(items);
    }

    @Override
    public List<T> getItems() {
        return pullableList.getItems();
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return pullableList.addAll(collection);
    }

    @Override
    public boolean add(T item) {
        return pullableList.add(item);
    }

    @Override
    public T set(int location, T item) {
        return pullableList.set(location, item);
    }

    @Override
    public boolean remove(T item) {
        return pullableList.remove(item);
    }

    @Override
    public void clear() {
        pullableList.clear();
    }

    @Override
    public boolean removeThenShowMessageIfEmpty(T item, CharSequence message) {
        return pullableList.removeThenShowMessageIfEmpty(item, message);
    }

    @Override
    public boolean removeThenShowImageIfEmpty(T item, int imageResId) {
        return pullableList.removeThenShowImageIfEmpty(item, imageResId);
    }

    @Override
    public boolean removeThenShowRefreshActionIfEmpty(T item, CharSequence message) {
        return pullableList.removeThenShowRefreshActionIfEmpty(item, message);
    }

    @Override
    public boolean removeThenShowRefreshActionIfEmpty(T item, int imageResId) {
        return pullableList.removeThenShowRefreshActionIfEmpty(item, imageResId);
    }

    @Override
    public boolean removeThenShowActionIfEmpty(T item, CharSequence message, String actionText, Runnable action) {
        return pullableList.removeThenShowActionIfEmpty(item, message, actionText, action);
    }

    @Override
    public void clearThenShowMessage(CharSequence message) {
        pullableList.clearThenShowMessage(message);
    }

    @Override
    public void clearThenShowImage(int imageResId) {
        pullableList.clearThenShowImage(imageResId);
    }

    @Override
    public void clearThenShowRefreshAction(CharSequence message) {
        pullableList.clearThenShowRefreshAction(message);
    }

    @Override
    public void clearThenShowRefreshAction(int imageResId) {
        pullableList.clearThenShowRefreshAction(imageResId);
    }

    @Override
    public void clearThenShowAction(CharSequence message, String actionText, Runnable action) {
        pullableList.clearThenShowAction(message, actionText, action);
    }

    @Override
    public T getItem(int position) {
        return pullableList.getItem(position);
    }

    @Override
    public int getCount() {
        return pullableList.getCount();
    }

    @Override
    public int getItemViewTypeCount() {
        return pullableList.getItemViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        return pullableList.getItemViewType(position);
    }

    @Override
    public void notifyDataSetChanged() {
        pullableList.notifyDataSetChanged();
    }

    @Override
    public void setDividerHeight(int height) {
        pullableList.setDividerHeight(height);
    }

    @Override
    public void setViewBeforeBody(int layoutId) {
        pullableList.setViewBeforeBody(layoutId);
    }

    @Override
    public void setViewBeforeBody(View view) {
        pullableList.setViewBeforeBody(view);
    }

    @Override
    public void setViewAfterBody(int layoutId) {
        pullableList.setViewAfterBody(layoutId);
    }

    @Override
    public void setViewAfterBody(View view) {
        pullableList.setViewAfterBody(view);
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
        pullableList.setOnItemClickListener(listener);
    }

    @Override
    public void refresh() {
        pullableList.refresh();
    }
}
