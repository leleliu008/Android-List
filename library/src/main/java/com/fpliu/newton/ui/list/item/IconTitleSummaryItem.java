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
    public IconTitleSummaryItem<T> showAsCircle() {
        return (IconTitleSummaryItem<T>) super.showAsCircle();
    }

    @Override
    public IconTitleSummaryItem<T> showAsRoundRect(int radius) {
        return (IconTitleSummaryItem<T>) super.showAsRoundRect(radius);
    }

    @Override
    public IconTitleSummaryItem<T> showAsRoundRect() {
        return (IconTitleSummaryItem<T>) super.showAsRoundRect();
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
        int shape = shape();
        if (icon instanceof Integer) {
            if (shape == SHAPE_ORIGIN) {
                holder.id(R.id.icon_title_summary_item_icon).image((Integer) icon);
            } else if (shape == SHAPE_CIRCLE) {
                holder.id(R.id.icon_title_summary_item_icon).imageCircle((Integer) icon);
            } else if (shape == SHAPE_ROUND_RECT) {
                holder.id(R.id.icon_title_summary_item_icon).imageRound((Integer) icon, radius());
            }
        } else if (icon instanceof String) {
            if (shape == SHAPE_ORIGIN) {
                holder.id(R.id.icon_title_summary_item_icon).image((String) icon, R.drawable.user_icon_default);
            } else if (shape == SHAPE_CIRCLE) {
                holder.id(R.id.icon_title_summary_item_icon).imageCircle((String) icon, R.drawable.user_icon_default);
            } else if (shape == SHAPE_ROUND_RECT) {
                holder.id(R.id.icon_title_summary_item_icon).imageRound((String) icon, R.drawable.user_icon_default, radius());
            }
        }
        holder.id(R.id.icon_title_summary_item_title).text(title());
        holder.id(R.id.icon_title_summary_item_summary).text(summary());
        holder.id(R.id.icon_title_summary_item_top_divider).visibility(isGroupFirst() ? View.GONE : View.VISIBLE);
        return holder.getItemView();
    }
}
