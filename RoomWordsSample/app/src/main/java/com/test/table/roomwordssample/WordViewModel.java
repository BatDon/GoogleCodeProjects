package com.test.table.roomwordssample;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class WordViewModel extends AndroidViewModel {
    private WordRepository mRepository;
    private LiveData<List<Word>> mAllWords;
    private List<Word> wordList;

    public WordViewModel(@NonNull Application application) {
        super(application);
        mRepository=new WordRepository(application);
        mAllWords=mRepository.getAllWords();
    }

    public void insert(Word word) { mRepository.insert(word); }

    LiveData<List<Word>> getAllWords() { return mAllWords; }

    public void updateNormalList(List<Word> wordsList){
        wordList=wordsList;
    }

    public List<Word> getNormalWordList(){
        return wordList;
    }


}
