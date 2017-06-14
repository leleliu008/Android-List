package com.fpliu.newton.ui.list.item;

import android.view.View;
import android.view.ViewGroup;

/**
 *
 * @author 792793182@qq.com 2016-06-11.
 */
public abstract class Item<SubClass> {

    private int id;

    private boolean isGroupFirst = true;

    private boolean isGroupLast = true;

    public SubClass id(int id) {
        this.id = id;
        return (SubClass) this;
    }

    public int getId() {
        return id;
    }

    public SubClass isGroupFirst(boolean isGroupFirst) {
        this.isGroupFirst = isGroupFirst;
        return (SubClass) this;
    }

    public boolean isGroupFirst() {
        return isGroupFirst;
    }

    public SubClass isGroupLast(boolean isGroupLast) {
        this.isGroupLast = isGroupLast;
        return (SubClass) this;
    }

    public boolean isGroupLast() {
        return isGroupLast;
    }


    public abstract View getView(int position, View convertView, ViewGroup parent);
}
