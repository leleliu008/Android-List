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
public class KVImageItem extends Item<KVImageItem> {

    private String key;

    private String avatarUri;

    private ImageDisplay imageDisplay;


    public KVImageItem key(String key) {
        this.key = key;
        return this;
    }

    public String key() {
        return key;
    }

    public KVImageItem avatarUri(String avatarUri) {
        this.avatarUri = avatarUri;
        return this;
    }

    public String avatarUri() {
        return avatarUri;
    }

    public KVImageItem imageDisplay(ImageDisplay imageDisplay) {
        this.imageDisplay = imageDisplay;
        return this;
    }

    public ImageDisplay imageDisplay() {
        return imageDisplay;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.getInstance(R.layout.kv_image_item, convertView, parent);
        holder.id(R.id.kv_image_item_key).text(key);
        imageDisplay.display(holder.id(R.id.kv_image_item_value).getImageView(), avatarUri, R.drawable.user_icon_default);
        holder.id(R.id.kv_image_item_top_divider).visibility(isGroupFirst() ? View.GONE : View.VISIBLE);
        return holder.getItemView();
    }
}
