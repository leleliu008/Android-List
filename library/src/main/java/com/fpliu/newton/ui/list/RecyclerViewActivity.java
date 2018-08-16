package com.fpliu.newton.ui.list;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.fpliu.newton.ui.base.BaseActivity;
import com.fpliu.newton.ui.recyclerview.OnItemClickListener;
import com.fpliu.newton.ui.recyclerview.adapter.ItemAdapter;
import com.fpliu.newton.ui.recyclerview.holder.ItemViewHolder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public abstract class RecyclerViewActivity<T> extends BaseActivity
    implements IRecyclerView<T>, OnItemClickListener<T> {

    private IRecyclerView<T> recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        PullableRecyclerViewImpl pullableRecyclerView = new PullableRecyclerViewImpl<>();

        View contentView = pullableRecyclerView.init(this);
        CoordinatorLayout.LayoutParams lp = new CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT, CoordinatorLayout.LayoutParams.MATCH_PARENT);
        lp.setBehavior(new AppBarLayout.ScrollingViewBehavior());
        addContentView(contentView, lp);

        recyclerView = pullableRecyclerView;
        pullableRecyclerView.canPullDown(false);
        pullableRecyclerView.canPullUp(false);
        pullableRecyclerView.getPullableViewContainer().getStateView().setVisibility(View.GONE);
        setItemAdapter(new ItemAdapter<T>(null) {

            @Override
            public int onBindLayout(ViewGroup parent, int viewType) {
                return RecyclerViewActivity.this.onBindLayout(parent, viewType);
            }

            @Override
            public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                ItemViewHolder itemViewHolder = super.onCreateViewHolder(parent, viewType);
                RecyclerViewActivity.this.onCreateViewHolder(itemViewHolder, parent, viewType);
                return itemViewHolder;
            }

            public void onBindViewHolder(ItemViewHolder holder, int position, T item) {
                RecyclerViewActivity.this.onBindViewHolder(holder, position, item);
            }

            @Override
            public int getItemViewType(int position) {
                return RecyclerViewActivity.this.getItemViewType(position);
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
    public void onCreateViewHolder(ItemViewHolder holder, ViewGroup parent, int viewType) {

    }

    @Override
    public void onItemClick(ItemViewHolder holder, int position, T item) {

    }
}
