package com.tc.domain.model.di

import com.google.gson.Gson
import com.tc.data.model.remote.ApiDetails
import com.tc.data.model.remote.PeopleService
import com.tc.data.model.local.PeopleDao
import com.tc.data.model.repository.PeopleRepository
import com.tc.data.model.repository.PeopleRepositoryImpl
import com.tc.data.util.CacheMapper
import com.tc.domain.usecase.FetchAllPeopleUseCase
import com.tc.domain.usecase.FetchAllPeopleUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideGson(): Gson {
        return Gson()
    }

    @Singleton
    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            )
            .addInterceptor { chain ->
                val request = chain.request()
                    .newBuilder()
                    .build()
                chain.proceed(request)
            }
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofitGet(
        gson: Gson,
        httpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiDetails.BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Singleton
    @Provides
    fun provideApiClient(
        retrofit: Retrofit
    ): PeopleService {
        return retrofit.create(PeopleService::class.java)
    }

    @Singleton
    @Provides
    fun provideRepository(
        service: PeopleService,
        peopleDao: PeopleDao,
        cacheMapper: CacheMapper
    ): PeopleRepository {
        return PeopleRepositoryImpl(service, peopleDao, cacheMapper)
    }

    @Singleton
    @Provides
    fun provideUseCase(
        peopleRepository: PeopleRepository
    ): FetchAllPeopleUseCase {
        return FetchAllPeopleUseCaseImpl(peopleRepository)
    }
}