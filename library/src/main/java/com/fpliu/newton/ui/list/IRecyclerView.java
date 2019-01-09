package com.fpliu.newton.ui.list;

import android.view.ViewGroup;

import com.fpliu.newton.ui.recyclerview.OnItemClickListener;
import com.fpliu.newton.ui.recyclerview.adapter.ItemAdapter;
import com.fpliu.newton.ui.recyclerview.holder.ItemViewHolder;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;

/**
 * @author 792793182@qq.com 2017-06-29.
 */
public interface IRecyclerView<T> extends ICommon<T> {

    RecyclerView getRecyclerView();

    void setOnItemClickListener(OnItemClickListener<T> onItemClickListener);

    void setItemAdapter(ItemAdapter<T> itemAdapter);

    ItemAdapter<T> getItemAdapter();

    int getItemViewType(int position);

    int onBindLayout(ViewGroup parent, int viewType);

    void onCreateViewHolder(ItemViewHolder holder, ViewGroup parent, int viewType);

    void onBindViewHolder(ItemViewHolder holder, int position, List<Object> payloads);

    void onBindViewHolder(ItemViewHolder holder, int position, T item);

    void notifyDataSetChanged();

    void setLayoutManager(RecyclerView.LayoutManager layoutManager);

    void setItemDecoration(RecyclerView.ItemDecoration itemDecoration);

    void addItemDecoration(RecyclerView.ItemDecoration itemDecoration);

    void removeItemDecoration(RecyclerView.ItemDecoration itemDecoration);

    ArrayList<RecyclerView.ItemDecoration> getItemDecorations();

    void clearItemDecorations();

    void setItemAnimator(RecyclerView.ItemAnimator itemAnimator);

    void asList();

    void asGrid(int columnNumber);
}
