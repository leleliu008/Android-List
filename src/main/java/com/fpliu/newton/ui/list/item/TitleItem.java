package com.fpliu.newton.ui.list.item;

import android.view.View;
import android.view.ViewGroup;

import com.fpliu.newton.ui.list.R;
import com.fpliu.newton.ui.list.ViewHolder;

/**
 * 左边一行文字，右边一个指示箭头
 *
 * @author 792793182@qq.com 2016-05-31.
 */
public class TitleItem extends Item<TitleItem> {

    private String title;

    public String title() {
        return title;
    }

    public TitleItem title(String title) {
        this.title = title;
        return this;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.getInstance(R.layout.title_item, convertView, parent);
        holder.id(R.id.title_item_title).text(title);
        holder.id(R.id.title_item_top_divider).visibility(isGroupFirst() ? View.GONE : View.VISIBLE);
        return holder.getItemView();
    }
}
