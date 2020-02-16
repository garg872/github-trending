package com.deepak.github.databinding

import android.databinding.BindingAdapter
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.GradientDrawable
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.deepak.github.R
import com.deepak.github.data.remote.Resource
import com.deepak.github.ui.base.BaseAdapter

object BaseBindingAdapter {
/*
   @BindingAdapter("resource")
    fun setResource(recyclerView: RecyclerView, resource: Resource<*>?) {
        val adapter = recyclerView.adapter ?: return

        if (resource == null || resource.data == null)
            return

        if (adapter is BaseAdapter) {
            adapter.setData(resource.data as List<Nothing>)
        }
    }*/

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun setImageUrl(imageView: ImageView, url: String?) {
        Glide.with(imageView.context).load(url).into(imageView)
    }

    @JvmStatic
    @BindingAdapter("app:roundBackgroundColor")
    fun bindTextColor(view: AppCompatImageView, color: String?) {
        color?.let {
            val drawable =
                view.context.getResources().getDrawable(R.drawable.ic_circle) as GradientDrawable
            drawable.setColor(Color.parseColor(color))
            view.setImageDrawable(drawable)
        }
    }


}

