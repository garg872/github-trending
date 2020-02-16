package com.deepak.github.di.module

import android.app.Application
import android.arch.persistence.room.Room
import com.deepak.github.data.local.RepositoryDatabase
import com.deepak.github.data.local.dao.DeveloperDao
import com.deepak.github.data.local.dao.RepositoryDao

import com.deepak.github.data.remote.ApiConstants
import com.deepak.github.data.remote.GithubApiService

import java.util.concurrent.TimeUnit

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


@Module(includes = [ViewModelModule::class])
class AppModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.connectTimeout(ApiConstants.CONNECT_TIMEOUT, TimeUnit.MILLISECONDS)
        okHttpClient.readTimeout(ApiConstants.READ_TIMEOUT, TimeUnit.MILLISECONDS)
        okHttpClient.writeTimeout(ApiConstants.WRITE_TIMEOUT, TimeUnit.MILLISECONDS)
        okHttpClient.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        return okHttpClient.build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): GithubApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiConstants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()

        return retrofit.create(GithubApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideGithubDatabase(application: Application) =
         Room.databaseBuilder(application, RepositoryDatabase::class.java, "github.db").build()


    @Provides
    @Singleton
    fun provideRepositoryDao(repositoryDatabase : RepositoryDatabase): RepositoryDao{
        return repositoryDatabase.repositoryDao()
    }

    @Provides
    @Singleton
    fun provideDeveloperDao(repositoryDatabase : RepositoryDatabase): DeveloperDao{
        return repositoryDatabase.developerDao()
    }
}
