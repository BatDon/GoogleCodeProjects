package com.test.table.guessthewordjava;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.test.table.guessthewordjava.databinding.GameFragmentBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameFragment extends Fragment {

    private GameFragmentBinding binding;
    private List<String> wordList;
    private String word="";
    private int score=0;
    private GameViewModel viewModel;
    View viewCreated;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        Log.i("GameFragment", "Called ViewModelProviders.of");
        viewModel = new ViewModelProvider(this).get(GameViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.game_fragment, container, false);
        View view=binding.getRoot();
        updateScoreText();
        updateWordText();
//      Inflate the layout for this fragment
       return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewCreated=view;

        final NavController navController=NavHostFragment.findNavController(GameFragment.this);
        binding.endGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                NavHostFragment.findNavController(GameFragment.this)
//                        navController.navigate(R.id.action_game_to_score);
                onEnd();
            }


        });

        binding.skipButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                onSkip();
            }
        });

        binding.correctButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                onCorrect();
            }
        });

    }



    private void onSkip() {
        viewModel.onSkip();
        updateWordText();
        updateScoreText();
    }

    private void onCorrect() {
        viewModel.onCorrect();
        updateScoreText();
        updateWordText();
    }

    public void onEnd(){
        gameFinished();
    }

    public void gameFinished(){
//        Toast.makeText(getActivity(), "Game has just finished", Toast.LENGTH_SHORT).show();
//        Action action = GameFragmentDirections.actionGameToScore();
//        action.score = viewModel.score;
//        NavHostFragment.findNavController(this).navigate(action);
//        final NavController navController=Navigation.findNavController(viewCreated);

        GameFragmentDirections.ActionGameToScore action =GameFragmentDirections.actionGameToScore();
        action.setScore(viewModel.score);
        Navigation.findNavController(viewCreated).navigate(action);
    }



    /** Methods for updating the UI **/

    private void updateWordText() {
        binding.wordText.setText(viewModel.word);
    }

    private void updateScoreText() {
        binding.scoreText.setText(String.valueOf(viewModel.score));
    }



}
