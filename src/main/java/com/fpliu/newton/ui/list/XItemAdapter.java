package com.fpliu.newton.ui.list;

import android.view.View;
import android.view.ViewGroup;

import com.fpliu.newton.ui.list.item.Item;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author 792793182@qq.com 2016-06-11.
 */
public class XItemAdapter extends ItemAdapter<Item> {

    private ArrayList<String> uniqueItems;

    /**
     * 构造方法
     *
     * @param items 要显示的项的数据列表
     */
    public XItemAdapter(List<Item> items) {
        super(items);
        count(items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItem(position).getView(position, convertView, parent);
    }

    @Override
    public void setItems(List<Item> items) {
        super.setItems(items);

        count(items);
    }

    @Override
    public int getViewTypeCount() {
        return uniqueItems == null ? 1 : uniqueItems.size();
    }

    @Override
    public int getItemViewType(int position) {
        return uniqueItems == null ? 0 : uniqueItems.indexOf(get(position).getClass().toString());
    }

    private void count(List<Item> items) {
        if (items == null || items.isEmpty()) {
            return;
        }

        int size = items.size();

        if (size == 1) {
            uniqueItems = new ArrayList<>(1);
            uniqueItems.add(items.get(0).getClass().toString());
            return;
        }

        Set<String> types = new HashSet<>(size);
        for (int i = 0; i < size; i++) {
            types.add(items.get(i).getClass().toString());
        }
        uniqueItems = new ArrayList<>(types.size());
        uniqueItems.addAll(types);
    }
}
