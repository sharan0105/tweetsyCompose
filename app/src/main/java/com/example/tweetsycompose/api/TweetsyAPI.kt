package com.example.tweetsycompose.api

import com.example.tweetsycompose.models.CategoryList
import com.example.tweetsycompose.models.TweetsListItem
import retrofit2.http.GET
import retrofit2.http.Header

interface TweetsyAPI {
    @GET("v3/b/67f10a018a456b796682e387?meta=false")
    suspend fun getTweets(@Header("X-JSON-Path") category: String): List<TweetsListItem>

    @GET("v3/b/67f1b83b8561e97a50f96806?meta=false")
    suspend fun getCategories(): CategoryList
}