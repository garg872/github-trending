package com.deepak.github.di.builder


import com.deepak.github.ui.fragment.RepositoryListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun contributeRepositoryListFragment(): RepositoryListFragment
//
//    @SuppressWarnings("unused")
//    @ContributesAndroidInjector
//    abstract ArticleDetailFragment contributeArticleDetailFragment();
}