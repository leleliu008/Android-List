package com.fpliu.newton.ui.list;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

/**
 * @author 792793182@qq.com 2017-06-30.
 */
public interface IGrid<T, V extends GridView> extends ICommon<T> {

    V getGridView();

    void setItemAdapter(ItemAdapter<T> itemAdapter);

    ItemAdapter<T> getItemAdapter();

    void setOnItemClickListener(AdapterView.OnItemClickListener listener);

    int getItemViewTypeCount();

    int getItemViewType(int position);

    View getItemView(int position, View convertView, ViewGroup parent);

    void notifyDataSetChanged();

    void setNumColumns(int numColumns);
}
