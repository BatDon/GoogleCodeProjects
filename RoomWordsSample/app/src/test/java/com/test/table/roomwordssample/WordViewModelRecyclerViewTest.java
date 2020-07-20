package com.test.table.roomwordssample;

import android.app.Application;
import android.content.Context;
import android.os.Build;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;


import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


@RunWith(AndroidJUnit4.class)
@Config(sdk = {Build.VERSION_CODES.O_MR1})
public class WordViewModelRecyclerViewTest {

    Context context;

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Test
    public void updatesRecyclerView(){
        context= InstrumentationRegistry.getInstrumentation().getContext();
        WordViewModel wordViewModel=new WordViewModel((Application)context);
        LiveData<List<Word>> liveWordList = wordViewModel.getAllWords();
        liveWordList.removeObserver(observer);
        assertThat(liveWordList, is(equalTo(null)));

    }


}
