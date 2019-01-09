package com.fpliu.newton.ui.list;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.fpliu.newton.ui.base.HeadBarLayout;
import com.fpliu.newton.ui.base.TextBtn;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import java.util.List;

import androidx.lifecycle.Lifecycle;

import static com.uber.autodispose.AutoDispose.autoDisposable;

/**
 * 多选
 *
 * @author 792793182@qq.com 2016-08-04.
 */
public class MultiChoiceListActivity extends ListActivity<MultiChoiceListActivity.Item> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        HeadBarLayout headBarLayout = getContentView().getHeadBarLayout();
        headBarLayout.setRightViewStrategy(new TextBtn() {
            @Override
            public Button onCreateView(Context context) {
                Button okBtn = super.onCreateView(context);
                okBtn.setText("确定");
                return okBtn;
            }
        });
        headBarLayout.getRightBtnClickObservable()
            .as(autoDisposable(AndroidLifecycleScopeProvider.from(this, Lifecycle.Event.ON_DESTROY)))
            .subscribe(o -> onResult(getItems()));

        ListView listView = getListView();
        listView.setDivider(new ColorDrawable(getResources().getColor(R.color.divider)));
        listView.setDividerHeight(1);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View convertView, int position, long id) {
        super.onItemClick(adapterView, convertView, position, id);

        getItem(position).toggle();
        getItemAdapter().notifyDataSetChanged();
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        Item item = getItem(position);
        return ViewHolder
            .getInstance(R.layout.single_choice_activity, convertView, parent)
            .id(R.id.single_choice_activity_tv)
            .compoundDrawablesWithIntrinsicBounds(item.isSelected() ? R.drawable.btn_check_box_enabled_checked_blue : R.drawable.btn_check_box_enabled_unchecked_blue, 0, 0, 0)
            .text(item.getDisplay())
            .getItemView();
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