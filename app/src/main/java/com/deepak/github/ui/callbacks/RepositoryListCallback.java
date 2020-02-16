package com.deepak.github.ui.callbacks;

import com.deepak.github.data.local.entity.RepositoryEntity;


public interface RepositoryListCallback {
    void onRepositoryClicked(RepositoryEntity repositoryEntity);
}

