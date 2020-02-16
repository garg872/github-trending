package com.deepak.github.db;

import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import com.deepak.github.data.local.RepositoryDatabase;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public abstract class DbTest {

    protected RepositoryDatabase db;

    @Before
    public void initDb() {
        db = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(),
                RepositoryDatabase.class).build();
    }

    @After
    public void closeDb() {
        db.close();
    }
}