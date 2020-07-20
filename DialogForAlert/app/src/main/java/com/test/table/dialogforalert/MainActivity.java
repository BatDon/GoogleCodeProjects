package com.test.table.dialogforalert;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickShowAlert(View view) {
        AlertDialog.Builder myAlertBuilder= new AlertDialog.Builder(MainActivity.this);
        myAlertBuilder.setTitle(R.string.alert_title);
        myAlertBuilder.setMessage(R.string.alert_message);

        myAlertBuilder.setPositiveButton(R.string.ok_button, new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int which){
                makeToast(getString(R.string.ok_message));
            }
        });

        myAlertBuilder.setNegativeButton(R.string.cancel_button, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                makeToast(getString(R.string.cancel_message));
            }
        });

        myAlertBuilder.show();
    }

    private void makeToast(String toastMessage) {
        Toast.makeText(getApplicationContext(), ""+toastMessage, Toast.LENGTH_SHORT).show();
    }


}
