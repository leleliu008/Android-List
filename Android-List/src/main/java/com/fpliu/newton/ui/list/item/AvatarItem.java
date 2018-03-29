package com.fpliu.newton.ui.list.item;

import android.view.View;
import android.view.ViewGroup;

import com.fpliu.newton.ui.list.R;
import com.fpliu.newton.ui.list.ViewHolder;

/**
 * 文字 - 头像
 *
 * @author 792793182@qq.com 2016-06-01.
 */
public class AvatarItem extends Item<AvatarItem> {

    private static final int SHAPE_ORIGIN = 1;

    private static final int SHAPE_CIRCLE = 2;

    private static final int SHAPE_ROUND_RECT = 3;

    private String key;

    private String avatarUri;

    private int shape = SHAPE_ORIGIN;

    private int radius = 6;

    public AvatarItem key(String key) {
        this.key = key;
        return this;
    }

    public String key() {
        return key;
    }

    public AvatarItem avatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
        return this;
    }

    public String avatarUri() {
        return avatarUri;
    }

    public AvatarItem showAsCircle() {
        this.shape = SHAPE_CIRCLE;
        return this;
    }

    public AvatarItem showAsRoundRect(int radius) {
        this.shape = SHAPE_ROUND_RECT;
        this.radius = radius;
        return this;
    }

    public AvatarItem showAsRoundRect() {
        this.shape = SHAPE_ROUND_RECT;
        return this;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.getInstance(R.layout.kv_image_item, convertView, parent);
        holder.id(R.id.kv_image_item_key).text(key);
        if (shape == SHAPE_ORIGIN) {
            holder.id(R.id.kv_image_item_value).image(avatarUri, R.drawable.user_icon_default);
        } else if (shape == SHAPE_CIRCLE) {
            holder.id(R.id.kv_image_item_value).imageCircle(avatarUri, R.drawable.user_icon_default);
        } else if (shape == SHAPE_ROUND_RECT) {
            holder.id(R.id.kv_image_item_value).imageRound(avatarUri, R.drawable.user_icon_default, radius);
        }
        holder.id(R.id.kv_image_item_top_divider).visibility(isGroupFirst() ? View.GONE : View.VISIBLE);
        return holder.getItemView();
    }
}
