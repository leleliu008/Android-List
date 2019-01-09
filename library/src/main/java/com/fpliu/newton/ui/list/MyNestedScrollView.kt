package com.fpliu.newton.ui.list

import android.content.Context
import android.util.AttributeSet
import androidx.core.widget.NestedScrollView

class MyNestedScrollView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0
) : NestedScrollView(context, attributeSet, defStyleAttr) {

    var onScrollChangeListener: OnScrollChangeListener? = null

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        super.onScrollChanged(l, t, oldl, oldt)
        onScrollChangeListener?.onScrollChanged(l, t, oldl, oldt)
    }

    interface OnScrollChangeListener {
        fun onScrollChanged(scrollX: Int, scrollY: Int, oldScrollX: Int, oldScrollY: Int)
    }
}