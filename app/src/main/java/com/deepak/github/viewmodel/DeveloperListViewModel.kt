package com.deepak.github.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.deepak.github.data.local.entity.DeveloperEntity
import com.deepak.github.data.remote.Resource
import com.deepak.github.data.remote.repository.DevelopersRepository
import javax.inject.Inject

class DeveloperListViewModel @Inject
constructor(developersRepository: DevelopersRepository) : ViewModel() {

    val tendingDeveloperList : LiveData<Resource<List<DeveloperEntity>>>

    init {
        tendingDeveloperList = developersRepository.fetchDevelopers()
    }

    fun getTendingDevelopers() : LiveData<Resource<List<DeveloperEntity>>>?  {
        return tendingDeveloperList
    }
}