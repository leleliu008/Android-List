package com.fpliu.newton.ui.list;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;

import com.fpliu.newton.ui.pullable.PullType;
import com.fpliu.newton.ui.pullable.PullableViewContainer;
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback;

import java.util.Collection;
import java.util.List;

/**
 * @author 792793182@qq.com 2017-06-29.
 */
public class PullableGridImpl<T> implements IPullable<T, GridView>, IGrid<T, GridView> {

    private LinearLayout headPanel;

    private LinearLayout footerPanel;

    private PullableViewContainer<GridView> pullableViewContainer;

    private ItemAdapter<T> itemAdapter;

    @Override
    public View init(Context context) {
        LinearLayout contentView = new LinearLayout(context);
        contentView.setOrientation(LinearLayout.VERTICAL);

        headPanel = new LinearLayout(context);
        headPanel.setOrientation(LinearLayout.VERTICAL);

        contentView.addView(headPanel, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        pullableViewContainer = new PullableViewContainer<>(context, GridView.class);
        contentView.addView(pullableViewContainer, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1));

        GridView gridView = pullableViewContainer.getPullableView();
        gridView.setSelector(new ColorDrawable(Color.TRANSPARENT));
        gridView.setCacheColorHint(Color.TRANSPARENT);

        footerPanel = new LinearLayout(context);
        footerPanel.setOrientation(LinearLayout.VERTICAL);

        contentView.addView(footerPanel, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));

