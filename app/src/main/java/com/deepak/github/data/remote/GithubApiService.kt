package com.deepak.github.data.remote

import com.deepak.github.data.local.entity.RepositoryEntity

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApiService {

    @GET("repositories")
    fun fetchRepositories(): Call<List<RepositoryEntity>>
}
