package com.fpliu.newton.ui.list;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.fpliu.newton.ui.base.BaseView;
import com.fpliu.newton.ui.base.LazyFragment;
import com.fpliu.newton.ui.pullable.PullableGridView;
import com.fpliu.newton.ui.pullable.PullableViewContainer;
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback;
import com.fpliu.newton.ui.pullable.Type;

import java.util.Collection;
import java.util.List;

/**
 * @author 792793182@qq.com 2016-06-06.
 */
public abstract class PullableGridFragment<T> extends LazyFragment implements
        IPullableGrid<T, PullableGridView>,
        AdapterView.OnItemClickListener, RefreshOrLoadMoreCallback<PullableGridView> {

    private IPullableGrid<T, PullableGridView> pullableGrid;

    @Override
    public BaseView onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        BaseView baseView = super.onCreateView(inflater, container, savedInstanceState);

        Activity activity = getActivity();

        pullableGrid = new PullableGridImpl<>();
        addContentView(pullableGrid.init(activity));
        setOnItemClickListener(this);
        setItemAdapterIfEmpty(new ItemAdapter<T>(null) {
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
        return baseView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setOnItemClickListener(this);
        setRefreshOrLoadMoreCallback(this);
    }

    @Override
    protected void onFragmentStartLazy() {
        super.onFragmentStartLazy();
        onRefreshOrLoadMore(getPullableViewContainer(), Type.REFRESH, 1, 10);
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
    public void setItemAdapterIfEmpty(ItemAdapter<T> itemAdapter) {
        pullableGrid.setItemAdapterIfEmpty(itemAdapter);
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
}
