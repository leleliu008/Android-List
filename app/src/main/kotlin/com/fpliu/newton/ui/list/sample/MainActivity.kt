package com.fpliu.newton.ui.list.sample

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import com.fpliu.newton.log.Logger
import com.fpliu.newton.ui.list.RecyclerViewActivity
import com.fpliu.newton.ui.recyclerview.holder.ItemViewHolder
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 *
 * @author 792793182@qq.com 2018-03-30.
 */
class MainActivity : RecyclerViewActivity<String>() {

    companion object {
        private val TAG = Case1Activity::class.java.simpleName
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = "List使用示例"
        Observable
            .just("")
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .map {
                ArrayList<String>().apply {
                    repeat(10, {
                        add(it.toString())
                    })
                }
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                items = it
            }, { Logger.e(TAG, "", it) })
    }

    override fun onBindLayout(parent: ViewGroup?, viewType: Int): Int {
        return R.layout.item
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int, item: String) {
        holder.run {
            id(R.id.imageView).image("https://modao.cc/uploads/avatars/33224/profile_user-avatar.png", R.drawable.default_img)
        }
    }

    override fun onItemClick(holder: ItemViewHolder, position: Int, item: String?) {
        super.onItemClick(holder, position, item)
        when (position) {
            0 -> Case1Activity::class.java
            1 -> Case2Activity::class.java
            else -> Case2Activity::class.java
        }.let { startActivity(Intent(this, it)) }
    }

}