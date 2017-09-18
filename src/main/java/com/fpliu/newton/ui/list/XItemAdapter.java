package com.fpliu.newton.ui.list;

import android.view.View;
import android.view.ViewGroup;

import com.fpliu.newton.log.Logger;
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
        count(items);
        super.setItems(items);
    }

    @Override
    public int getViewTypeCount() {
        int xx = uniqueItems == null ? 1 : uniqueItems.size();
        Logger.d("XX", "getViewTypeCount() uniqueItems = " + uniqueItems);
        Logger.d("XX", "getViewTypeCount() = " + xx);
        return xx;
    }

    @Override
    public int getItemViewType(int position) {
        int xx = uniqueItems == null ? 0 : uniqueItems.indexOf(get(position).getClass().getName());
        Logger.d("XX", "getItemViewType(" + position + ") uniqueItems = " + uniqueItems);
        Logger.d("XX", "getItemViewType(" + position + ") = " + xx);
        return xx;
    }

    private void count(List<Item> items) {
        if (items == null || items.isEmpty()) {
            uniqueItems = null;
            return;
        }

        int size = items.size();

        if (size == 1) {
            uniqueItems = new ArrayList<>(1);
            uniqueItems.add(items.get(0).getClass().getName());
            return;
        }

        Set<String> types = new HashSet<>(size);
        for (int i = 0; i < size; i++) {
            types.add(items.get(i).getClass().getName());
        }
        uniqueItems = new ArrayList<>(types.size());
        uniqueItems.addAll(types);
        Logger.d("XX", "count() uniqueItems = " + uniqueItems);
    }
}
