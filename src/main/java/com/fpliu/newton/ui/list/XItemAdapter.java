package com.fpliu.newton.ui.list;

import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;

import com.fpliu.newton.ui.list.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 792793182@qq.com 2016-06-11.
 */
public class XItemAdapter extends ItemAdapter<Item> {

    private int typeCount = 1;

    private SparseIntArray typeMap = new SparseIntArray();

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
        return typeCount;
    }

    @Override
    public int getItemViewType(int position) {
        return typeMap.get(position);
    }

    private void count(List<Item> items) {
        if (items == null) {
            return;
        }

        int size = items.size();
        ArrayList<String> types = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            Item xPreferenceItem = items.get(i);
            String tag = xPreferenceItem.getClass().toString();
            boolean notHave = true;
            for (String type : types) {
                if (tag.equals(type)) {
                    continue;
                }
            }

            typeMap.put(i, types.size());

            //如果没有
            if (notHave) {
                types.add(tag);
            }
        }

        typeCount = types.size();
    }
}
