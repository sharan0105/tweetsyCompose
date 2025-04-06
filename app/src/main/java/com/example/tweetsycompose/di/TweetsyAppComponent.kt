package com.example.tweetsycompose.di

import com.example.tweetsycompose.MainActivity
import dagger.Component

@Component(modules = [VMModule::class, RetrofitModule::class, VMFactoryModule::class])
interface TweetsyAppComponent {
    fun injectMainActivity(activity: MainActivity)
}