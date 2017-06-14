package com.fpliu.newton.ui.list.item;

import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

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
        ViewHolder viewHolder = ViewHolder.getViewHolder(R.layout.check_box_item, convertView, parent);

        TextView textTv = viewHolder.getWidgetView(R.id.check_box_item_text);
        textTv.setText(text);

        CheckBox checkBox = viewHolder.getWidgetView(R.id.check_box_item_checkbox);
        checkBox.setChecked(isChecked);
        if (convertView == null) {
            if (onCreateView != null) {
                onCreateView.onCreate(checkBox);
            }
        }

        ImageView topDivider = viewHolder.getWidgetView(R.id.check_box_item_top_divider);
        if (isGroupFirst()) {
            topDivider.setVisibility(View.GONE);
        } else {
            topDivider.setVisibility(View.VISIBLE);
        }

        return viewHolder.getConvertView();
    }

    public interface OnCreateView {
        void onCreate(CheckBox checkBox);
    }
}
