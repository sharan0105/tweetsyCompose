package com.example.tweetsycompose.repo

import com.example.tweetsycompose.api.TweetsyAPI
import com.example.tweetsycompose.models.TweetsListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

class TweetsRepo @Inject constructor(
    private val api: TweetsyAPI
){
    private val _categories = MutableStateFlow<List<String>>(emptyList())
    val categories: StateFlow<List<String>>
    get() = _categories

    private val _tweets = MutableStateFlow<List<TweetsListItem>>(emptyList())
    val tweets : StateFlow<List<TweetsListItem>>
        get() = _tweets


    suspend fun getCategories(){
        val tweetsCategories = api.getCategories()
        if(tweetsCategories.categories.isNotEmpty()){
            _categories.update {
                tweetsCategories.categories
            }
        }
    }

    suspend fun getTweets(category: String){
        val tweetsRes= api.getTweets("tweets[?(@.category==\"$category\")]")
        if(tweetsRes.isNotEmpty()){
            _tweets.update {
                tweetsRes
            }
        }
    }
}
