package com.fpliu.newton.ui.list;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fpliu.newton.ui.base.TextBtn;

import java.util.List;

/**
 * 多选
 *
 * @author 792793182@qq.com 2016-08-04.
 */
public class MultiChoiceListActivity extends ListActivity<MultiChoiceListActivity.Item> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getContentView()
                .setRightViewStrategy(new TextBtn() {
                    @Override
                    public Button getView(RelativeLayout headView) {
                        Button okBtn = super.getView(headView);
                        okBtn.setText("确定");
                        return okBtn;
                    }
                })
                .getRightBtnClickObservable()
                .compose(bindToLifecycle())
                .subscribe(o -> onResult(getItems()));

        ListView listView = getListView();
        listView.setDivider(new ColorDrawable(getResources().getColor(R.color.divider)));
        listView.setDividerHeight(1);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View convertView, int position, long id) {
        super.onItemClick(adapterView, convertView, position, id);

        getItem(position).toggle();
        getListAdapter().notifyDataSetChanged();
    }

    @Override
    protected View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = ViewHolder.getViewHolder(R.layout.single_choice_activity, convertView, parent);

        TextView textView = viewHolder.getWidgetView(R.id.single_choice_activity_tv);

        Item item = getItem(position);
        if (item.isSelected()) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_check_box_enabled_checked_blue, 0, 0, 0);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_check_box_enabled_unchecked_blue, 0, 0, 0);
        }
        textView.setText(item.getDisplay());

        return viewHolder.getConvertView();
    }

    protected void onResult(List<Item> items) {
        finish();
    }

    public static class Item {

        private String key;

        private String display;

        private boolean isSelected;

        public String getKey() {
            return key;
        }

        public Item setKey(String key) {
            this.key = key;
            return this;
        }

        public String getDisplay() {
            return display;
        }

        public Item setDisplay(String display) {
            this.display = display;
            return this;
        }

        public boolean isSelected() {
            return isSelected;
        }

        public Item setSelected(boolean selected) {
            isSelected = selected;
            return this;
        }

        public Item toggle() {
            isSelected = !isSelected;
            return this;
        }
    }
}