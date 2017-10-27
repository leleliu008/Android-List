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
        IPullable<T, GridView>, IGrid<T, GridView>,
        AdapterView.OnItemClickListener, RefreshOrLoadMoreCallback<GridView> {

    private IPullable<T, GridView> pullable;
    private IGrid<T, GridView> grid;
    private boolean isBodyCanScroll;

    @Override
    protected void onCreateViewLazy(BaseView baseView, Bundle savedInstanceState) {
        super.onCreateViewLazy(baseView, savedInstanceState);

        Activity activity = getActivity();

        pullable = new PullableGridImpl<>();
        grid = (IGrid<T, GridView>) pullable;
        addViewInBody(grid.init(activity, isBodyCanScroll));
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
    public void refresh() {
        pullable.refresh();
    }

    @Override
    public PullableViewContainer<GridView> getPullableViewContainer() {
        return pullable.getPullableViewContainer();
    }

    @Override
    public View init(Context context, boolean isBodyCanScroll) {
        return grid.init(context, isBodyCanScroll);
    }

    @Override
    public GridView getGridView() {
        return grid.getGridView();
    }

    @Override
    public void setItemAdapter(ItemAdapter<T> itemAdapter) {
        grid.setItemAdapter(itemAdapter);
    }

    @Override
    public ItemAdapter<T> getItemAdapter() {
        return grid.getItemAdapter();
    }

    @Override
    public void setItems(List<T> items) {
        grid.setItems(items);
    }

    @Override
    public List<T> getItems() {
        return grid.getItems();
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return grid.addAll(collection);
    }

    @Override
    public boolean add(T item) {
        return grid.add(item);
    }

    @Override
    public T set(int location, T item) {
        return grid.set(location, item);
    }

    @Override
    public T removeAt(int position) {
        return grid.removeAt(position);
    }

    @Override
    public T removeLastItem() {
        return grid.removeLastItem();
    }

    @Override
    public boolean remove(T item) {
        return grid.remove(item);
    }

    @Override
    public void clear() {
        grid.clear();
    }

    @Override
    public T getItem(int position) {
        return grid.getItem(position);
    }

    @Override
    public T getLastItem() {
        return grid.getLastItem();
    }

    @Override
    public int getItemCount() {
        return grid.getItemCount();
    }

    @Override
    public int getItemViewTypeCount() {
        return grid.getItemViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        return grid.getItemViewType(position);
    }

    @Override
    public void notifyDataSetChanged() {
        grid.notifyDataSetChanged();
    }

    @Override
    public void setViewBeforeBody(int layoutId) {
        grid.setViewBeforeBody(layoutId);
    }

    @Override
    public void setViewBeforeBody(View view) {
        grid.setViewBeforeBody(view);
    }

    @Override
    public void setViewAfterBody(int layoutId) {
        grid.setViewAfterBody(layoutId);
    }

    @Override
    public void setViewAfterBody(View view) {
        grid.setViewAfterBody(view);
    }

    @Override
    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        grid.setOnItemClickListener(listener);
    }

    @Override
    public void setNumColumns(int numColumns) {
        grid.setNumColumns(numColumns);
    }

    public void setBodyCanScroll(boolean bodyCanScroll) {
        isBodyCanScroll = bodyCanScroll;
    }
}
