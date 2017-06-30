package com.fpliu.newton.ui.list;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;

import com.fpliu.newton.ui.list.item.Item;

/**
 *
 * @author 792793182@qq.com 2017-06-30.
 */
public abstract class XListActivity extends ListActivity<Item> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setItemAdapter(new ItemAdapter<Item>(null) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                return new View(me());
            }
        });
        super.onCreate(savedInstanceState);
    }

    @Override
    public final View getItemView(int position, View convertView, ViewGroup parent) {
        throw new RuntimeException("don't call this method");
    }
}
