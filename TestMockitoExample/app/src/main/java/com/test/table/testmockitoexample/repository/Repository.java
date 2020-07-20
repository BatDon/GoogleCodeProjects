package com.test.table.testmockitoexample.repository;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

public class Repository {

    public MutableLiveData<String> mutableLiveData=new MutableLiveData<>();

    public String getData(){
        return "This is data";
    }

    public void getValues(String a, String b){
        Log.d("",""+a+" "+b);
    }

    public MutableLiveData<String> getMutableLiveData(String name, String pass) {

        mutableLiveData.setValue("name is "+name+" pass is "+pass);
        return mutableLiveData;
    }
}
