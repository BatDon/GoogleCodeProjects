package com.test.table.appwithsettings;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {

    public static final String KEY_PREF_EXAMPLE_SWITCH="example_switch";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();

        SharedPreferences sharedPref= PreferenceManager.getDefaultSharedPreferences(this);
        boolean switchPref=sharedPref.getBoolean(SettingsActivity.KEY_PREF_EXAMPLE_SWITCH,false);
        Toast.makeText(this,switchPref+"", Toast.LENGTH_SHORT).show();
    }
}
