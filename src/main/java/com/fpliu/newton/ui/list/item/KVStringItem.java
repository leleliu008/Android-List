package com.fpliu.newton.ui.list.item;

import android.view.View;
import android.view.ViewGroup;

import com.fpliu.newton.ui.list.R;
import com.fpliu.newton.ui.list.ViewHolder;

/**
 * 键值对
 *
 * @author 792793182@qq.com 2016-06-01.
 */
public class KVStringItem extends Item<KVStringItem> {

    private String key;

    private String value;

    private boolean needShowWidget = true;


    public KVStringItem key(String key) {
        this.key = key;
        return this;
    }

    public String key() {
        return key;
    }

    public KVStringItem value(String value) {
        this.value = value;
        return this;
    }

    public String value() {
        return value;
    }

    public KVStringItem needShowWidget(boolean needShowWidget) {
        this.needShowWidget = needShowWidget;
        return this;
    }

    public boolean needShowWidget() {
        return needShowWidget;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.getInstance(R.layout.kv_string_item, convertView, parent);
        holder.id(R.id.kv_string_item_key).text(key);
        holder.id(R.id.kv_string_item_value).text(value).compoundDrawablesWithIntrinsicBounds(0, 0, needShowWidget ? R.drawable.ic_widget : 0, 0);
        holder.id(R.id.kv_string_item_top_divider).visibility(isGroupFirst() ? View.GONE : View.VISIBLE);
        return holder.getItemView();
    }
}
