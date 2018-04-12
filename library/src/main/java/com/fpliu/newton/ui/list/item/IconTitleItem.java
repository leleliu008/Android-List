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

    protected static final int SHAPE_ORIGIN = 1;

    protected static final int SHAPE_CIRCLE = 2;

    protected static final int SHAPE_ROUND_RECT = 3;

    private T icon;

    private String title;

    private int shape = SHAPE_ORIGIN;

    private int radius = 6;


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

    public IconTitleItem<T> showAsCircle() {
        this.shape = SHAPE_CIRCLE;
        return this;
    }

    public IconTitleItem<T> showAsRoundRect(int radius) {
        this.shape = SHAPE_ROUND_RECT;
        this.radius = radius;
        return this;
    }

    public IconTitleItem<T> showAsRoundRect() {
        this.shape = SHAPE_ROUND_RECT;
        return this;
    }

    public int shape() {
        return shape;
    }

    public int radius() {
        return radius;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.getInstance(R.layout.icon_title_item, convertView, parent);
        holder.id(R.id.icon_title_item_title).text(title);
        if (icon instanceof Integer) {
            if (shape == SHAPE_ORIGIN) {
                holder.id(R.id.icon_title_item_icon).image((Integer) icon);
            } else if (shape == SHAPE_CIRCLE) {
                holder.id(R.id.icon_title_item_icon).imageCircle((Integer) icon);
            } else if (shape == SHAPE_ROUND_RECT) {
                holder.id(R.id.icon_title_item_icon).imageRound((Integer) icon, radius);
            }
        } else if (icon instanceof String) {
            if (shape == SHAPE_ORIGIN) {
                holder.id(R.id.icon_title_item_icon).image((String) icon, R.drawable.user_icon_default);
            } else if (shape == SHAPE_CIRCLE) {
                holder.id(R.id.icon_title_item_icon).imageCircle((String) icon, R.drawable.user_icon_default);
            } else if (shape == SHAPE_ROUND_RECT) {
                holder.id(R.id.icon_title_item_icon).imageRound((String) icon, R.drawable.user_icon_default, radius);
            }
        }
        holder.id(R.id.icon_title_item_top_divider).visibility(isGroupFirst() ? View.GONE : View.VISIBLE);
        return holder.getItemView();
    }
}
