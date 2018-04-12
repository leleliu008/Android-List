package com.fpliu.newton.ui.list;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

/**
 * List操作
 *
 * @author 792793182@qq.com 2017-06-29.
 */
public interface IList<T, V extends ListView> extends ICommon<T> {

    V getListView();

    void setItemAdapter(ItemAdapter<T> itemAdapter);

    ItemAdapter<T> getItemAdapter();

    void addHeaderView(View view, Object data, boolean isSelectable);

    void addFooterView(View view, Object data, boolean isSelectable);

    void setOnItemClickListener(AdapterView.OnItemClickListener listener);

    int getItemViewTypeCount();

    int getItemViewType(int position);

    View getItemView(int position, View convertView, ViewGroup parent);

    void notifyDataSetChanged();

    void setDividerHeight(int height);
}
