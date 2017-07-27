package com.fpliu.newton.ui.list.item;

import android.view.View;
import android.view.ViewGroup;

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
        ViewHolder holder = ViewHolder.getInstance(R.layout.icon_title_item, convertView, parent);

        holder.id(R.id.icon_title_item_title).text(title);

        if (icon instanceof Integer) {
            holder.id(R.id.icon_title_item_icon).image((Integer) icon);
        } else if (icon instanceof String) {
            imageDisplay.display(holder.id(R.id.icon_title_item_icon).getImageView(), (String) icon, R.drawable.user_icon_default);
        }

        holder.id(R.id.icon_title_item_top_divider).visibility(isGroupFirst() ? View.GONE : View.VISIBLE);

        return holder.getItemView();
    }
}
