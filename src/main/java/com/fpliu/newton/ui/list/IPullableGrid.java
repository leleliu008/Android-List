package com.fpliu.newton.ui.list;

import android.view.View;

/**
 * @author 792793182@qq.com 2017-06-30.
 */
public interface IPullableGrid<T, V extends View> extends IPullableList<T, V> {

    void setNumColumns(int numColumns);
}
