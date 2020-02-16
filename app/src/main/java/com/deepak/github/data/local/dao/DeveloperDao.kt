package com.deepak.github.data.local.dao

import android.arch.lifecycle.LiveData

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.deepak.github.data.local.entity.DeveloperEntity
import com.deepak.github.data.local.entity.RepositoryEntity

@Dao
interface DeveloperDao {

    @Query("SELECT * FROM developers")
    fun loadTrendingDevelopers(): LiveData<List<DeveloperEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveDevelopers(devEntities: List<DeveloperEntity>)
}