package com.fpliu.newton.ui.list;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.fpliu.newton.ui.base.BaseView;
import com.fpliu.newton.ui.base.LazyFragment;

import java.util.Collection;
import java.util.List;

/**
 * 列表
 *
 * @author 792793182@qq.com 2016-06-01.
 */
public abstract class ListFragment<T> extends LazyFragment implements AdapterView.OnItemClickListener {

    private LinearLayout headerViewContainer;

    private ListView listView;

    private ItemAdapter<T> itemAdapter;

    @Override
    public BaseView onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        BaseView baseView = super.onCreateView(inflater, container, savedInstanceState);

        Context context = getActivity();

        headerViewContainer = new LinearLayout(context);
        headerViewContainer.setOrientation(LinearLayout.VERTICAL);

        listView = new ListView(context);
        listView.setCacheColorHint(Color.TRANSPARENT);
        listView.setSelector(new ColorDrawable(getResources().getColor(R.color.divider)));
        listView.setDivider(null);
        listView.setDividerHeight(0);
        listView.setId(R.id.list_view);
        listView.setOnItemClickListener(this);
        listView.addHeaderView(headerViewContainer, null, false);

        if (itemAdapter == null) {
            itemAdapter = new ItemAdapter<T>(null) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    return ListFragment.this.getView(position, convertView, parent);
                }
            };
        }
        listView.setAdapter(itemAdapter);

        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundColor(getResources().getColor(R.color.divider));
        imageView.setLayoutParams(new AbsListView.LayoutParams(AbsListView.LayoutParams.MATCH_PARENT, 1));
        listView.addFooterView(imageView, null, false);

        baseView.addContentView(listView);

        return baseView;
    }

    public final ListView getListView() {
        return listView;
    }

    protected void addHeaderView(int layoutId, LinearLayout.LayoutParams layoutParams) {
        Context context = headerViewContainer.getContext();
        View view = LayoutInflater.from(context).inflate(layoutId, headerViewContainer, false);
        headerViewContainer.addView(view, layoutId);
    }

    protected void addHeaderView(int layoutId) {
        Context context = headerViewContainer.getContext();
        View view = LayoutInflater.from(context).inflate(layoutId, headerViewContainer, false);
        headerViewContainer.addView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
    }

    protected void addHeaderView(View view, LinearLayout.LayoutParams layoutParams) {
        headerViewContainer.addView(view, layoutParams);
    }

    protected void addHeaderView(View view) {
        headerViewContainer.addView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
    }

    protected void addHeaderSeparator() {
        ImageView imageView = new ImageView(getActivity());
        imageView.setBackgroundColor(getResources().getColor(R.color.divider));
        headerViewContainer.addView(imageView, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 1));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View convertView, int position, long id) {

    }


    protected final void setItemAdapter(ItemAdapter<T> itemAdapter) {
        this.itemAdapter = itemAdapter;
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