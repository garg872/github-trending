package com.deepak.github.util;

import android.os.Parcel;

import com.deepak.github.data.local.entity.RepositoryEntity;

import java.util.ArrayList;
import java.util.List;

public class MockTestUtil {

    public static List<RepositoryEntity> mockRepositories() {
        List<RepositoryEntity> repositories = new ArrayList<>();

        RepositoryEntity repository1 = new RepositoryEntity();
        repository1.setAuthor("tailscale");
        repository1.setName("test1");
        repository1.setLanguage("Java");
        repository1.setStars(121);
        repositories.add(repository1);

        RepositoryEntity repository2 = new RepositoryEntity();
        repository2.setAuthor("CSSEGISandData");
        repository2.setName("test2");
        repository2.setLanguage("Kotlin");
        repository2.setStars(122);
        repositories.add(repository2);

        RepositoryEntity repository3 = new RepositoryEntity();
        repository3.setAuthor("ton-blockchain");
        repository3.setName("test3");
        repository3.setLanguage("Python");
        repository3.setStars(123);
        repositories.add(repository3);

        return repositories;
    }
}
