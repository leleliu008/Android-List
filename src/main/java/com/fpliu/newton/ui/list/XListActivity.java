package com.fpliu.newton.ui.list;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.fpliu.newton.ui.list.item.Item;

import java.util.List;

/**
 * @author 792793182@qq.com 2017-06-30.
 */
public abstract class XListActivity extends ListActivity<Item> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setItemAdapter(new XItemAdapter(null));
    }

    public Item getItemById(int id) {
        List<Item> items = getItems();
        if (items == null || items.isEmpty()) {
            return null;
        } else {
            for (Item item : items) {
                if (item.id() == id) {
                    return item;
                }
            }
            return null;
        }
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        throw new RuntimeException("can't call this method");
    }
}
