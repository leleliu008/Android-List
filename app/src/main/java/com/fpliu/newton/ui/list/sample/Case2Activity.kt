package com.fpliu.newton.ui.list.sample

import android.os.Bundle
import com.fpliu.newton.ui.base.BaseActivity

/**
 *
 * @author 792793182@qq.com 2018-03-30.
 */
class Case2Activity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(XXPullableRecyclerView(this))
    }
}