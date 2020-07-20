package com.test.table.colormyviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    View constraintlayout;

    Button button;
    View.OnClickListener makeColoredOnClickListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setFirstListeners();
        setListeners();
    }
    private void setFirstListeners(){
        makeColoredOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makeColored(v);
            }
        };
    }


    private void setListeners() {
        tv1 = findViewById(R.id.box_one_text);
        tv2 = findViewById(R.id.box_two_text);
        tv3 = findViewById(R.id.box_three_text);
        tv4 = findViewById(R.id.box_four_text);
        tv5 = findViewById(R.id.box_five_text);
        constraintlayout = findViewById(R.id.constraint_layout);

        List<View> clickableViews = Arrays.asList(new View[]{tv1, tv2, tv3, tv4, tv5, constraintlayout});
        for (View view : clickableViews) {
            view.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    makeColored(v);
                }

            });

        }

    }
    public void doSomething(){
    }


//
//    public OnClickListener getOnClickListener() {
//        return onClickListener;
//    }button.setOnClickListener(new OnClickListener(View v) {
//        @Override
//        public void onClick(View v) {
//
//        }
//    });
//    tv1.setOnClickListener(this);
//
//    tv1.setOnClickListener(new View.onClickListener() {
//        public void onClick(View v) {
//            Intent intent = new Intent(MainActivity.this, ASLevelActivity.class);
//            startActivity(intent);
//        }
//    });
//
//    OnClickListener onClickListener=new OnClickListener(){
//        onClick(View v){
//
//        }
//    }


//    public void onClick(View v) {
//
//        }

    public void makeColored(View view){
        Toast.makeText(this, "makeColored", Toast.LENGTH_SHORT).show();
        int viewId=view.getId();
        switch (viewId){
            case R.id.box_one_text:
                view.setBackgroundColor(Color.DKGRAY);
                return;
            case R.id.box_two_text:
                view.setBackgroundColor(Color.GRAY);
                return;
            case R.id.box_three_text:
                view.setBackgroundColor(Color.BLUE);
                return;
            case R.id.box_four_text:
                view.setBackgroundColor(Color.MAGENTA);
                return;
            case R.id.box_five_text:
                view.setBackgroundColor(Color.BLUE);
                return;
            default:
                view.setBackgroundColor(Color.LTGRAY);
        }
    }
}
