package com.fpliu.newton.ui.list.item;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fpliu.newton.ui.list.R;
import com.fpliu.newton.ui.list.ViewHolder;

/**
 * 包含一个按钮,居中
 *
 * @author 792793182@qq.com 2016-05-31.
 */
public class ButtonItem extends Item<ButtonItem> {

    private String btnText;

    public ButtonItem text(String btnText) {
        this.btnText = btnText;
        return this;
    }

    public String text() {
        return btnText;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = ViewHolder.getViewHolder(R.layout.button_item, convertView, parent);

        TextView titleTv = viewHolder.getWidgetView(R.id.button_item_btn);
        titleTv.setText(btnText);

        ImageView topDivider = viewHolder.getWidgetView(R.id.button_item_top_divider);
        if (isGroupFirst()) {
            topDivider.setVisibility(View.GONE);
        } else {
            topDivider.setVisibility(View.VISIBLE);
        }

        return viewHolder.getConvertView();
    }
}
