package com.test.table.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import timber.log.Timber;

public class MainActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final int TEXT_REQUEST = 1;
    EditText mMessageEditText;
    private TextView mReplyHeadTextView;
    private TextView mReplyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mMessageEditText=findViewById(R.id.editText_main);
        mReplyHeadTextView=findViewById(R.id.text_header_reply);
        mReplyTextView=findViewById(R.id.text_message_reply);
    }

    public void launchSecondActivity(View view) {
        Timber.i("Button clicked");
        Log.i(LOG_TAG,"Button clicked log");
        String message= mMessageEditText.getText().toString();


        Intent intent=new Intent(this,SecondActivity.class);
        intent.putExtra(Intent.EXTRA_TEXT,message);
        startActivityForResult(intent, TEXT_REQUEST);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==TEXT_REQUEST){
            if(resultCode==RESULT_OK){
                String reply=data.getStringExtra(SecondActivity.EXTRA_REPLY);
                mReplyHeadTextView.setVisibility(View.VISIBLE);
                mReplyTextView.setText(reply);
                mReplyTextView.setVisibility(View.VISIBLE);

            }
        }
    }
}