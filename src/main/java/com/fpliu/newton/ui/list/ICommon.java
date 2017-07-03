package com.fpliu.newton.ui.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import java.util.Collection;
import java.util.List;

/**
 * 公共操作
 *
 * @author 792793182@qq.com 2017-06-29.
 */
public interface ICommon<T> {

    View init(Context context);

    void setItemAdapter(ItemAdapter<T> itemAdapter);

    ItemAdapter<T> getItemAdapter();

    void setItems(List<T> items);

    List<T> getItems();

    boolean addAll(Collection<? extends T> collection);

    boolean add(T item);

    T set(int location, T item);

    boolean remove(T item);

    void clear();

    int getCount();

    T getItem(int position);

    int getItemViewTypeCount();

    int getItemViewType(int position);

    View getItemView(int position, View convertView, ViewGroup parent);

    void notifyDataSetChanged();

    void setDividerHeight(int height);

    void setViewBeforeBody(int layoutId);

    void setViewBeforeBody(View view);

    void setViewAfterBody(int layoutId);

    void setViewAfterBody(View view);

    void setOnItemClickListener(AdapterView.OnItemClickListener listener);
}
