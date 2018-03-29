package com.fpliu.newton.ui.list;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.fpliu.newton.ui.base.BaseView;
import com.fpliu.newton.ui.base.LazyFragment;
import com.fpliu.newton.ui.recyclerview.OnItemClickListener;
import com.fpliu.newton.ui.recyclerview.adapter.ItemAdapter;
import com.fpliu.newton.ui.recyclerview.holder.ItemViewHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class RecyclerViewFragment<T> extends LazyFragment
    implements IRecyclerView<T>, OnItemClickListener<T> {

    private IRecyclerView<T> recyclerView;

    @Override
    protected void onCreateViewLazy(BaseView baseView, Bundle savedInstanceState) {
        super.onCreateViewLazy(baseView, savedInstanceState);

        PullableRecyclerViewImpl pullableRecyclerView = new PullableRecyclerViewImpl<>();
        View contentView = pullableRecyclerView.init(getActivity());
        addViewInBody(contentView);
        recyclerView = pullableRecyclerView;
        pullableRecyclerView.canPullDown(false);
        pullableRecyclerView.canPullUp(false);
        pullableRecyclerView.getPullableViewContainer().getStateView().setVisibility(View.GONE);
        setItemAdapter(new ItemAdapter<T>(null) {

            @Override
            public int onBindLayout(ViewGroup parent, int viewType) {
                return RecyclerViewFragment.this.onBindLayout(parent, viewType);
            }

            public void onBindViewHolder(ItemViewHolder holder, int position, T item) {
                RecyclerViewFragment.this.onBindViewHolder(holder, position, item);
            }

            @Override
            public int getItemViewType(int position) {
                return RecyclerViewFragment.this.getItemViewType(position);
            }
        });
        setOnItemClickListener(this);
    }

    @Override
    public View init(Context context) {
        return recyclerView.init(context);
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
    public T removeAt(int position) {
        return recyclerView.removeAt(position);
    }

    @Override
    public T removeLastItem() {
        return recyclerView.removeLastItem();
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
    public int getItemCount() {
        return recyclerView.getItemCount();
    }

    @Override
    public T getItem(int position) {
        return recyclerView.getItem(position);
    }

    @Override
    public T getLastItem() {
        return recyclerView.getLastItem();
    }

    @Override
    public View setViewBeforeBody(int layoutId) {
        return recyclerView.setViewBeforeBody(layoutId);
    }

    @Override
    public void setViewBeforeBody(View view) {
        recyclerView.setViewBeforeBody(view);
    }

    @Override
    public View setViewAfterBody(int layoutId) {
        return recyclerView.setViewAfterBody(layoutId);
    }

    @Override
    public void setViewAfterBody(View view) {
        recyclerView.setViewAfterBody(view);
    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerView.getRecyclerView();
    }

    @Override
    public void setOnItemClickListener(OnItemClickListener<T> onItemClickListener) {
        recyclerView.setOnItemClickListener(onItemClickListener);
    }

    @Override
    public void setItemAdapter(ItemAdapter<T> itemAdapter) {
        recyclerView.setItemAdapter(itemAdapter);
    }

    @Override
    public ItemAdapter<T> getItemAdapter() {
        return recyclerView.getItemAdapter();
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
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        recyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void setItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        recyclerView.setItemDecoration(itemDecoration);
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
    public void asList() {
        recyclerView.asList();
    }

    @Override
    public void asGrid(int columnNumber) {
        recyclerView.asGrid(columnNumber);
    }

    @Override
    public void onItemClick(ItemViewHolder holder, int position, T item) {

    }
}
