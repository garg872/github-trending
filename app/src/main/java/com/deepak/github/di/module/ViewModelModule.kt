package com.deepak.github.di.module

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

import com.deepak.github.viewmodel.ViewModelFactory

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(ArticleListViewModel.class)
    //    @SuppressWarnings("unused")
    //    abstract ViewModel bindsArticleListViewModel(ArticleListViewModel articleListViewModel);
    //
    //    @Binds
    //    @IntoMap
    //    @ViewModelKey(ArticleDetailsViewModel.class)
    //    @SuppressWarnings("unused")
    //    abstract ViewModel bindsArticleDetailsiewModel(ArticleDetailsViewModel articleDetailsViewModel);


    @Binds
    abstract fun bindsViewModelFactory(viewModelFactory: ViewModelFactory): ViewModelProvider.Factory
}
