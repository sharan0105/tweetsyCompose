package com.example.tweetsycompose

import android.app.Application
import com.example.tweetsycompose.di.DaggerAppComponent

class TweetsyApplication: Application() {
    val appComponent = DaggerAppComponent.builder().build()
}