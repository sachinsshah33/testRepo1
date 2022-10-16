package com.example.myapplication.viewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel

open class BaseAndroidViewModel(
    application: Application
) : AndroidViewModel(application) {
    protected val context get() = getApplication<Application>()
}