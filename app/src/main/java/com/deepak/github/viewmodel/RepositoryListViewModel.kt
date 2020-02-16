package com.deepak.github.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.deepak.github.data.local.entity.RepositoryEntity
import com.deepak.github.data.remote.Resource
import com.deepak.github.data.remote.repository.RepositoriesRepository
import javax.inject.Inject

class RepositoryListViewModel : ViewModel() {

    var tendingRepositoryList : LiveData<Resource<List<RepositoryEntity>>>? = null


    @Inject
    fun RepositoryListViewModel(repositoriesRepository: RepositoriesRepository) {
        tendingRepositoryList = repositoriesRepository.fetchRepositories()
    }

    fun getTendingRepositories() : LiveData<Resource<List<RepositoryEntity>>>?  {
        return tendingRepositoryList;
    }
}