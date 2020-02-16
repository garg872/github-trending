package com.deepak.github

import android.app.Activity
import android.app.Application
import android.content.Context
import com.deepak.github.di.components.DaggerAppComponent
import dagger.Module
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

@Module
class GithubApplication : Application(), HasActivityInjector {

    init {
        sInstance = this
    }
    companion object {
        private var sInstance: GithubApplication? = null

        fun applicationContext() : Context {
            return sInstance!!.applicationContext
        }
    }


    fun getAppContext(): GithubApplication? {
        return sInstance
    }


    @Synchronized
    private fun setInstance(app: GithubApplication) {
        sInstance = app
    }

    @Inject
    lateinit var activityDispatchingInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        initializeComponent()
        setInstance(this)
    }

    private fun initializeComponent() {
        DaggerAppComponent.builder()
            .application(this@GithubApplication)
            .build()
            .inject(this)
    }


    override fun activityInjector(): AndroidInjector<Activity>? {
        return activityDispatchingInjector
    }
}