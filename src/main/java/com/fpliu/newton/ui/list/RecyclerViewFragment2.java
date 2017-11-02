package com.fpliu.newton.ui.list;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.fpliu.newton.ui.base.BaseView;
import com.fpliu.newton.ui.recyclerview.adapter.ItemAdapterEx;
import com.fpliu.newton.ui.recyclerview.holder.ItemViewHolderAbs;

/**
 * 可以下拉刷新和上拉加载更多
 *
 * @author 792793182@qq.com 2016-06-06.
 */
public abstract class RecyclerViewFragment2<T, H extends ItemViewHolderAbs> extends RecyclerViewFragment<T, H> {

    private View headerView;

    private View footerView;

    @Override
    protected void onCreateViewLazy(BaseView baseView, Bundle savedInstanceState) {
        super.onCreateViewLazy(baseView, savedInstanceState);

        ItemAdapterEx<T, H> itemAdapter = new ItemAdapterEx<T, H>(null) {
            @Override
            public H onCreateHeaderViewHolder(ViewGroup viewGroup, int viewType, View headerView) {
                return RecyclerViewFragment2.this.onCreateHeaderViewHolder(viewGroup, viewType, headerView);
            }

            @Override
            public H onCreateFooterViewHolder(ViewGroup viewGroup, int viewType, View footerView) {
                return RecyclerViewFragment2.this.onCreateFooterViewHolder(viewGroup, viewType, footerView);
            }

            @Override
            public H onCreateViewHolder2(ViewGroup viewGroup, int viewType) {
                return RecyclerViewFragment2.this.onCreateViewHolder(viewGroup, viewType);
            }

            @Override
            public void onBindViewHolder(H holder, int position, T item) {
                RecyclerViewFragment2.this.onBindViewHolder(holder, position, item);
            }
        };
        if (headerView != null) {
            itemAdapter.addHeaderView(headerView);
        }
        if (footerView != null) {
            itemAdapter.addFootView(footerView);
        }
        setItemAdapter(itemAdapter);
        setOnItemClickListener(this);
    }

    protected void setHeaderView(View headerView) {
        this.headerView = headerView;
    }

    protected void setFooterView(View footerView) {
        this.footerView = footerView;
    }

    protected abstract H onCreateHeaderViewHolder(ViewGroup viewGroup, int viewType, View headerView);

    protected abstract H onCreateFooterViewHolder(ViewGroup viewGroup, int viewType, View footerView);
}
