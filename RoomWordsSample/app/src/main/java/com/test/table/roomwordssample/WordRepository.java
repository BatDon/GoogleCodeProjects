package com.test.table.roomwordssample;

import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.widget.TextView;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mAllWords;

    public WordRepository(Application application) {
        WordRoomDatabase myDb=WordRoomDatabase.getDatabase(application);
        mWordDao=myDb.wordDao();
        mAllWords=mWordDao.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return mAllWords;
    }

    public void insert (Word word) {
        new insertAsyncTask(mWordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao mAsyncTaskDao;

        insertAsyncTask(WordDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Word...word) {
            Word wordParam=word[0];
            mAsyncTaskDao.insert(wordParam);

            return null;
        }

    }
}
