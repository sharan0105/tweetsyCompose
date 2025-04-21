package com.example.tweetsycompose.viewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsycompose.models.TweetsListItem
import com.example.tweetsycompose.repo.TweetsRepo
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class DetailViewModel @Inject constructor(
    private val repo: TweetsRepo
): ViewModel(){
    init {
//        TODO: See how we can use savedStateHandle inside dagger2 injected VM to directly access the values passed to the screen
//        viewModelScope.launch {
//            //TODO: Fix this up, category shouldn't be hardcoded
//            val category = savedStateHandle.get<String>("category") ?: "motivation"
//            repo.getTweets(category)
//        }
    }

    //Unable to use savedStateHandle with dagger2 injected VM for now, so exposing a function which takes the required category.
    fun getTweets(category: String){
        viewModelScope.launch {
            repo.getTweets(category)
        }
    }

    val tweets: StateFlow<List<TweetsListItem>>
        get() = repo.tweets
}