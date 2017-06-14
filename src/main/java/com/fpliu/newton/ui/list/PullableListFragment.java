package com.fpliu.newton.ui.list;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;

import com.fpliu.newton.ui.base.BaseView;
import com.fpliu.newton.ui.base.LazyFragment;
import com.fpliu.newton.ui.base.UIUtil;
import com.fpliu.newton.ui.pullable.PullableListView;
import com.fpliu.newton.ui.pullable.PullableViewContainer;
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback;
import com.fpliu.newton.ui.pullable.Type;

import java.util.Collection;
import java.util.List;

/**
 * @author 792793182@qq.com 2016-06-06.
 */
public abstract class PullableListFragment<T> extends LazyFragment implements AdapterView.OnItemClickListener, RefreshOrLoadMoreCallback<PullableListView> {

    private PullableViewContainer<PullableListView> pullableViewContainer;

    private ItemAdapter<T> itemAdapter;

    @Override
    public BaseView onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        BaseView baseView = super.onCreateView(inflater, container, savedInstanceState);

        Activity activity = getActivity();

        pullableViewContainer = new PullableViewContainer<>(activity, PullableListView.class);
        PullableListView pullableListView = pullableViewContainer.getPullableView();
        pullableListView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        pullableListView.setCacheColorHint(Color.TRANSPARENT);
        pullableListView.setDivider(new ColorDrawable(getResources().getColor(R.color.background_body)));
        pullableListView.setDividerHeight(UIUtil.dip2px(getActivity(), 15));

        if (itemAdapter == null) {
            itemAdapter = new ItemAdapter<T>(null) {
                @Override
                public View getView(int position, View convertView, ViewGroup parent) {
                    return PullableListFragment.this.getView(position, convertView, parent);
                }
            };
        }
        pullableListView.setAdapter(itemAdapter);
        pullableListView.setOnItemClickListener(this);
        addContentView(pullableViewContainer);

        return baseView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        pullableViewContainer.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                pullableViewContainer.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                pullableViewContainer.setRefreshOrLoadMoreCallback(PullableListFragment.this);
            }
        });
    }

    @Override
    protected void onFragmentStartLazy() {
        super.onFragmentStartLazy();
        onRefreshOrLoadMore(getPullableViewContainer(), Type.REFRESH, 1, 10);
    }

    public final void setItemAdapter(ItemAdapter<T> itemAdapter) {
        this.itemAdapter = itemAdapter;

        if (pullableViewContainer != null) {
            pullableViewContainer.getPullableView().setAdapter(itemAdapter);
        }
    }

    public final ItemAdapter<T> getListAdapter() {
        return itemAdapter;
    }

    public PullableViewContainer<PullableListView> getPullableViewContainer() {
        return pullableViewContainer;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

    }

    public final void setItems(List<T> items) {
        itemAdapter.setItems(items);
    }

    public final List<T> getItems() {
        return itemAdapter.getItems();
    }

    public final boolean addAll(Collection<? extends T> collection) {
        return itemAdapter.addAll(collection);
    }

    public final T set(int location, T item) {
        return itemAdapter.set(location, item);
    }

    public final boolean add(T item) {
        return itemAdapter.add(item);
    }

    public final T getItem(int position) {
        return itemAdapter.get(position);
    }

    public int getViewTypeCount() {
        return itemAdapter.getViewTypeCount();
    }

    public int getItemViewType(int position) {
        return itemAdapter.getItemViewType(position);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    protected final void canPullDown(boolean canPullDown) {
        pullableViewContainer.getPullableView().canPullDown(canPullDown);
    }

    protected final void canPullUp(boolean canPullUp) {
        pullableViewContainer.getPullableView().canPullUp(canPullUp);
    }
}
