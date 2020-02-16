package com.deepak.github.ui.callbacks

import com.deepak.github.data.local.entity.DeveloperEntity
import com.deepak.github.data.local.entity.RepositoryEntity


interface DeveloperListCallback {
    fun onDeveloperClicked(developerEntity: DeveloperEntity?)
}

