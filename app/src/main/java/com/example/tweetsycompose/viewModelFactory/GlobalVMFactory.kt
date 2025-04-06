package com.example.tweetsycompose.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class GlobalVMFactory @Inject constructor(
    private val vmBindingMap: Map<Class<out ViewModel>, @JvmSuppressWildcards ViewModel>
): ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return vmBindingMap[modelClass] as T
    }
}