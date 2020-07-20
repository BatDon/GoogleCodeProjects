package com.test.table.navigationhostapp;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMain extends Fragment {

    Button navigateToBlank;
    int points;

    public FragmentMain() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        points=100;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        navigateToBlank=(Button)getView().findViewById(R.id.button);

        navigateToBlank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                //final NavController navController=Navigation.findNavController(view);

                NavDirections action=FragmentMainDirections.actionFragmentMainToBlankFragment();
//                action.points=points;
                int amount=2;
                action.setAmount(amount);
                Bundle bundle = new Bundle();
                bundle.putInt("amount", 7);
                Navigation.findNavController(view).navigate(action);

//                action.navigate(R.id.action_fragmentMain_to_blankFragment);
            }
        });

    }


}
