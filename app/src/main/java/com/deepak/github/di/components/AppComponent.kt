package com.deepak.github.di.components

import android.app.Application

import com.deepak.github.GithubApplication
import com.deepak.github.di.builder.ActivityBuilderModule

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule


@Singleton
@Component(modules = [GithubApplication::class,
    AndroidSupportInjectionModule::class,
    ActivityBuilderModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(githubApplication: GithubApplication)
}