package com.example.tweetsycompose

import android.app.Application
import com.example.tweetsycompose.di.DaggerTweetsyAppComponent

class TweetsyApplication: Application() {
    val appComponent = DaggerTweetsyAppComponent
        .builder()
        .build()
}