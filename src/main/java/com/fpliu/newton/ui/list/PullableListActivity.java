package com.fpliu.newton.ui.list;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.fpliu.newton.ui.base.BaseActivity;
import com.fpliu.newton.ui.base.UIUtil;
import com.fpliu.newton.ui.pullable.PullableListView;
import com.fpliu.newton.ui.pullable.PullableViewContainer;
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback;

import java.util.Collection;
import java.util.List;

/**
 * 可以下拉刷新和上拉加载更多
 *
 * @author 792793182@qq.com 2016-06-06.
 */
public abstract class PullableListActivity<T> extends BaseActivity
        implements AdapterView.OnItemClickListener, RefreshOrLoadMoreCallback<PullableListView> {

    private LinearLayout bodyBeforePanel;

    private LinearLayout bodyAfterPanel;

    private PullableViewContainer<PullableListView> pullableViewContainer;

    private ItemAdapter<T> itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        bodyBeforePanel = new LinearLayout(this);
        bodyBeforePanel.setOrientation(LinearLayout.VERTICAL);

        linearLayout.addView(bodyBeforePanel, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        pullableViewContainer = new PullableViewContainer<>(this, PullableListView.class);
        linearLayout.addView(pullableViewContainer, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));

        PullableListView pullableListView = pullableViewContainer.getPullableView();
        pullableListView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        pullableListView.setCacheColorHint(Color.TRANSPARENT);
        pullableListView.setDivider(new ColorDrawable(getResources().getColor(R.color.background_body)));
        pullableListView.setDividerHeight(UIUtil.dip2px(this, 15));

        if (itemAdapter == null) {
            itemAdapter = new ItemAdapter<T>(null) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    return PullableListActivity.this.getView(position, convertView, parent);
                }

                @Override
                public int getViewTypeCount() {
                    return PullableListActivity.this.getViewTypeCount();
                }

                @Override
                public int getItemViewType(int position) {
                    return PullableListActivity.this.getItemViewType(position);
                }
            };
        }
        pullableListView.setAdapter(itemAdapter);
        pullableListView.setOnItemClickListener(this);

        bodyAfterPanel = new LinearLayout(this);
        bodyAfterPanel.setOrientation(LinearLayout.VERTICAL);

        linearLayout.addView(bodyAfterPanel, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        addContentView(linearLayout);

        pullableViewContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                pullableViewContainer.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                pullableViewContainer.setRefreshOrLoadMoreCallback(PullableListActivity.this);
            }
        });
    }

    protected final void setItemAdapter(ItemAdapter<T> itemAdapter) {
        this.itemAdapter = itemAdapter;

        if (pullableViewContainer != null) {
            pullableViewContainer.getPullableView().setAdapter(itemAdapter);
        }
    }

    protected final ItemAdapter<T> getListAdapter() {
        return itemAdapter;
    }

    public PullableViewContainer<PullableListView> getPullableViewContainer() {
        return pullableViewContainer;
    }

    protected final void setItems(List<T> items) {
        itemAdapter.setItems(items);
    }

    protected final List<T> getItems() {
        return itemAdapter.getItems();
    }

    protected final boolean addAll(Collection<? extends T> collection) {
        return itemAdapter.addAll(collection);
    }

    protected final T set(int location, T item) {
        return itemAdapter.set(location, item);
    }

    protected final boolean add(T item) {
        return itemAdapter.add(item);
    }

    protected final boolean remove(T item) {
        return itemAdapter.remove(item);
    }

    protected final T getItem(int position) {
        return itemAdapter.get(position);
    }

    protected final int getCount() {
        return itemAdapter.getCount();
    }

    protected int getViewTypeCount() {
        return 1;
    }

    protected int getItemViewType(int position) {
        return 0;
    }

    protected View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }

    protected final void clear() {
        itemAdapter.clear();
    }

    public void setBodyBeforeView(int layoutId) {
        bodyBeforePanel.addView(LayoutInflater.from(this).inflate(layoutId, bodyBeforePanel, false));
    }

    public void setBodyBeforeView(View bodyBeforeView) {
        bodyBeforePanel.addView(bodyBeforeView, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
    }

    public void setBodyAfterView(int layoutId) {
        bodyAfterPanel.addView(LayoutInflater.from(this).inflate(layoutId, bodyAfterPanel, false));
    }

    public void setBodyAfterView(View bodyBeforeView) {
        bodyAfterPanel.addView(bodyBeforeView, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
    }

    protected final void canPullDown(boolean canPullDown) {
        pullableViewContainer.getPullableView().canPullDown(canPullDown);
    }

    protected final void canPullUp(boolean canPullUp) {
        pullableViewContainer.getPullableView().canPullUp(canPullUp);
    }
}
