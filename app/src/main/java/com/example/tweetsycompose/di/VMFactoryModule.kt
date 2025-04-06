package com.example.tweetsycompose.di

import androidx.lifecycle.ViewModelProvider
import com.example.tweetsycompose.viewModelFactory.GlobalVMFactory
import dagger.Binds
import dagger.Module

@Module
abstract class VMFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(globalVMFactory: GlobalVMFactory): ViewModelProvider.Factory
}