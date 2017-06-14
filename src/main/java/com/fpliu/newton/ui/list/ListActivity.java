package com.fpliu.newton.ui.list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.fpliu.newton.ui.base.BaseActivity;

import java.util.Collection;
import java.util.List;

/**
 * 列表
 *
 * @author 792793182@qq.com 2016-06-01.
 */
public abstract class ListActivity<T> extends BaseActivity implements AdapterView.OnItemClickListener {

    private ListView listView;

    private ItemAdapter<T> itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addContentView(R.layout.list_activity);

        listView = (ListView) findViewById(R.id.list_activity_list_view);
        listView.setOnItemClickListener(this);

        if (itemAdapter == null) {
            itemAdapter = new ItemAdapter<T>(null) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    return ListActivity.this.getView(position, convertView, parent);
                }
            };
        }
        listView.setAdapter(itemAdapter);

        ImageView imageView = new ImageView(this);
        imageView.setBackgroundColor(getResources().getColor(R.color.divider));
        imageView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, 1));
        listView.addFooterView(imageView, null, false);
    }

    public final ListView getListView() {
        return listView;
    }

    protected final void addHeaderView(int layoutId) {
        LinearLayout headPanel = (LinearLayout) findViewById(R.id.list_activity_head_panel);
        LayoutInflater.from(this).inflate(layoutId, headPanel, true);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

    }

    protected final void setItemAdapter(ItemAdapter<T> itemAdapter) {
        this.itemAdapter = itemAdapter;

        if (listView != null) {
            listView.setAdapter(itemAdapter);
        }
    }

    protected final ItemAdapter<T> getListAdapter() {
        return itemAdapter;
    }

    protected final void setItems(List<T> items) {
        itemAdapter.setItems(items);
    }

    protected final List<T> getItems() {
        return itemAdapter.getItems();
    }

    protected final boolean addAll(Collection<? extends T> collection) {
        return itemAdapter.addAll(collection);
    }

    protected final boolean add(T item) {
        return itemAdapter.add(item);
    }

    protected final T getItem(int position) {
        return itemAdapter.get(position);
    }

    protected final int getCount() {
        return itemAdapter.getCount();
    }

    protected int getViewTypeCount() {
        return itemAdapter.getViewTypeCount();
    }

    protected int getItemViewType(int position) {
        return itemAdapter.getItemViewType(position);
    }

    protected View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
}
