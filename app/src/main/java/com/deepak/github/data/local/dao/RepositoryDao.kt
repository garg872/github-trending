package com.deepak.github.data.local.dao

import android.arch.lifecycle.LiveData

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.deepak.github.data.local.entity.RepositoryEntity

interface RepositoryDao {

    @Query("SELECT * FROM repositories")
    fun loadTrendingRepositories(): LiveData<List<RepositoryEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveRepositories(repoEntities: List<RepositoryEntity>)
}