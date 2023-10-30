package com.tc.domain.model.di

import android.content.Context
import androidx.room.Room
import com.tc.domain.model.local.AppDatabase
import com.tc.domain.model.local.PeopleDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Provides
    @Singleton
    fun providePeopleDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "people_database.db"
        ).build()
    }

    @Provides
    fun providePersonDao(database: AppDatabase): PeopleDao {
        return database.peopleDao()
    }
}