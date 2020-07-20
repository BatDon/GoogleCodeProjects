package com.test.table.guessthewordjava;

import android.util.Log;

import androidx.lifecycle.ViewModel;

public class ScoreViewModel extends ViewModel {

    int score;
    public ScoreViewModel(int finalScore) {
        score=finalScore;
        Log.i("ScoreViewModel", "Final score is $finalScore");
    }

}
