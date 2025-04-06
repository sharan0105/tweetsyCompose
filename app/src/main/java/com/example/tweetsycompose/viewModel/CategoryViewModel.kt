package com.example.tweetsycompose.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tweetsycompose.repo.TweetsRepo
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class CategoryViewModel @Inject constructor(
    private val repo: TweetsRepo
): ViewModel(){

    init {
        viewModelScope.launch {
            repo.getCategories()
        }
    }

    val categories: StateFlow<List<String>>
        get() = repo.categories
}