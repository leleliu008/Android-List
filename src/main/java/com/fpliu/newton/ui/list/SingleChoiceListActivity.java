package com.fpliu.newton.ui.list;

import android.app.Activity;
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

/**
 * 单选
 *
 * @author 792793182@qq.com 2016-08-04.
 */
public abstract class SingleChoiceListActivity<T> extends ListActivity<T> {

    private int selectedIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ListView listView = getListView();
        listView.setDivider(new ColorDrawable(getResources().getColor(R.color.divider)));
        listView.setDividerHeight(1);

        getContentView().setRightViewStrategy(new TextBtn() {
            @Override
            public Button getView(RelativeLayout headView) {
                Button commitBtn = super.getView(headView);
                commitBtn.setEnabled(true);
                return commitBtn;
            }
        }).getRightBtnClickObservable().compose(bindToLifecycle()).subscribe(o -> onRightBtnClick(SingleChoiceListActivity.this));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View convertView, int position, long id) {
        if (selectedIndex == position) {
            return;
        }
        selectedIndex = position;
        getListAdapter().notifyDataSetChanged();
    }

    @Override
    protected View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = ViewHolder.getViewHolder(R.layout.single_choice_activity, convertView, parent);

        TextView textView = viewHolder.getWidgetView(R.id.single_choice_activity_tv);
        if (position == selectedIndex) {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_radio_checked, 0, 0, 0);
        } else {
            textView.setCompoundDrawablesWithIntrinsicBounds(R.drawable.btn_radio_unchecked, 0, 0, 0);
        }
        textView.setText(getItemDisplay(position));

        return viewHolder.getConvertView();
    }

    public final void setSelectedIndex(int selectedIndex) {
        this.selectedIndex = selectedIndex;
    }

    public final int getSelectedIndex() {
        return selectedIndex;
    }

    protected abstract String getItemDisplay(int position);

    protected void onRightBtnClick(Activity activity) {

    }
}
