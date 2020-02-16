package com.deepak.github.ui.activity

import com.deepak.github.databinding.ActivityMainBinding
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.widget.Toolbar
import com.deepak.github.R
import com.deepak.github.ui.base.BaseActivity
import com.deepak.github.ui.main.SectionsPagerAdapter
import dagger.android.AndroidInjection

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutRes: Int
        get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        val toolBar : Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolBar)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

    }
}