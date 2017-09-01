package com.fpliu.newton.ui.list;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.fpliu.newton.ui.base.BaseView;
import com.fpliu.newton.ui.base.LazyFragment;
import com.fpliu.newton.ui.pullable.PullType;
import com.fpliu.newton.ui.pullable.PullableViewContainer;
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback;

import java.util.Collection;
import java.util.List;

/**
 * @author 792793182@qq.com 2016-06-06.
 */
public abstract class PullableGridFragment<T> extends LazyFragment implements
        IPullableGrid<T, GridView>,
        AdapterView.OnItemClickListener, RefreshOrLoadMoreCallback<GridView> {

    private IPullableGrid<T, GridView> pullableGrid;

    @Override
    protected void onCreateViewLazy(BaseView baseView, Bundle savedInstanceState) {
        super.onCreateViewLazy(baseView, savedInstanceState);

        Activity activity = getActivity();

        pullableGrid = new PullableGridImpl<>();
        addContentView(pullableGrid.init(activity));
        setOnItemClickListener(this);

        setItemAdapter(new ItemAdapter<T>(null) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return PullableGridFragment.this.getItemView(position, convertView, parent);
            }

            @Override
            public int getViewTypeCount() {
                return PullableGridFragment.this.getItemViewTypeCount();
            }

            @Override
            public int getItemViewType(int position) {
                return PullableGridFragment.this.getItemViewType(position);
            }
        });
        setRefreshOrLoadMoreCallback(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void canPullDown(boolean canPullDown) {
        pullableGrid.canPullDown(canPullDown);
    }

    @Override
    public void canPullUp(boolean canPullUp) {
        pullableGrid.canPullUp(canPullUp);
    }

    @Override
    public void finishRequestSuccess(PullType type, List<T> items) {
        pullableGrid.finishRequestSuccess(type, items);
    }

    @Override
    public void finishRequestSuccessWithMessageIfItemsEmpty(PullType type, List<T> items, String messageWhenItemsEmpty) {
        pullableGrid.finishRequestSuccessWithMessageIfItemsEmpty(type, items, messageWhenItemsEmpty);
    }

    @Override
    public void finishRequestSuccessWithMessageIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty) {
        pullableGrid.finishRequestSuccessWithMessageIfItemsEmpty(type, items, imageResIdWhenItemsEmpty);
    }

    @Override
    public void finishRequestSuccessWithRefreshActionIfItemsEmpty(PullType type, List<T> items, String messageWhenItemsEmpty) {
        pullableGrid.finishRequestSuccessWithRefreshActionIfItemsEmpty(type, items, messageWhenItemsEmpty);
    }

    @Override
    public void finishRequestSuccessWithRefreshActionIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty) {
        pullableGrid.finishRequestSuccessWithRefreshActionIfItemsEmpty(type, items, imageResIdWhenItemsEmpty);
    }

    @Override
    public void finishRequestSuccessWithActionIfItemsEmpty(PullType type, List<T> items, String messageWhenItemsEmpty, String actionText, Runnable action) {
        pullableGrid.finishRequestSuccessWithActionIfItemsEmpty(type, items, messageWhenItemsEmpty, actionText, action);
    }

    @Override
    public void finishRequestSuccessWithActionIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty, String actionText, Runnable action) {
        pullableGrid.finishRequestSuccessWithActionIfItemsEmpty(type, items, imageResIdWhenItemsEmpty, actionText, action);
    }

    @Override
    public void setRefreshOrLoadMoreCallback(RefreshOrLoadMoreCallback callback) {
        pullableGrid.setRefreshOrLoadMoreCallback(callback);
    }

    @Override
    public View init(Context context) {
        return pullableGrid.init(context);
    }

    @Override
    public PullableViewContainer<GridView> getPullableViewContainer() {
        return pullableGrid.getPullableViewContainer();
    }

    @Override
    public void setItemAdapter(ItemAdapter<T> itemAdapter) {
        pullableGrid.setItemAdapter(itemAdapter);
    }

    @Override
    public ItemAdapter<T> getItemAdapter() {
        return pullableGrid.getItemAdapter();
    }

    @Override
    public void setItems(List<T> items) {
        pullableGrid.setItems(items);
    }

    @Override
    public List<T> getItems() {
        return pullableGrid.getItems();
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return pullableGrid.addAll(collection);
    }

    @Override
    public boolean add(T item) {
        return pullableGrid.add(item);
    }

    @Override
    public T set(int location, T item) {
        return pullableGrid.set(location, item);
    }

    @Override
    public boolean remove(T item) {
        return pullableGrid.remove(item);
    }

    @Override
    public void clear() {
        pullableGrid.clear();
    }

    @Override
    public boolean removeThenShowMessageIfEmpty(T item, CharSequence message) {
        return pullableGrid.removeThenShowMessageIfEmpty(item, message);
    }

    @Override
    public boolean removeThenShowImageIfEmpty(T item, int imageResId) {
        return pullableGrid.removeThenShowImageIfEmpty(item, imageResId);
    }

    @Override
    public boolean removeThenShowRefreshActionIfEmpty(T item, CharSequence message) {
        return pullableGrid.removeThenShowRefreshActionIfEmpty(item, message);
    }

    @Override
    public boolean removeThenShowRefreshActionIfEmpty(T item, int imageResId) {
        return pullableGrid.removeThenShowRefreshActionIfEmpty(item, imageResId);
    }

    @Override
    public boolean removeThenShowActionIfEmpty(T item, CharSequence message, String actionText, Runnable action) {
        return pullableGrid.removeThenShowActionIfEmpty(item, message, actionText, action);
    }

    @Override
    public void clearThenShowMessage(CharSequence message) {
        pullableGrid.clearThenShowMessage(message);
    }

    @Override
    public void clearThenShowImage(int imageResId) {
        pullableGrid.clearThenShowImage(imageResId);
    }

    @Override
    public void clearThenShowRefreshAction(CharSequence message) {
        pullableGrid.clearThenShowRefreshAction(message);
    }

    @Override
    public void clearThenShowRefreshAction(int imageResId) {
        pullableGrid.clearThenShowRefreshAction(imageResId);
    }

    @Override
    public void clearThenShowAction(CharSequence message, String actionText, Runnable action) {
        pullableGrid.clearThenShowAction(message, actionText, action);
    }

    @Override
    public T getItem(int position) {
        return pullableGrid.getItem(position);
    }

    @Override
    public int getCount() {
        return pullableGrid.getCount();
    }

    @Override
    public int getItemViewTypeCount() {
        return pullableGrid.getItemViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        return pullableGrid.getItemViewType(position);
    }

    @Override
    public void notifyDataSetChanged() {
        pullableGrid.notifyDataSetChanged();
    }

    @Override
    public void setDividerHeight(int height) {
        pullableGrid.setDividerHeight(height);
    }

    @Override
    public void setViewBeforeBody(int layoutId) {
        pullableGrid.setViewBeforeBody(layoutId);
    }

    @Override
    public void setViewBeforeBody(View view) {
        pullableGrid.setViewBeforeBody(view);
    }

    @Override
    public void setViewAfterBody(int layoutId) {
        pullableGrid.setViewAfterBody(layoutId);
    }

    @Override
    public void setViewAfterBody(View view) {
        pullableGrid.setViewAfterBody(view);
    }

    @Override
    public void addHeaderView(View view, Object data, boolean isSelectable) {
        //do nothing
    }

    @Override
    public void addFooterView(View view, Object data, boolean isSelectable) {
        //do nothing
    }

    @Override
    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        pullableGrid.setOnItemClickListener(listener);
    }

    @Override
    public void setNumColumns(int numColumns) {
        pullableGrid.setNumColumns(numColumns);
    }

    @Override
    public void refresh() {
        pullableGrid.refresh();
    }
}
