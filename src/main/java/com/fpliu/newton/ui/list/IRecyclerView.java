package com.fpliu.newton.ui.list;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.fpliu.newton.ui.recyclerview.ItemAdapter;
import com.fpliu.newton.ui.recyclerview.ItemViewHolderAbs;
import com.fpliu.newton.ui.recyclerview.OnItemClickListener;

import java.util.ArrayList;

/**
 * @author 792793182@qq.com 2017-06-29.
 */
public interface IRecyclerView<T, H extends ItemViewHolderAbs> extends ICommon<T> {

    RecyclerView getRecyclerView();

    void setOnItemClickListener(OnItemClickListener<T, H> onItemClickListener);

    void setItemAdapter(ItemAdapter<T, H> itemAdapter);

    ItemAdapter<T, H> getItemAdapter();

    int getItemViewType(int position);

    H onCreateViewHolder(ViewGroup parent, int viewType);

    void onBindViewHolder(H holder, int position, T item);

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
