package com.deepak.github.databinding

import android.databinding.BindingAdapter
import android.support.v7.widget.RecyclerView
import com.deepak.github.data.remote.Resource
import com.deepak.github.ui.base.BaseAdapter

object ListBindingAdapter {

   /* @BindingAdapter("resource")
    fun setResource(recyclerView: RecyclerView, resource: Resource<*>?) {
        val adapter = recyclerView.adapter ?: return

        if (resource == null || resource.data == null)
            return

        if (adapter is BaseAdapter) {
            adapter.setData(resource.data as List<Nothing>)
        }
    }*/
}

