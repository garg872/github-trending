package com.deepak.github.data.remote.repository

import android.arch.lifecycle.LiveData
import com.deepak.github.data.local.dao.DeveloperDao
import com.deepak.github.data.local.dao.RepositoryDao
import com.deepak.github.data.local.entity.DeveloperEntity
import com.deepak.github.data.local.entity.RepositoryEntity
import com.deepak.github.data.remote.GithubApiService
import com.deepak.github.data.remote.NetworkBoundResource
import com.deepak.github.data.remote.Resource


import javax.inject.Inject

import retrofit2.Call


class DevelopersRepository @Inject
constructor(val developerDao: DeveloperDao, val apiService: GithubApiService) {

    fun fetchDevelopers(): LiveData<Resource<List<DeveloperEntity>>> {
        return object : NetworkBoundResource<List<DeveloperEntity>, List<DeveloperEntity>>() {

            override fun saveCallResult(list: List<DeveloperEntity>?) {
                if (null != list)
                    developerDao.saveDevelopers(list)
            }

            override fun loadFromDb(): LiveData<List<DeveloperEntity>> {
                return developerDao.loadTrendingDevelopers()
            }

            override fun createCall(): Call<List<DeveloperEntity>> {
                return apiService.fetchDevelopers()
            }
        }.asLiveData
    }



}
