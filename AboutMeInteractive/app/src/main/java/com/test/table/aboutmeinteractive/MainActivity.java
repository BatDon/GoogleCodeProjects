package com.test.table.aboutmeinteractive;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText nicknameEdit;
    TextView nickNameText;
    Button doneButton;
    String nickName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nicknameEdit=findViewById(R.id.nickname_edit);
        nickNameText=findViewById(R.id.nickname_text);
        doneButton=findViewById(R.id.done_button);
    }

    public void addNickname(View view) {
        nickName=nicknameEdit.getText().toString();
        nickNameText.setText(nickName);
        nickNameText.setVisibility(View.VISIBLE);
        doneButton.setVisibility(View.GONE);
        nicknameEdit.setVisibility(View.GONE);
        closeKeyboard();
        //hideKeyboard(this);

    }

    public void updateNickname(View view) {
        nickNameText.setVisibility(View.GONE);
        nickNameText.requestFocus();
        doneButton.setVisibility(View.VISIBLE);
        nicknameEdit.setVisibility(View.VISIBLE);
//        InputMethodManager inputMethodManager =
//                (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
//        inputMethodManager.toggleSoftInputFromWindow(
//                linearLayout.getApplicationWindowToken(),
//                InputMethodManager.SHOW_FORCED, 0);
    }

    private void closeKeyboard(){
        View view=this.getCurrentFocus();
        if(view!=null){
            InputMethodManager imm=(InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(),0);
        }
    }




//    public static void hideKeyboard(Activity activity) {
//        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
//        //Find the currently focused view, so we can grab the correct window token from it.
//        View view = activity.getCurrentFocus();
//        //If no view currently has focus, create a new one, just so we can grab a window token from it
//        if (view == null) {
//            view = new View(activity);
//        }
//        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
//    }

}
