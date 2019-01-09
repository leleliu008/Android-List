package com.fpliu.newton.ui.list.sample

import android.os.Bundle
import android.widget.LinearLayout
import com.fpliu.newton.log.Logger
import com.fpliu.newton.ui.list.MyNestedScrollView
import com.fpliu.newton.ui.list.PullableScrollViewActivity
import com.fpliu.newton.ui.pullable.PullType
import com.fpliu.newton.ui.pullable.PullableViewContainer

class PullableScrollViewActivityExample : PullableScrollViewActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addViewInScrollView<LinearLayout>(R.layout.pullable_scroll_view_activity_example)
        pullableViewContainer.pullableView.onScrollChangeListener = object : MyNestedScrollView.OnScrollChangeListener {
            override fun onScrollChanged(scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int) {
                Logger.i("XX", "onScrollChanged() scrollX = $scrollX, scrollY = $scrollY")
            }
        }
        pullableViewContainer.setDefaultLayout()
    }

    override fun onRefreshOrLoadMore(pullableViewContainer: PullableViewContainer<MyNestedScrollView>, type: PullType, pageNum: Int, pageSize: Int) {
        pullableViewContainer.finishRequestSuccess(type)
    }
}