        return contentView;
    }

    @Override
    public PullableViewContainer<GridView> getPullableViewContainer() {
        return pullableViewContainer;
    }

    @Override
    public GridView getGridView() {
        return pullableViewContainer.getPullableView();
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
    public T removeAt(int position) {
        return itemAdapter.remove(position);
    }

    @Override
    public T removeLastItem() {
        return itemAdapter.removeLastItem();
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
    public boolean removeThenShowMessageIfEmpty(T item, CharSequence message) {
        boolean isSuccess = itemAdapter.remove(item);
        if (isSuccess && itemAdapter.isEmpty()) {
            pullableViewContainer.showErrorText(message);
        }
        return isSuccess;
    }

    @Override
    public boolean removeThenShowImageIfEmpty(T item, int imageResId) {
        boolean isSuccess = itemAdapter.remove(item);
        if (isSuccess && itemAdapter.isEmpty()) {
            pullableViewContainer.showErrorImage(imageResId);
        }
        return isSuccess;
    }

    @Override
    public boolean removeThenShowImageAndTextIfEmpty(T item, int imageResId, CharSequence message) {
        boolean isSuccess = itemAdapter.remove(item);
        if (isSuccess && itemAdapter.isEmpty()) {
            pullableViewContainer.showErrorImageAndText(imageResId, message);
        }
        return isSuccess;
    }

    @Override
    public boolean removeThenShowRefreshActionIfEmpty(T item, CharSequence message) {
        boolean isSuccess = itemAdapter.remove(item);
        if (isSuccess && itemAdapter.isEmpty()) {
            pullableViewContainer.showErrorTextWithRefreshAction(message);
        }
        return isSuccess;
    }

    @Override
    public boolean removeThenShowRefreshActionIfEmpty(T item, int imageResId) {
        boolean isSuccess = itemAdapter.remove(item);
        if (isSuccess && itemAdapter.isEmpty()) {
            pullableViewContainer.showErrorImageWithRefreshAction(imageResId);
        }
        return isSuccess;
    }

    @Override
    public boolean removeThenShowRefreshActionIfEmpty(T item, int imageResId, CharSequence message) {
        boolean isSuccess = itemAdapter.remove(item);
        if (isSuccess && itemAdapter.isEmpty()) {
            pullableViewContainer.showErrorImageAndTextWithRefreshAction(imageResId, message);
        }
        return isSuccess;
    }

    @Override
    public boolean removeThenShowActionIfEmpty(T item, CharSequence message, String actionText, Runnable action) {
        boolean isSuccess = itemAdapter.remove(item);
        if (isSuccess && itemAdapter.isEmpty()) {
            pullableViewContainer.showErrorTextWithAction(message, actionText, action);
        }
        return isSuccess;
    }

    @Override
    public boolean removeThenShowActionIfEmpty(T item, int imageResId, String actionText, Runnable action) {
        boolean isSuccess = itemAdapter.remove(item);
        if (isSuccess && itemAdapter.isEmpty()) {
            pullableViewContainer.showErrorImageWithAction(imageResId, actionText, action);
        }
        return isSuccess;
    }

    @Override
    public boolean removeThenShowActionIfEmpty(T item, int imageResId, CharSequence message, String actionText, Runnable action) {
        boolean isSuccess = itemAdapter.remove(item);
        if (isSuccess && itemAdapter.isEmpty()) {
            pullableViewContainer.showErrorImageAndTextWithAction(imageResId, message, actionText, action);
        }
        return isSuccess;
    }

    @Override
    public void clearThenShowMessage(CharSequence message) {
        itemAdapter.clear();
        pullableViewContainer.showErrorText(message);
    }

    @Override
    public void clearThenShowImage(int imageResId) {
        itemAdapter.clear();
        pullableViewContainer.showErrorImage(imageResId);
    }

    @Override
    public void clearThenShowImageAndText(int imageResId, CharSequence message) {
        itemAdapter.clear();
        pullableViewContainer.showErrorImageAndText(imageResId, message);
    }

    @Override
    public void clearThenShowRefreshAction(CharSequence message) {
        itemAdapter.clear();
        pullableViewContainer.showErrorTextWithRefreshAction(message);
    }

    @Override
    public void clearThenShowRefreshAction(int imageResId) {
        itemAdapter.clear();
        pullableViewContainer.showErrorImageWithRefreshAction(imageResId);
    }

    @Override
    public void clearThenShowRefreshAction(int imageResId, CharSequence message) {
        itemAdapter.clear();
        pullableViewContainer.showErrorImageAndTextWithRefreshAction(imageResId, message);
    }

    @Override
    public void clearThenShowAction(CharSequence message, String actionText, Runnable action) {
        itemAdapter.clear();
        pullableViewContainer.showErrorTextWithAction(message, actionText, action);
    }

    @Override
    public void clearThenShowAction(int imageResId, String actionText, Runnable action) {
        itemAdapter.clear();
        pullableViewContainer.showErrorImageWithAction(imageResId, actionText, action);
    }

    @Override
    public void clearThenShowAction(int imageResId, CharSequence message, String actionText, Runnable action) {
        itemAdapter.clear();
        pullableViewContainer.showErrorImageAndTextWithAction(imageResId, message, actionText, action);
    }

    @Override
    public T getItem(int position) {
        return itemAdapter.getItem(position);
    }

    @Override
    public T getLastItem() {
        return itemAdapter.getLastItem();
    }

    @Override
    public int getItemCount() {
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
    public View setViewBeforeBody(int layoutId) {
        return View.inflate(headPanel.getContext(), layoutId, headPanel);
    }

    @Override
    public void setViewBeforeBody(View view) {
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        if (lp == null) {
            headPanel.addView(view, generateLayoutParams());
        } else {
            headPanel.addView(view, new LinearLayout.LayoutParams(lp.width, lp.height));
        }
    }

    @Override
    public View setViewAfterBody(int layoutId) {
        return View.inflate(footerPanel.getContext(), layoutId, footerPanel);
    }

    @Override
    public void setViewAfterBody(View view) {
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        if (lp == null) {
            footerPanel.addView(view, generateLayoutParams());
        } else {
            footerPanel.addView(view, new LinearLayout.LayoutParams(lp.width, lp.height));
        }
    }

    @Override
    public void setOnItemClickListener(AdapterView.OnItemClickListener listener) {
        pullableViewContainer.getPullableView().setOnItemClickListener(listener);
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
    public void finishRequestSuccessWithErrorMessageIfItemsEmpty(PullType type, List<T> items, String messageWhenItemsEmpty) {
        if (type == PullType.UP) {
            if (items == null || items.isEmpty()) {
                items = getItems();
                if (items == null || items.isEmpty()) {
                    pullableViewContainer.finishRequest(type, true, messageWhenItemsEmpty);
                } else {
                    pullableViewContainer.finishRequestSuccess(type);
                }
            } else {
                addAll(items);
                pullableViewContainer.finishRequestSuccess(type);
            }
        } else {
            if (items == null || items.isEmpty()) {
                clear();
                pullableViewContainer.finishRequest(type, true, messageWhenItemsEmpty);
            } else {
                setItems(items);
                pullableViewContainer.finishRequestSuccess(type);
            }
        }
    }

    @Override
    public void finishRequestSuccessWithErrorImageIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty) {
        if (type == PullType.UP) {
            if (items == null || items.isEmpty()) {
                items = getItems();
                if (items == null || items.isEmpty()) {
                    pullableViewContainer.finishRequest(type, true, imageResIdWhenItemsEmpty);
                } else {
                    pullableViewContainer.finishRequestSuccess(type);
                }
            } else {
                addAll(items);
                pullableViewContainer.finishRequestSuccess(type);
            }
        } else {
            if (items == null || items.isEmpty()) {
                clear();
                pullableViewContainer.finishRequest(type, true, imageResIdWhenItemsEmpty);
            } else {
                setItems(items);
                pullableViewContainer.finishRequestSuccess(type);
            }
        }
    }

    @Override
    public void finishRequestSuccessWithErrorImageAndMessageIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty, String messageWhenItemsEmpty) {
        if (type == PullType.UP) {
            if (items == null || items.isEmpty()) {
                items = getItems();
                if (items == null || items.isEmpty()) {
                    pullableViewContainer.finishRequest(type, true, imageResIdWhenItemsEmpty, messageWhenItemsEmpty);
                } else {
                    pullableViewContainer.finishRequestSuccess(type);
                }
            } else {
                addAll(items);
                pullableViewContainer.finishRequestSuccess(type);
            }
        } else {
            if (items == null || items.isEmpty()) {
                clear();
                pullableViewContainer.finishRequest(type, true, imageResIdWhenItemsEmpty, messageWhenItemsEmpty);
            } else {
                setItems(items);
                pullableViewContainer.finishRequestSuccess(type);
            }
        }
    }

    @Override
    public void finishRequestSuccessWithRefreshActionIfItemsEmpty(PullType type, List<T> items, String messageWhenItemsEmpty) {
        if (type == PullType.UP) {
            if (items == null || items.isEmpty()) {
                items = getItems();
                if (items == null || items.isEmpty()) {
                    pullableViewContainer.finishRequestWithRefreshAction(type, true, messageWhenItemsEmpty);
                } else {
                    pullableViewContainer.finishRequestSuccess(type);
                }
            } else {
                addAll(items);
                pullableViewContainer.finishRequestSuccess(type);
            }
        } else {
            if (items == null || items.isEmpty()) {
                clear();
                pullableViewContainer.finishRequestWithRefreshAction(type, true, messageWhenItemsEmpty);
            } else {
                setItems(items);
                pullableViewContainer.finishRequestSuccess(type);
            }
        }
    }

    @Override
    public void finishRequestSuccessWithRefreshActionIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty) {
        if (type == PullType.UP) {
            if (items == null || items.isEmpty()) {
                items = getItems();
                if (items == null || items.isEmpty()) {
                    pullableViewContainer.finishRequestWithRefreshAction(type, true, imageResIdWhenItemsEmpty);
                } else {
                    pullableViewContainer.finishRequestSuccess(type);
                }
            } else {
                addAll(items);
                pullableViewContainer.finishRequestSuccess(type);
            }
        } else {
            if (items == null || items.isEmpty()) {
                clear();
                pullableViewContainer.finishRequestWithRefreshAction(type, true, imageResIdWhenItemsEmpty);
            } else {
                setItems(items);
                pullableViewContainer.finishRequestSuccess(type);
            }
        }
    }

    @Override
    public void finishRequestSuccessWithRefreshActionIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty, String messageWhenItemsEmpty) {
        if (type == PullType.UP) {
            if (items == null || items.isEmpty()) {
                items = getItems();
                if (items == null || items.isEmpty()) {
                    pullableViewContainer.finishRequestWithRefreshAction(type, true, imageResIdWhenItemsEmpty, messageWhenItemsEmpty);
                } else {
                    pullableViewContainer.finishRequestSuccess(type);
                }
            } else {
                addAll(items);
                pullableViewContainer.finishRequestSuccess(type);
            }
        } else {
            if (items == null || items.isEmpty()) {
                clear();
                pullableViewContainer.finishRequestWithRefreshAction(type, true, imageResIdWhenItemsEmpty, messageWhenItemsEmpty);
            } else {
                setItems(items);
                pullableViewContainer.finishRequestSuccess(type);
            }
        }
    }

    @Override
    public void finishRequestSuccessWithActionIfItemsEmpty(PullType type, List<T> items, String messageWhenItemsEmpty, String actionText, Runnable action) {
        if (type == PullType.UP) {
            if (items == null || items.isEmpty()) {
                items = getItems();
                if (items == null || items.isEmpty()) {
                    pullableViewContainer.finishRequestWithAction(type, true, messageWhenItemsEmpty, actionText, action);
                } else {
                    pullableViewContainer.finishRequestSuccess(type);
                }
            } else {
                addAll(items);
                pullableViewContainer.finishRequestSuccess(type);
            }
        } else {
            if (items == null || items.isEmpty()) {
                clear();
                pullableViewContainer.finishRequestWithAction(type, true, messageWhenItemsEmpty, actionText, action);
            } else {
                setItems(items);
                pullableViewContainer.finishRequestSuccess(type);
            }
        }
    }

    @Override
    public void finishRequestSuccessWithActionIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty, String actionText, Runnable action) {
        if (type == PullType.UP) {
            if (items == null || items.isEmpty()) {
                items = getItems();
                if (items == null || items.isEmpty()) {
                    pullableViewContainer.finishRequestWithAction(type, true, imageResIdWhenItemsEmpty, actionText, action);
                } else {
                    pullableViewContainer.finishRequestSuccess(type);
                }
            } else {
                addAll(items);
                pullableViewContainer.finishRequestSuccess(type);
            }
        } else {
            if (items == null || items.isEmpty()) {
                clear();
                pullableViewContainer.finishRequestWithAction(type, true, imageResIdWhenItemsEmpty, actionText, action);
            } else {
                setItems(items);
                pullableViewContainer.finishRequestSuccess(type);
            }
        }
    }

    @Override
    public void finishRequestSuccessWithActionIfItemsEmpty(PullType type, List<T> items, int imageResIdWhenItemsEmpty, String messageWhenItemsEmpty, String actionText, Runnable action) {
        if (type == PullType.UP) {
            if (items == null || items.isEmpty()) {
                items = getItems();
                if (items == null || items.isEmpty()) {
                    pullableViewContainer.finishRequestWithAction(type, true, imageResIdWhenItemsEmpty, messageWhenItemsEmpty, actionText, action);
                } else {
                    pullableViewContainer.finishRequestSuccess(type);
                }
            } else {
                addAll(items);
                pullableViewContainer.finishRequestSuccess(type);
            }
        } else {
            if (items == null || items.isEmpty()) {
                clear();
                pullableViewContainer.finishRequestWithAction(type, true, imageResIdWhenItemsEmpty, messageWhenItemsEmpty, actionText, action);
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
    public void setNumColumns(int numColumns) {
        pullableViewContainer.getPullableView().setNumColumns(numColumns);
    }

    @Override
    public void refresh() {
        pullableViewContainer.refresh();
    }

    private LinearLayout.LayoutParams generateLayoutParams() {
        return new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    }
}
