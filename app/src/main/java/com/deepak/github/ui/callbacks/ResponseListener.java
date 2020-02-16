package com.deepak.github.ui.callbacks;


import com.deepak.github.data.local.entity.RepositoryEntity;

public interface ResponseListener {

    void onSuccess(RepositoryEntity data);
    void onFailure(String message);
}
