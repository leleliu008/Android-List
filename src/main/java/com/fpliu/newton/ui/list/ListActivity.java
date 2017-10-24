package com.fpliu.newton.ui.list;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.fpliu.newton.ui.base.BaseActivity;

import java.util.Collection;
import java.util.List;

/**
 * 列表
 *
 * @author 792793182@qq.com 2016-06-01.
 */
public abstract class ListActivity<T> extends BaseActivity implements IList<T, ListView>, AdapterView.OnItemClickListener {

    private IList<T, ListView> list;

    private View headerView;

    private Object headerData;

    private boolean headerIsSelectable;

    private View footerView;

    private Object footerData;

    private boolean footerIsSelectable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list = new ListImpl<>();
        addViewInBody(init(this));
        setOnItemClickListener(this);

        if (headerView != null) {
            list.addHeaderView(headerView, headerData, headerIsSelectable);
        }

        if (footerView != null) {
            list.addHeaderView(footerView, footerData, footerIsSelectable);
        }
    }

    @Override
    public View init(Context context) {
        return list.init(context);
    }

    @Override
    public ListView getListView() {
        return list.getListView();
    }

    @Override
    public void setItemAdapter(ItemAdapter<T> itemAdapter) {
        list.setItemAdapter(itemAdapter);
    }

    @Override
    public ItemAdapter<T> getItemAdapter() {
        return list.getItemAdapter();
    }

    @Override
    public void setItems(List<T> items) {
        setItemAdapter(new ItemAdapter<T>(items) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return ListActivity.this.getItemView(position, convertView, parent);
            }

            @Override
            public int getViewTypeCount() {
                return ListActivity.this.getItemViewTypeCount();
            }

            @Override
            public int getItemViewType(int position) {
                return ListActivity.this.getItemViewType(position);
            }
        });
    }

    @Override
    public List<T> getItems() {
        return list.getItems();
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return list.addAll(collection);
    }

    @Override
    public boolean add(T item) {
        return list.add(item);
    }

    @Override
    public T set(int location, T item) {
        return list.set(location, item);
    }

    @Override
    public T removeAt(int position) {
        return list.removeAt(position);
    }

    @Override
    public T removeLastItem() {
        return list.removeLastItem();
    }

    @Override
    public boolean remove(T item) {
        return list.remove(item);
    }

    @Override
    public void clear() {
        list.clear();
    }

    @Override
    public T getItem(int position) {
        return list.getItem(position);
    }

    @Override
    public T getLastItem() {
        return list.getLastItem();
    }

    @Override
    public int getItemCount() {
        return list.getItemCount();
    }

    @Override
    public int getItemViewTypeCount() {
        return list.getItemViewTypeCount();
    }

    @Override
    public int getItemViewType(int position) {
        return list.getItemViewType(position);
    }

    @Override
    public void notifyDataSetChanged() {
        list.notifyDataSetChanged();
    }

    @Override
    public void setDividerHeight(int height) {
        list.setDividerHeight(height);
    }

    @Override
    public void setViewBeforeBody(int layoutId) {
        list.setViewBeforeBody(layoutId);
    }

    @Override
    public void setViewBeforeBody(View view) {
        list.setViewBeforeBody(view);
    }

    @Override
    public void setViewAfterBody(int layoutId) {
        list.setViewAfterBody(layoutId);
    }

    @Override
    public void setViewAfterBody(View view) {
        list.setViewAfterBody(view);
    }

    //必须在super.onCreate()之前调用
    @Override
    public void addHeaderView(View view, Object data, boolean isSelectable) {
        this.headerView = view;
        this.headerData = data;
        this.headerIsSelectable = isSelectable;
    }

    //必须在super.onCreate()之前调用
    @Override
    public void addFooterView(View view, Object data, boolean isSelectable) {
        this.footerView = view;
        this.footerData = data;
        this.footerIsSelectable = isSelectable;
    }

    @Override
    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        list.setOnItemClickListener(listener);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
