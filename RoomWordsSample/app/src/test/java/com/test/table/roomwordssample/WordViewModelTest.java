package com.test.table.roomwordssample;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.arch.core.executor.testing.InstantTaskExecutorRule;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import static org.hamcrest.Matchers.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

//@Config(sdk = {Build.VERSION_CODES.ICE_CREAM_SANDWICH})
@RunWith(AndroidJUnit4.class)
@Config(sdk = {Build.VERSION_CODES.O_MR1})
public class WordViewModelTest {

    Context context;
    Context instrumentationContext;
    Word testWord;

    @Before
    public void init(){
        context=ApplicationProvider.getApplicationContext();
        instrumentationContext = InstrumentationRegistry.getInstrumentation().getContext();
        testWord = new Word("test");
    }

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule = new InstantTaskExecutorRule();

    @Test
    public void emptyList_beforeInitialized() {
        // Given a fresh ViewModel

        WordViewModel wordViewModel = new WordViewModel((Application) context);
//        //Mock the word instance


        LiveData<List<Word>> liveWordList = wordViewModel.getAllWords();
        List<Word> wordList = wordViewModel.getNormalWordList();
//
//        if(wordList==null){
//            Log.i("wvmt","wordList == null");
//        }
//        Log.i("wordAdded ","wordList= "+wordList);
//        Word testWord = new Word("test");
        assertThat(wordList, is(equalTo(null)));



//        AsyncTaskRunner runner = new AsyncTaskRunner(testWord, wordViewModel);
//        runner.execute();
    }

    @Test
    public void wordAdded_wordsListChanged() {

        final Word expectedWord=new Word("test");

//        final Observer<List<Word>> wordObserver = new Observer<List<Word>>() {
//            @Override
//            public void onChanged(@Nullable final List<Word> wordList) {
//                assertThat(wordList,contains(expectedWord));
//
//            }
//        };

        WordViewModel wordViewModel = new WordViewModel((Application) context);

        // Observe the LiveData forever
//        wordViewModel.getAllWords().observeForever(wordObserver);
//        wordViewModel.insert(expectedWord);

//        LiveData<List<Word>> listWithWord= wordViewModel.getAllWords();
//        assertThat(listWithWord, not(nullValue()));




//        List<Word> wordList = wordViewModel.getNormalWordList();
//        //        AsyncTaskRunner taskRunner=new AsyncTaskRunner(expectedWord,wordViewModel,wordObserver);
////        taskRunner.execute();
        AsyncTaskRunner taskRunner=new AsyncTaskRunner(expectedWord, wordViewModel);
        taskRunner.execute();


    }

    private static class AsyncTaskRunner extends AsyncTask<Void, Void, Void> {

        Word word;
        WordViewModel wordViewModel;
        Observer<List<Word>> wordObserver;

//        public AsyncTaskRunner(Word word, WordViewModel wordViewModel,Observer<List<Word>> wordObserver){
//    public AsyncTaskRunner(Word word, WordViewModel wordViewModel,Observer<List<Word>> wordObserver){
        public AsyncTaskRunner(Word word, WordViewModel wordViewModel){
            this.word=word;
            this.wordViewModel=wordViewModel;
//            this.wordObserver=wordObserver;


        }

        @Override
        protected Void doInBackground(Void... voids) {
            wordViewModel.getAllWords().observeForever(wordObserver);
            wordViewModel.insert(word);
            return null;
        };
//        List<Word> updatedWordList=wordViewModel.getNormalWordList();
//        assertThat(updatedWordList, contains(testWord));
//        assertThat(wordList, contains((not(testWord))));

//        List<Word> arrayWordList=new ArrayList<Word>();
//
//
//
//        val userNameResult: LiveData<List<User>> = Transformations.map(
//                query,
//
//                List<Word> wordList=(List<Word>)liveWordList;
//        Word testWord=new Word("test");
//        assertThat(wordList, contains((not(testWord))));

//
//        wordViewModel.insert(new Word("test"));
//        assertThat(wordList, contains(testWord));
//        LiveData<List<Word>> getAllWords() { return mAllWords; }

    }

}