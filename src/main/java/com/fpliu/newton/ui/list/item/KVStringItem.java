package com.fpliu.newton.ui.list.item;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        ViewHolder viewHolder = ViewHolder.getViewHolder(R.layout.kv_string_item, convertView, parent);

        TextView keyTv = viewHolder.getWidgetView(R.id.kv_string_item_key);
        TextView valueTv = viewHolder.getWidgetView(R.id.kv_string_item_value);

        if (needShowWidget) {
            valueTv.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_widget, 0);
        } else {
            valueTv.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        }

        keyTv.setText(key);
        valueTv.setText(value);

        ImageView topDivider = viewHolder.getWidgetView(R.id.kv_string_item_top_divider);
        if (isGroupFirst()) {
            topDivider.setVisibility(View.GONE);
        } else {
            topDivider.setVisibility(View.VISIBLE);
        }

        return viewHolder.getConvertView();
    }
}
