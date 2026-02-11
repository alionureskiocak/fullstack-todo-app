package com.example.taskflow.android.data.di

import com.example.taskflow.android.data.remote.TodoAPI
import com.example.taskflow.android.data.repository.TodoRepositoryImpl
import com.example.taskflow.android.domain.repository.TodoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTodoApi() : TodoAPI{
        return Retrofit.Builder()
            .baseUrl("http://192.168.1.12:8080")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TodoAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideTodoRepository(api : TodoAPI) : TodoRepository{
        return TodoRepositoryImpl(api)
    }
}