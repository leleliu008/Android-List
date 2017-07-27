package com.fpliu.newton.ui.list.item;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.fpliu.newton.ui.list.R;
import com.fpliu.newton.ui.list.ViewHolder;

/**
 * @author 792793182@qq.com 2016-06-01.
 */
public class EditTextItem extends Item<EditTextItem> {

    private String key;

    private String value;

    private String summary;

    private String unit;

    private OnCreateView onCreateView;


    public EditTextItem key(String key) {
        this.key = key;
        return this;
    }

    public String key() {
        return key;
    }

    public EditTextItem value(String value) {
        this.value = value;
        return this;
    }

    public String value() {
        return value;
    }

    public EditTextItem summary(String summary) {
        this.summary = summary;
        return this;
    }

    public String summary() {
        return summary;
    }

    public EditTextItem unit(String unit) {
        this.unit = unit;
        return this;
    }

    public String unit() {
        return unit;
    }

    public EditTextItem onCreateView(OnCreateView onCreateView) {
        this.onCreateView = onCreateView;
        return this;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.getInstance(R.layout.edit_text_item, convertView, parent);

        holder.id(R.id.edit_text_item_key).text(key);

        ImageView summaryDivider = holder.id(R.id.edit_text_item_summary_divider).getImageView();
        TextView summaryTv = holder.id(R.id.edit_text_item_summary).getTextView();
        if (TextUtils.isEmpty(summary)) {
            summaryTv.setVisibility(View.GONE);
            summaryDivider.setVisibility(View.GONE);
        } else {
            summaryTv.setText(summary);
            summaryTv.setVisibility(View.VISIBLE);
            summaryDivider.setVisibility(View.VISIBLE);
        }

        EditText valueEt = holder.id(R.id.edit_text_item_value).text(value).getEditText();
        if (convertView == null) {
            if (onCreateView != null) {
                onCreateView.onCreate(valueEt);
            }
        }

        holder.id(R.id.edit_text_item_unit).text(unit);
        holder.id(R.id.edit_text_item_top_divider).visibility(isGroupFirst() ? View.GONE : View.VISIBLE);
        return holder.getItemView();
    }

    public interface OnCreateView {
        void onCreate(EditText editText);
    }
}
