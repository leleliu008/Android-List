package com.fpliu.newton.ui.list.item;

import android.view.View;
import android.view.ViewGroup;

import com.fpliu.newton.ui.list.R;
import com.fpliu.newton.ui.list.ViewHolder;

/**
 * @author 792793182@qq.com 2016-06-01.
 */
public class IconTitleSummaryItem<T> extends IconTitleItem<T> {

    private String summary;

    @Override
    public IconTitleSummaryItem<T> icon(T icon) {
        return (IconTitleSummaryItem<T>) super.icon(icon);
    }

    @Override
    public IconTitleSummaryItem<T> imageDisplay(ImageDisplay imageDisplay) {
        return (IconTitleSummaryItem<T>) super.imageDisplay(imageDisplay);
    }

    @Override
    public IconTitleSummaryItem<T> title(String title) {
        return (IconTitleSummaryItem<T>) super.title(title);
    }

    public IconTitleSummaryItem<T> summary(String summary) {
        this.summary = summary;
        return this;
    }

    public String summary() {
        return summary;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.getInstance(R.layout.icon_title_summary_item, convertView, parent);
        T icon = icon();
        if (icon instanceof Integer) {
            holder.id(R.id.icon_title_summary_item_icon).image((Integer) icon);
        } else if (icon instanceof String) {
            imageDisplay().display(holder.id(R.id.icon_title_summary_item_icon).getImageView(), (String) icon, R.drawable.user_icon_default);
        }
        holder.id(R.id.icon_title_summary_item_title).text(title());
        holder.id(R.id.icon_title_summary_item_summary).text(summary());
        holder.id(R.id.icon_title_summary_item_top_divider).visibility(isGroupFirst() ? View.GONE : View.VISIBLE);
        return holder.getItemView();
    }
}
