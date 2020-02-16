package com.deepak.github.ui.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

import com.deepak.github.R
import com.deepak.github.data.local.entity.RepositoryEntity
import com.deepak.github.databinding.RepositoryDetailActivityBinding
import com.deepak.github.utils.AppConstants
import com.deepak.github.utils.NavigatorUtils
import com.deepak.github.utils.ShareUtils

class RepositoryDetailActivity : AppCompatActivity() {

    private lateinit var repositoryEntity: RepositoryEntity
    private lateinit var binding: RepositoryDetailActivityBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initialiseView()
    }

    private fun initialiseView() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_repository_detail)
        repositoryEntity = intent.getParcelableExtra(AppConstants.INTENT_POST)

        binding.repository = repositoryEntity

        binding.itemTitle.setText(repositoryEntity.name)
        binding.itemLanguage.setText(repositoryEntity.language)
        binding.itemStars.setText(repositoryEntity.stars.toString())
        binding.itemForks.setText(repositoryEntity.forks.toString())
        binding.itemWatchers.setText(repositoryEntity.currentPeriodStars.toString())


        binding.btnShare.setOnClickListener { ShareUtils.shareUrl(this@RepositoryDetailActivity, repositoryEntity.url) }
        binding.btnVisit.setOnClickListener { NavigatorUtils.openBrowser(this@RepositoryDetailActivity, repositoryEntity.url) }
    }
}
