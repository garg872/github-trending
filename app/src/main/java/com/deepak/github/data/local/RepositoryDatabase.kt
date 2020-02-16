package com.deepak.github.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.deepak.github.data.local.dao.DeveloperDao
import com.deepak.github.data.local.dao.RepositoryDao
import com.deepak.github.data.local.entity.DeveloperEntity
import com.deepak.github.data.local.entity.RepositoryEntity

@Database (entities = [RepositoryEntity::class,
    DeveloperEntity::class], version = 2)
abstract class RepositoryDatabase : RoomDatabase() {
    abstract fun repositoryDao() : RepositoryDao

    abstract fun developerDao() : DeveloperDao
}