package com.example.tweetsycompose.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsycompose.models.TweetsListItem
import com.example.tweetsycompose.repo.TweetsRepo
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val repo: TweetsRepo
): ViewModel(){
    init {
        viewModelScope.launch {
            //TODO: Fix this up, category shouldn't be hardcoded
            repo.getTweets("motivation")
        }
    }

    val tweets: StateFlow<List<TweetsListItem>>
        get() = repo.tweets
}