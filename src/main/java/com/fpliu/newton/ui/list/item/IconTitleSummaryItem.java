package com.fpliu.newton.ui.list.item;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        ViewHolder viewHolder = ViewHolder.getViewHolder(R.layout.icon_title_summary_item, convertView, parent);

        ImageView imageView = viewHolder.getWidgetView(R.id.icon_title_summary_item_icon);
        TextView titleTv = viewHolder.getWidgetView(R.id.icon_title_summary_item_title);
        TextView summaryTv = viewHolder.getWidgetView(R.id.icon_title_summary_item_summary);

        T icon = icon();
        if (icon instanceof Integer) {
            imageView.setImageResource((Integer) icon);
        } else if (icon instanceof String) {
            imageDisplay().display(imageView, (String) icon, R.drawable.user_icon_default);
        }

        titleTv.setText(title());
        summaryTv.setText(summary());

        ImageView topDivider = viewHolder.getWidgetView(R.id.icon_title_summary_item_top_divider);
        if (isGroupFirst()) {
            topDivider.setVisibility(View.GONE);
        } else {
            topDivider.setVisibility(View.VISIBLE);
        }

        return viewHolder.getConvertView();
    }
}
