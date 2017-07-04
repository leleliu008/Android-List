package com.fpliu.newton.ui.list;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.fpliu.newton.ui.base.BaseActivity;
import com.fpliu.newton.ui.pullable.PullableGridView;
import com.fpliu.newton.ui.pullable.PullableViewContainer;
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback;
import com.fpliu.newton.ui.pullable.Type;

import java.util.Collection;
import java.util.List;

/**
 * @author 792793182@qq.com 2016-06-06.
 */
public abstract class PullableGridActivity<T> extends BaseActivity
        implements IPullableGrid<T, PullableGridView>,
        AdapterView.OnItemClickListener, RefreshOrLoadMoreCallback<PullableGridView> {

    private IPullableGrid<T, PullableGridView> pullableGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pullableGrid = new PullableGridImpl<>();
        addContentView(pullableGrid.init(this));
        setOnItemClickListener(this);
        setItemAdapter(new ItemAdapter<T>(null) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return PullableGridActivity.this.getItemView(position, convertView, parent);
            }

            @Override
            public int getViewTypeCount() {
                return PullableGridActivity.this.getItemViewTypeCount();
            }

            @Override
            public int getItemViewType(int position) {
                return PullableGridActivity.this.getItemViewType(position);
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
    public void finishRequestSuccess(Type type, List<T> items) {
        pullableGrid.finishRequestSuccess(type, items);
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
    public PullableViewContainer<PullableGridView> getPullableViewContainer() {
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
    public T getItem(int position) {
        return pullableGrid.getItem(position);
    }

    @Override
    public int getCount() {
        return pullableGrid.getCount();
    }

    @Override
    public void clear() {
        pullableGrid.clear();
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