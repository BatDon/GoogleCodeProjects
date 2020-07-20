package com.test.table.guessthewordjava;

import android.app.Application;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class GameViewModel extends ViewModel {

    // The current word
    String word = "";
    // The current score
    int score = 0;
    // The list of words - the front of the list is the next word to guess
    private ArrayList<String> wordList;

    public GameViewModel() {
        resetList();
        nextWord();
        Log.i("GameViewModel", "GameViewModel created!");
    }


    public void resetList() {
        wordList = new ArrayList<String>();
        wordList.add("queen");
        wordList.add("hospital");
        wordList.add("basketball");
        wordList.add("cat");
        wordList.add("change");
        wordList.add("snail");
        wordList.add("calendar");
        wordList.add("sad");
        wordList.add("desk");
        wordList.add("guitar");
        wordList.add("home");
        wordList.add("railway");
        wordList.add("zebra");
        wordList.add("jelly");
        wordList.add("car");
        wordList.add("crow");
        wordList.add("trade");
        wordList.add("bad");
        wordList.add("roll");
        wordList.add("bubble");

        Collections.shuffle(wordList, new Random());
    }


    public void nextWord() {
        Log.i("GameFragment","started next word method");
        if(wordList == null){
            Log.i("GameFragment","WordList is empty");
            new NullPointerException();
        }
        int size=wordList.size();
        Log.i("GameFragment","list size= "+size);
        if (wordList != null || !wordList.isEmpty()) {
            //Select and remove a word from the list
            word=wordList.get(0);
            wordList.remove(0);
        }

    }

    public void onSkip() {
        score--;
        nextWord();
    }

    public void onCorrect() {
        score++;
        nextWord();
    }


    @Override
    public void onCleared() {
        super.onCleared();
        Log.i("GameViewModel", "GameViewModel destroyed!");
    }
}
