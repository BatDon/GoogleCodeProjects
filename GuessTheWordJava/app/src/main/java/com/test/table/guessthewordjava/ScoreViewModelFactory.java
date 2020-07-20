package com.test.table.guessthewordjava;

import android.app.Application;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

//class ScoreViewModelFactory extends ViewModelProvider.AndroidViewModelFactory{
class ScoreViewModelFactory extends ViewModelProvider.AndroidViewModelFactory {
    int finalScore;

    public ScoreViewModelFactory(Application application,int finalScore) {
        super(application);
        this.finalScore=finalScore;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        Log.i("ScoreViewModelFactory","modelClass=" +(modelClass.getSimpleName()));
        if (modelClass.isAssignableFrom(ScoreViewModel.class)){
            T t=(T)new ScoreViewModel(finalScore);
            return t;
        }
        throw new IllegalArgumentException("Unknown ViewModel class");


    }

    /**
     * Creates a {@code AndroidViewModelFactory}
     *
     * @param application an application to pass in {@link AndroidViewModel}
     */
//    public ScoreViewModelFactory(Application application) {
//        super(application);
//    }
}
