package com.fpliu.newton.ui.list.item;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fpliu.newton.ui.list.R;
import com.fpliu.newton.ui.list.ViewHolder;

/**
 * 包含一个图标和一行文字
 *
 * @author 792793182@qq.com 2016-05-31.
 */
public class IconTitleItem<T> extends Item<IconTitleItem> {

    private T icon;

    private String title;

    private ImageDisplay imageDisplay;


    public IconTitleItem<T> icon(T icon) {
        this.icon = icon;
        return this;
    }

    public T icon() {
        return icon;
    }

    public IconTitleItem<T> title(String title) {
        this.title = title;
        return this;
    }

    public String title() {
        return title;
    }

    public IconTitleItem<T> imageDisplay(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
        return this;
    }

    public ImageDisplay imageDisplay() {
        return imageDisplay;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = ViewHolder.getViewHolder(R.layout.icon_title_item, convertView, parent);

        ImageView imageView = viewHolder.getWidgetView(R.id.icon_title_item_icon);
        TextView titleTv = viewHolder.getWidgetView(R.id.icon_title_item_title);

        if (icon instanceof Integer) {
            imageView.setImageResource((Integer) icon);
        } else if (icon instanceof String) {
            imageDisplay.display(imageView, (String) icon, R.drawable.user_icon_default);
        }

        titleTv.setText(title);

        ImageView topDivider = viewHolder.getWidgetView(R.id.icon_title_item_top_divider);
        if (isGroupFirst()) {
            topDivider.setVisibility(View.GONE);
        } else {
            topDivider.setVisibility(View.VISIBLE);
        }

        return viewHolder.getConvertView();
    }
}
