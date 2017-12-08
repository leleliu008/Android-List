package com.fpliu.newton.ui.list;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.Collection;
import java.util.List;

/**
 * @author 792793182@qq.com 2017-06-29.
 */
public class ListImpl<T> implements IList<T, ListView> {

    private LinearLayout headPanel;

    private LinearLayout footerPanel;

    private ListView listView;

    private ItemAdapter<T> itemAdapter;

    @Override
    public View init(Context context) {
        View contentView = View.inflate(context, R.layout.list_activity, null);

        headPanel = contentView.findViewById(R.id.list_activity_head_panel);
        footerPanel = contentView.findViewById(R.id.list_activity_footer_panel);

        listView = contentView.findViewById(R.id.list_activity_list_view);

        ImageView imageView = new ImageView(context);
        imageView.setBackgroundColor(context.getResources().getColor(R.color.divider));
        imageView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, 1));
        listView.addFooterView(imageView, null, false);

        return contentView;
    }

    @Override
    public ListView getListView() {
        return listView;
    }

    @Override
    public void setItemAdapter(ItemAdapter<T> itemAdapter) {
        this.itemAdapter = itemAdapter;

        if (listView != null) {
            listView.setAdapter(itemAdapter);
        }
    }

    @Override
    public ItemAdapter<T> getItemAdapter() {
        return itemAdapter;
    }

    @Override
    public void setItems(List<T> items) {
        itemAdapter.setItems(items);
    }

    @Override
    public List<T> getItems() {
        return itemAdapter.getItems();
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return itemAdapter.addAll(collection);
    }

    @Override
    public boolean add(T item) {
        return itemAdapter.add(item);
    }

    @Override
    public T set(int location, T item) {
        return itemAdapter.set(location, item);
    }

    @Override
    public T removeAt(int position) {
        return itemAdapter.remove(position);
    }

    @Override
    public T removeLastItem() {
        return itemAdapter.removeLastItem();
    }

    @Override
    public boolean remove(T item) {
        return itemAdapter.remove(item);
    }

    @Override
    public T getItem(int position) {
        return itemAdapter.get(position);
    }

    @Override
    public T getLastItem() {
        return itemAdapter.getLastItem();
    }

    @Override
    public int getItemCount() {
        return itemAdapter.getCount();
    }

    @Override
    public void clear() {
        itemAdapter.clear();
    }

    @Override
    public int getItemViewTypeCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public void notifyDataSetChanged() {
        itemAdapter.notifyDataSetChanged();
    }

    @Override
    public void setDividerHeight(int height) {
        listView.setDividerHeight(height);
    }

    @Override
    public void setViewBeforeBody(int layoutId) {
        setViewBeforeBody(View.inflate(headPanel.getContext(), layoutId, null));
    }

    @Override
    public void setViewBeforeBody(View view) {
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        if (lp == null) {
            headPanel.addView(view, generateLayoutParams());
        } else {
            headPanel.addView(view, new LinearLayout.LayoutParams(lp.width, lp.height));
        }
    }

    @Override
    public void setViewAfterBody(int layoutId) {
        setViewAfterBody(View.inflate(footerPanel.getContext(), layoutId, null));
    }

    @Override
    public void setViewAfterBody(View view) {
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        if (lp == null) {
            footerPanel.addView(view, generateLayoutParams());
        } else {
            footerPanel.addView(view, new LinearLayout.LayoutParams(lp.width, lp.height));
        }
    }

    @Override
    public void addHeaderView(View view, Object data, boolean isSelectable) {
        listView.addHeaderView(view, data, isSelectable);
    }

    @Override
    public void addFooterView(View view, Object data, boolean isSelectable) {
        listView.addFooterView(view, data, isSelectable);
    }

    @Override
    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        listView.setOnItemClickListener(listener);
    }

    private LinearLayout.LayoutParams generateLayoutParams() {
        return new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }
}
