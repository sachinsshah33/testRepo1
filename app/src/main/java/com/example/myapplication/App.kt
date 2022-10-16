package com.example.myapplication


import android.app.Application
import android.content.Context
import androidx.lifecycle.LifecycleObserver
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application(), LifecycleObserver {

    /**
     * NOTES
     *
     * If I had more time:
     * I'd learn how to use the mockwebserver and set that up to mock network calls
     * Then be able to test the ViewModel related code more better
     * Learn how to use MockK better
     *
     * Add some loading/spinner stuff for when the Refresh button is tapped, maybe also add Throttle to the button so it cant be spammed or wait till there is a network response to enable button again
     *
     * Basic caching, either via Room or SharedPrefs/DataStore
     *
     * Match the UI to the screenshots/video
     * Spend some time to figure out why the XML wasnt working with Compose, or play around with Compose more to perfect UI
     *
     * Refactor project more so the compose view are taken out of the MainActivity.kt file
     * Remove unnecessary code like this AppContext below
     *
     */

    companion object {
        lateinit var AppContext: Context
    }

    override fun onCreate() {
        super.onCreate()
        AppContext = this
    }
}
