package com.fpliu.newton.ui.list;

import android.content.Context;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

import com.fpliu.newton.log.Logger;
import com.fpliu.newton.ui.pullable.PullType;
import com.fpliu.newton.ui.pullable.PullableViewContainer;
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback;
import com.fpliu.newton.ui.recyclerview.ItemAdapter;
import com.fpliu.newton.ui.recyclerview.ItemViewHolderAbs;
import com.fpliu.newton.ui.recyclerview.OnItemClickListener;
import com.fpliu.newton.ui.stateview.StateView;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static android.support.v7.widget.DividerItemDecoration.VERTICAL;

/**
 * @author 792793182@qq.com 2017-06-29.
 */
public class PullableRecyclerViewImpl<T, H extends ItemViewHolderAbs> implements IPullableRecyclerView<T, H> {

    private LinearLayout headPanel;

    private LinearLayout footerPanel;

    private PullableViewContainer<RecyclerView> pullableViewContainer;

    private ItemAdapter<T, H> itemAdapter;

    @Override
    public View init(Context context) {
        LinearLayout contentView = new LinearLayout(context);
        contentView.setOrientation(LinearLayout.VERTICAL);

        headPanel = new LinearLayout(context);
        headPanel.setOrientation(LinearLayout.VERTICAL);

        contentView.addView(headPanel, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        pullableViewContainer = new PullableViewContainer<>(context, RecyclerView.class);
        contentView.addView(pullableViewContainer, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));

        RecyclerView recyclerView = pullableViewContainer.getPullableView();
        recyclerView.setLayoutManager(new LinearLayoutManager(context) {
            @Override
            public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
                try {
                    super.onLayoutChildren(recycler, state);
                } catch (Exception e) {
                    Logger.e(PullableRecyclerViewImpl.class.getSimpleName(), "onLayoutChildren()", e);
                }
            }
        });
        recyclerView.addItemDecoration(new DividerItemDecoration(context, VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        footerPanel = new LinearLayout(context);
        footerPanel.setOrientation(LinearLayout.VERTICAL);

        contentView.addView(footerPanel, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        return contentView;
    }

    @Override
    public PullableViewContainer<RecyclerView> getPullableViewContainer() {
        return pullableViewContainer;
    }

    @Override
    public void setItemAdapter(ItemAdapter<T, H> itemAdapter) {
        this.itemAdapter = itemAdapter;

        if (pullableViewContainer != null) {
            pullableViewContainer.getPullableView().setAdapter(itemAdapter);
        }
    }

    @Override
    public ItemAdapter<T, H> getItemAdapter() {
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
    public boolean removeThenShowActionIfEmpty(T item, CharSequence message, String actionText, Runnable action) {
        boolean isSuccess = itemAdapter.remove(item);
        if (isSuccess && itemAdapter.isEmpty()) {
            StateView stateView = pullableViewContainer.getStateView();
            if (stateView != null) {
                stateView.setVisibility(View.VISIBLE);
                stateView.showErrorWithAction(message, actionText, action);
            }
        }
        return isSuccess;
    }

    @Override
    public void clear() {
        itemAdapter.clear();
    }

    @Override
    public void clearThenShowAction(CharSequence message, String actionText, Runnable action) {
        itemAdapter.clear();
        StateView stateView = pullableViewContainer.getStateView();
        if (stateView != null) {
            stateView.setVisibility(View.VISIBLE);
            stateView.showErrorWithAction(message, actionText, action);
        }
    }

    @Override
    public T getItem(int position) {
        return itemAdapter.getItem(position);
    }

    @Override
    public int getItemCount() {
        return itemAdapter.getItemCount();
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public H onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(H holder, int position, T item) {

    }

    @Override
    public void setOnItemClickListener(OnItemClickListener<T, H> onItemClickListener) {
        itemAdapter.setOnItemClickListener(onItemClickListener);
    }

    @Override
    public void notifyDataSetChanged() {
        itemAdapter.notifyDataSetChanged();
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
    public void canPullDown(boolean canPullDown) {
        pullableViewContainer.getRefreshLayout().setEnableRefresh(canPullDown);
    }

    @Override
    public void canPullUp(boolean canPullUp) {
        pullableViewContainer.getRefreshLayout().setEnableLoadmore(canPullUp);
    }

    @Override
    public void finishRequestSuccess(PullType type, List<T> items) {
        if (type == PullType.UP) {
            addAll(items);
        } else {
            setItems(items);
        }
        pullableViewContainer.finishRequestSuccess(type);
    }

    @Override
    public void finishRequestSuccess(PullType type, List<T> items, String itemsEmptyMessageWhenRefresh) {
        if (type == PullType.UP) {
            addAll(items);
            pullableViewContainer.finishRequestSuccess(type);
        } else {
            if (items == null || items.isEmpty()) {
                clear();
                pullableViewContainer.finishRequestWithRefresh(type, true, "刷新成功", itemsEmptyMessageWhenRefresh);
            } else {
                setItems(items);
                pullableViewContainer.finishRequestSuccess(type);
            }
        }
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

    @Override
    public void setLayoutManager(RecyclerView.LayoutManager layoutManager) {
        pullableViewContainer.getPullableView().setLayoutManager(layoutManager);
    }

    @Override
    public void addItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        pullableViewContainer.getPullableView().addItemDecoration(itemDecoration);
    }

    @Override
    public void removeItemDecoration(RecyclerView.ItemDecoration itemDecoration) {
        pullableViewContainer.getPullableView().removeItemDecoration(itemDecoration);
    }

    @Override
    public ArrayList<RecyclerView.ItemDecoration> getItemDecorations() {
        RecyclerView recyclerView = pullableViewContainer.getPullableView();
        try {
            Field mItemDecorationsField = RecyclerView.class.getDeclaredField("mItemDecorations");
            mItemDecorationsField.setAccessible(true);
            return (ArrayList<RecyclerView.ItemDecoration>) mItemDecorationsField.get(recyclerView);
        } catch (Exception e) {
            Logger.e(getClass().getSimpleName(), "getItemDecorations()", e);
            return new ArrayList<>();
        }
    }

    @Override
    public void clearItemDecorations() {
        getItemDecorations().clear();
    }

    @Override
    public void setItemAnimator(RecyclerView.ItemAnimator itemAnimator) {
        pullableViewContainer.getPullableView().setItemAnimator(itemAnimator);
    }
}
