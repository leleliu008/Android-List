package com.fpliu.newton.ui.list.item;

import android.view.View;
import android.view.ViewGroup;

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
        return ViewHolder.getInstance(R.layout.button_item, convertView, parent)
                .id(R.id.button_item_btn).text(btnText)
                .id(R.id.button_item_top_divider).visibility(isGroupFirst() ? View.GONE : View.VISIBLE)
                .getItemView();
    }
}
