package com.test.table.guessthewordjava;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.table.guessthewordjava.databinding.ScoreFragmentBinding;


//import com.test.table.guessthewordjava.databinding.ScoreFragmentBinding;


public class ScoreFragment extends Fragment {

    private ScoreFragmentBinding binding;
    private ViewModel viewModel;
    private ScoreViewModelFactory scoreViewModelFactory;
//    public ScoreFragment() {
//    }

//    ScoreFragmentBinding scoreBinding;


    public ScoreFragment() {
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = DataBindingUtil.inflate(inflater, R.layout.score_fragment, container, false);
        View view = binding.getRoot();

        if (getArguments() != null) {
            ScoreFragmentArgs args = ScoreFragmentArgs.fromBundle(getArguments());
            int score = args.getScore();
            scoreViewModelFactory = new ScoreViewModelFactory(getActivity().getApplication(), score);
            Log.i("ScoreFragment","scoreViewModelFactory created");

            viewModel = ViewModelProviders.of(this, scoreViewModelFactory)
                    .get(ScoreViewModel.class);
            ScoreViewModel scoreViewModel=(ScoreViewModel)viewModel;
            binding.scoreText.setText(String.valueOf(scoreViewModel.score));
        }
        // Inflate the layout for this fragment
        return view;
    }

}




    //    @Override
//    public View onCreateView(
//            LayoutInflater inflater, ViewGroup container,
//            Bundle savedInstanceState
//            ) {
//            scoreBinding = DataBindingUtil.inflate(inflater, R.layout.score_fragment, container, false);
//            View view=scoreBinding.getRoot();
//
//    //      Inflate the layout for this fragment
//            return view;
//            }


