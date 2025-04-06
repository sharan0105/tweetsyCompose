package com.example.tweetsycompose.di

import com.example.tweetsycompose.api.TweetsyAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RetrofitModule {

    @Provides
    fun provideRetrofitInstance(): Retrofit =
        Retrofit
            .Builder()
            .baseUrl("https://api.jsonbin.io")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    fun getTweetsyAPI(retrofit: Retrofit): TweetsyAPI{
        return retrofit.create(TweetsyAPI::class.java)
    }
}