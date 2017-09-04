package com.fpliu.newton.ui.list;

import android.content.Context;
import android.view.View;

import java.util.Collection;
import java.util.List;

/**
 * 公共操作
 *
 * @author 792793182@qq.com 2017-06-29.
 */
public interface ICommon<T> {

    View init(Context context);

    void setItems(List<T> items);

    List<T> getItems();

    boolean addAll(Collection<? extends T> collection);

    boolean add(T item);

    T set(int location, T item);

    boolean remove(T item);

    void clear();

    int getItemCount();

    T getItem(int position);

    void setViewBeforeBody(int layoutId);

    void setViewBeforeBody(View view);

    void setViewAfterBody(int layoutId);

    void setViewAfterBody(View view);
}
