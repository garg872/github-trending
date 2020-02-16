package com.deepak.github.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.deepak.github.data.local.dao.RepositoryDao
import com.deepak.github.data.local.entity.RepositoryEntity

@Database (entities = [RepositoryEntity::class], version = 1)
abstract class RepositoryDatabase : RoomDatabase() {
    abstract fun repositoryDao() : RepositoryDao
}