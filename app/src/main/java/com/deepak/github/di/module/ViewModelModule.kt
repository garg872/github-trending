package com.deepak.github.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.deepak.github.viewmodel.DeveloperListViewModel
import com.deepak.github.viewmodel.RepositoryListViewModel

import com.deepak.github.viewmodel.ViewModelFactory

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(RepositoryListViewModel::class)
    abstract fun bindsRepositoryListViewModel(repositoryListViewModel: RepositoryListViewModel): ViewModel


    @Binds
    @IntoMap
    @ViewModelKey(DeveloperListViewModel::class)
    abstract fun bindsDeveloperListViewModel(developerListViewModel: DeveloperListViewModel): ViewModel

}
