package com.fpliu.newton.ui.list;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.LinearLayout;

import com.fpliu.newton.ui.base.UIUtil;
import com.fpliu.newton.ui.pullable.PullableListView;
import com.fpliu.newton.ui.pullable.PullableViewContainer;
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback;
import com.fpliu.newton.ui.pullable.Type;

import java.util.Collection;
import java.util.List;

/**
 * @author 792793182@qq.com 2017-06-29.
 */
public class PullableListImpl<T> implements IPullableList<T, PullableListView> {

    private LinearLayout headPanel;

    private LinearLayout footerPanel;

    private PullableViewContainer<PullableListView> pullableViewContainer;

    private ItemAdapter<T> itemAdapter;

    @Override
    public View init(Context context) {
        LinearLayout contentView = new LinearLayout(context);
        contentView.setOrientation(LinearLayout.VERTICAL);

        headPanel = new LinearLayout(context);
        headPanel.setOrientation(LinearLayout.VERTICAL);

        contentView.addView(headPanel, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        pullableViewContainer = new PullableViewContainer<>(context, PullableListView.class);
        contentView.addView(pullableViewContainer, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));

        PullableListView pullableListView = pullableViewContainer.getPullableView();
        pullableListView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        pullableListView.setCacheColorHint(Color.TRANSPARENT);
        pullableListView.setDivider(new ColorDrawable(context.getResources().getColor(R.color.background_body)));
        pullableListView.setDividerHeight(UIUtil.dip2px(context, 1));

        footerPanel = new LinearLayout(context);
        footerPanel.setOrientation(LinearLayout.VERTICAL);

        contentView.addView(footerPanel, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        return contentView;
    }

    @Override
    public PullableViewContainer<PullableListView> getPullableViewContainer() {
        return pullableViewContainer;
    }

    @Override
    public void setItemAdapter(ItemAdapter<T> itemAdapter) {
        this.itemAdapter = itemAdapter;

        if (pullableViewContainer != null) {
            pullableViewContainer.getPullableView().setAdapter(itemAdapter);
        }
    }

    @Override
    public ItemAdapter<T> getItemAdapter() {
        return itemAdapter;
    }

    @Override
    public void setItems(List<T> items) {
        itemAdapter.setItems(items);
    }

    @Override
    public List<T> getItems() {
        return itemAdapter.getItems();
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        return itemAdapter.addAll(collection);
    }

    @Override
    public boolean add(T item) {
        return itemAdapter.add(item);
    }

    @Override
    public T set(int location, T item) {
        return itemAdapter.set(location, item);
    }

    @Override
    public boolean remove(T item) {
        return itemAdapter.remove(item);
    }

    @Override
    public void clear() {
        itemAdapter.clear();
    }

    @Override
    public T getItem(int position) {
        return itemAdapter.getItem(position);
    }

    @Override
    public int getCount() {
        return itemAdapter.getCount();
    }

    @Override
    public int getItemViewTypeCount() {
        return 1;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public void notifyDataSetChanged() {
        itemAdapter.notifyDataSetChanged();
    }

    @Override
    public void setDividerHeight(int height) {
        pullableViewContainer.getPullableView().setDividerHeight(height);
    }

    @Override
    public void setViewBeforeBody(int layoutId) {
        LayoutInflater.from(headPanel.getContext()).inflate(layoutId, headPanel, true);
    }

    @Override
    public void setViewBeforeBody(View view) {
        headPanel.addView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
    }

    @Override
    public void setViewAfterBody(int layoutId) {
        LayoutInflater.from(footerPanel.getContext()).inflate(layoutId, footerPanel, true);
    }

    @Override
    public void setViewAfterBody(View view) {
        footerPanel.addView(view, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
    }

    @Override
    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        pullableViewContainer.getPullableView().setOnItemClickListener(listener);
    }

    @Override
    public void canPullDown(boolean canPullDown) {
        pullableViewContainer.getPullableView().canPullDown(canPullDown);
    }

    @Override
    public void canPullUp(boolean canPullUp) {
        pullableViewContainer.getPullableView().canPullUp(canPullUp);
    }

    @Override
    public void finishRequestSuccess(Type type, List<T> items) {
        if (type == Type.LOAD_MORE) {
            addAll(items);
        } else {
            setItems(items);
        }
        pullableViewContainer.finishRequestSuccess(type);
    }

    public void setRefreshOrLoadMoreCallback(final RefreshOrLoadMoreCallback callback) {
        pullableViewContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                pullableViewContainer.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                pullableViewContainer.setRefreshOrLoadMoreCallback(callback);
            }
        });
    }

    @Override
    public void refresh() {
        pullableViewContainer.refresh();
    }
}
