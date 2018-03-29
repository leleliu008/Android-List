package com.fpliu.newton.ui.list.item;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;

import com.fpliu.newton.ui.list.R;
import com.fpliu.newton.ui.list.ViewHolder;

/**
 * 包含一个CheckBox
 *
 * @author 792793182@qq.com 2016-05-31.
 */
public class CheckBoxItem extends Item<CheckBoxItem> {

    private String text;

    private boolean isChecked;

    private OnCreateView onCreateView;


    public CheckBoxItem text(String text) {
        this.text = text;
        return this;
    }

    public String text() {
        return text;
    }

    public CheckBoxItem isChecked(boolean isChecked) {
        this.isChecked = isChecked;
        return this;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public CheckBoxItem onCreateView(OnCreateView onCreateView) {
        this.onCreateView = onCreateView;
        return this;
    }

    public OnCreateView onCreateView() {
        return onCreateView;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.getInstance(R.layout.check_box_item, convertView, parent);
        holder.id(R.id.check_box_item_text).text(text);
        CheckBox checkBox = holder.id(R.id.check_box_item_checkbox).checked(isChecked).getCheckBox();
        if (convertView == null && onCreateView != null) {
            onCreateView.onCreate(checkBox);
        }
        holder.id(R.id.check_box_item_top_divider).visibility(isGroupFirst() ? View.GONE : View.VISIBLE);
        return holder.getItemView();
    }

    public interface OnCreateView {
        void onCreate(CheckBox checkBox);
    }
}
