package com.deepak.github.db;

import android.support.test.runner.AndroidJUnit4;

import com.deepak.github.data.local.entity.RepositoryEntity;
import com.deepak.github.util.MockTestUtil;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(AndroidJUnit4.class)
public class GithubDbTest extends DbTest {

    @Test
    public void insertAndReadReposTest() {
        List<RepositoryEntity> repositories = MockTestUtil.mockRepositories();
        db.repositoryDao().saveRepositories(repositories);

        List<RepositoryEntity> storedRepos = db.repositoryDao().loadTrendingRepositories().getValue();
        Assert.assertEquals("tailscale", storedRepos.get(0).getAuthor());
        Assert.assertEquals("CSSEGISandData", storedRepos.get(1).getAuthor());
        Assert.assertEquals("ton-blockchain", storedRepos.get(2).getAuthor());

    }

}
