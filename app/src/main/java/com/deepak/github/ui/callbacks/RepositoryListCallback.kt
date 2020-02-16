package com.deepak.github.ui.callbacks

import com.deepak.github.data.local.entity.RepositoryEntity


interface RepositoryListCallback {
    fun onRepositoryClicked(repositoryEntity: RepositoryEntity?)
}

