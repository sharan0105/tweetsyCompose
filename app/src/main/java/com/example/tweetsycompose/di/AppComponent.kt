package com.example.tweetsycompose.di

import com.example.tweetsycompose.MainActivity
import dagger.Component

@Component(modules = [VMModule::class, RetrofitModule::class, VMFactoryModule::class])
interface AppComponent {
    fun injectMainActivity(activity: MainActivity)
}