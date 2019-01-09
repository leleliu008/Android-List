package com.fpliu.newton.ui.list.sample

import android.content.Context
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fpliu.newton.log.Logger
import com.fpliu.newton.ui.list.PullableRecyclerViewImpl
import com.fpliu.newton.ui.list.PullableRecyclerViewProxyLayout
import com.fpliu.newton.ui.pullable.PullType
import com.fpliu.newton.ui.pullable.PullableViewContainer
import com.fpliu.newton.ui.recyclerview.holder.ItemViewHolder
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *
 * @author 792793182@qq.com 2018-03-30.
 */
class XXPullableRecyclerView : PullableRecyclerViewProxyLayout<Pair<Int, String>> {

    companion object {
        private val TAG = XXPullableRecyclerView::class.java.simpleName
    }

    constructor(context: Context) : super(context, PullableRecyclerViewImpl())

    override fun onRefreshOrLoadMore(pullableViewContainer: PullableViewContainer<RecyclerView>?, pullType: PullType, pageNum: Int, pageSize: Int) {
        Logger.i(TAG, "onRefreshOrLoadMore()")
        Observable
            .just("")
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .map {
                ArrayList<Pair<Int, String>>().apply {
                    repeat(10) {
                        add(Pair(it, it.toString()))
                    }
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                finishRequestSuccessWithErrorImageAndMessageIfItemsEmpty(pullType, it, R.drawable.ic_warnning, "暂无数据")
            }, { Logger.e(TAG, "", it) })
    }

    override fun onBindLayout(parent: ViewGroup?, viewType: Int): Int {
        Logger.i(TAG, "onBindLayout()")
        return R.layout.item
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int, item: Pair<Int, String>) {
        Logger.i(TAG, "onBindViewHolder()")
        holder.run {
            id(R.id.imageView).image("https://modao.cc/uploads/avatars/33224/profile_user-avatar.png", R.drawable.default_img)
            id(R.id.textView).text(item.second)
        }
    }
}