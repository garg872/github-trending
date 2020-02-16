package com.deepak.github.utils

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v4.app.ActivityCompat
import android.support.v4.app.ActivityOptionsCompat

import com.deepak.github.data.local.entity.RepositoryEntity
import com.deepak.github.ui.activity.RepositoryDetailActivity


object NavigatorUtils {

    fun redirectToDetailScreen(activity: Activity?,
                               repositoryEntity: RepositoryEntity,
                               options: ActivityOptionsCompat?) {

        activity?.let {
            var intent = Intent(activity, RepositoryDetailActivity::class.java)
            intent.putExtra(AppConstants.INTENT_POST, repositoryEntity)
            ActivityCompat.startActivity(activity, intent, options?.toBundle())
        }

    }

    fun openBrowser(activity: Activity,
                    url: String) {
        val i = Intent(Intent.ACTION_VIEW)
        i.data = Uri.parse(url)
        activity.startActivity(i)
    }
}
