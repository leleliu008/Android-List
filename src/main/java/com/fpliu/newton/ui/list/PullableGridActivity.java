package com.fpliu.newton.ui.list;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;

import com.fpliu.newton.ui.base.BaseActivity;
import com.fpliu.newton.ui.pullable.PullableGridView;
import com.fpliu.newton.ui.pullable.PullableViewContainer;
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback;

import java.util.Collection;
import java.util.List;

/**
 * @author 792793182@qq.com 2016-06-06.
 */
public abstract class PullableGridActivity<T> extends BaseActivity implements RefreshOrLoadMoreCallback<PullableGridView>, AdapterView.OnItemClickListener {

    private PullableViewContainer<PullableGridView> pullableViewContainer;

    private ItemAdapter<T> itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pullableViewContainer = new PullableViewContainer<>(this, PullableGridView.class);
        addContentView(pullableViewContainer);

        PullableGridView pullableGridView = pullableViewContainer.getPullableView();
        pullableGridView.setBackgroundColor(Color.TRANSPARENT);
        pullableGridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        pullableGridView.setCacheColorHint(Color.TRANSPARENT);

        if (itemAdapter == null) {
            itemAdapter = new ItemAdapter<T>(null) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    return PullableGridActivity.this.getView(position, convertView, parent);
                }
            };
        }
        pullableGridView.setAdapter(itemAdapter);

        pullableViewContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                pullableViewContainer.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                pullableViewContainer.setRefreshOrLoadMoreCallback(PullableGridActivity.this);
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

    public PullableViewContainer<PullableGridView> getPullableViewContainer() {
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

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

    }

    protected final boolean add(T item) {
        return itemAdapter.add(item);
    }

    protected final T getItem(int position) {
        return itemAdapter.get(position);
    }

    protected int getViewTypeCount() {
        return itemAdapter.getViewTypeCount();
    }

    protected int getItemViewType(int position) {
        return itemAdapter.getItemViewType(position);
    }

    protected View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    protected final void canPullDown(boolean canPullDown) {
        pullableViewContainer.getPullableView().canPullDown(canPullDown);
    }

    protected final void canPullUp(boolean canPullUp) {
        pullableViewContainer.getPullableView().canPullUp(canPullUp);
    }
}
