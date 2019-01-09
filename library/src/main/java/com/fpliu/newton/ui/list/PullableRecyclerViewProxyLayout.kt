package com.fpliu.newton.ui.list

import android.content.Context
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.recyclerview.widget.RecyclerView
import com.fpliu.newton.ui.pullable.RefreshOrLoadMoreCallback
import com.fpliu.newton.ui.recyclerview.OnItemClickListener
import com.fpliu.newton.ui.recyclerview.adapter.ItemAdapter
import com.fpliu.newton.ui.recyclerview.holder.ItemViewHolder

/**
 *
 * @author 792793182@qq.com 2018-03-30.
 */
abstract class PullableRecyclerViewProxyLayout<T>(context: Context, pullableRecyclerView: IPullableRecyclerView<T>) : RelativeLayout(context),
    OnItemClickListener<T>,
    RefreshOrLoadMoreCallback<RecyclerView>,
    IPullableRecyclerView<T> by pullableRecyclerView {

    init {
        addView(pullableRecyclerView.init(context), RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT))
        itemAdapter = object : ItemAdapter<T>(null) {

            override fun onBindLayout(parent: ViewGroup, viewType: Int): Int {
                return this@PullableRecyclerViewProxyLayout.onBindLayout(parent, viewType)
            }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
                val itemViewHolder = super.onCreateViewHolder(parent, viewType)
                this@PullableRecyclerViewProxyLayout.onCreateViewHolder(itemViewHolder, parent, viewType)
                return itemViewHolder
            }

            override fun onBindViewHolder(holder: ItemViewHolder, position: Int, item: T) {
                this@PullableRecyclerViewProxyLayout.onBindViewHolder(holder, position, item)
            }

            override fun getItemViewType(position: Int): Int {
                return this@PullableRecyclerViewProxyLayout.getItemViewType(position)
            }
        }
        setOnItemClickListener(this)
        setRefreshOrLoadMoreCallback(this)
    }

    override fun onCreateViewHolder(holder: ItemViewHolder, parent: ViewGroup, viewType: Int) {

    }

    override fun onItemClick(holder: ItemViewHolder, position: Int, item: T?) {

    }
}