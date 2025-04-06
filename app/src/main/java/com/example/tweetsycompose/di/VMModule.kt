package com.example.tweetsycompose.di

import androidx.lifecycle.ViewModel
import com.example.tweetsycompose.viewModel.CategoryViewModel
import com.example.tweetsycompose.viewModel.DetailViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
abstract class VMModule {
    @Binds
    @ClassKey(CategoryViewModel::class)
    @IntoMap
    abstract fun bindsCategoryViewModel(categoryViewModel: CategoryViewModel): ViewModel

    @Binds
    @ClassKey(DetailViewModel::class)
    @IntoMap
    abstract fun bindsDetailViewModel(detailViewModel: DetailViewModel): ViewModel
}