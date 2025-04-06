package com.example.tweetsycompose.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.tweetsycompose.viewModel.CategoryViewModel
import com.example.tweetsycompose.viewModel.DetailViewModel
import com.example.tweetsycompose.viewModelFactory.GlobalVMFactory
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
 class VMModule {

    @Provides
    @ClassKey(CategoryViewModel::class)
    @IntoMap
    fun bindsCategoryViewModel(categoryViewModel: CategoryViewModel): ViewModel = categoryViewModel

    @Provides
    @ClassKey(DetailViewModel::class)
    @IntoMap
    fun bindsDetailViewModel(detailViewModel: DetailViewModel): ViewModel = detailViewModel
}