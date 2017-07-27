package com.fpliu.newton.ui.list.item;

import android.view.View;
import android.view.ViewGroup;

import com.fpliu.newton.ui.list.R;
import com.fpliu.newton.ui.list.ViewHolder;

/**
 * 粗的分割线
 *
 * @author 792793182@qq.com 2016-06-12.
 */
public class FatDividerItem extends Item<FatDividerItem> {

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return ViewHolder.getInstance(R.layout.fat_divider_item, convertView, parent).getItemView();
    }
}
