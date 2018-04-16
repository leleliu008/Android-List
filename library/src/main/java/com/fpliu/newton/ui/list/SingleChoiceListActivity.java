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
            public Button onCreateView(RelativeLayout headView) {
                Button commitBtn = super.onCreateView(headView);
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
        getItemAdapter().notifyDataSetChanged();
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        return ViewHolder
                .getInstance(R.layout.single_choice_activity, convertView, parent)
                .id(R.id.single_choice_activity_tv)
                .compoundDrawablesWithIntrinsicBounds(position == selectedIndex ? R.drawable.btn_radio_checked : R.drawable.btn_radio_unchecked, 0, 0, 0)
                .text(getItemDisplay(position))
                .getItemView();
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