package com.deepak.github.ui.callbacks


import com.deepak.github.data.local.entity.RepositoryEntity

interface ResponseListener {

    fun onSuccess(data: RepositoryEntity)
    fun onFailure(message: String)
}
