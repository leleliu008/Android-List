package com.fpliu.newton.ui.list;

import android.view.View;
import android.view.ViewGroup;

/**
 * Adapter优化
 *
 * @author 792793182@qq.com 2015-06-11
 */
public final class ViewHolder extends ViewHolderAbs<ViewHolder> {

    private ViewHolder(int layoutId, ViewGroup parent) {
        super(layoutId, parent);
    }

    public static ViewHolder getInstance(int layoutId, View convertView, ViewGroup parent) {
        return getInstance(layoutId, convertView, parent, ViewHolder.class);
    }
}
