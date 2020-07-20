package com.test.table.twoactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    TextView textView;
    private EditText mReply;
    public static final String EXTRA_REPLY="com.test.table.twoactivities.extra.REPLY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        mReply=findViewById(R.id.editText_second);
        textView=findViewById(R.id.text_message);

        Intent intent=getIntent();
        String message=intent.getStringExtra(Intent.EXTRA_TEXT);
        textView.setText(message);

    }

    public void returnReply(View view) {
        String reply =mReply.getText().toString();
        Intent replyIntent=new Intent();
        replyIntent.putExtra(EXTRA_REPLY,reply);
        setResult(RESULT_OK,replyIntent);
        finish();
    }

}
