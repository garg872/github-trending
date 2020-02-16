package com.deepak.github.data.remote.repository

import android.arch.lifecycle.LiveData
import com.deepak.github.data.local.dao.RepositoryDao
import com.deepak.github.data.local.entity.RepositoryEntity
import com.deepak.github.data.remote.GithubApiService
import com.deepak.github.data.remote.NetworkBoundResource
import com.deepak.github.data.remote.Resource


import javax.inject.Inject

import retrofit2.Call


class RepositoriesRepository @Inject
constructor(val repositoryDao: RepositoryDao, val apiService: GithubApiService) {

    fun fetchRepositories(): LiveData<Resource<List<RepositoryEntity>>> {
        return object : NetworkBoundResource<List<RepositoryEntity>, List<RepositoryEntity>>() {

            override fun saveCallResult(list: List<RepositoryEntity>?) {
                if (null != list)
                    repositoryDao.saveRepositories(list)
            }

            override fun loadFromDb(): LiveData<List<RepositoryEntity>> {
                return repositoryDao.loadTrendingRepositories()
            }

            override fun createCall(): Call<List<RepositoryEntity>> {
                return apiService.fetchRepositories()
            }
        }.asLiveData
    }



}
