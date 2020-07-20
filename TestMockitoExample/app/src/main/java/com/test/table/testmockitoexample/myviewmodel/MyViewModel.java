package com.test.table.testmockitoexample.myviewmodel;

import androidx.arch.core.util.Function;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

public class MyViewModel extends ViewModel {

    MutableLiveData<String> liveData1= new MutableLiveData<String>();
    MutableLiveData<ArrayList> liveData2= new MutableLiveData<ArrayList>();
    String test="test";
    LiveData userName;

    public void setNewValue(String value){
        liveData1.setValue(value);
    }

    public void setLiveData2Value(ArrayList arrayList){
        liveData2.setValue(arrayList);
    }

    public void addValue(String word){
        ArrayList<String> arrayList=liveData2.getValue();
        int size=arrayList.size();
        arrayList.add(size,word);
    }

//
// LiveData<User> userLiveData = ...;
//    LiveData<String> liveDataTest = Transformations.map(liveData1, test -> {
//        test=test+"another";
////        return test;
//    });

//    LiveData<User> userLiveData = ...;
//    LiveData<String> userName = Transformations.map(userLiveData, user -> {
//        user.name + " " + user.lastName
//    });

//    public LiveData transform() {
//        userName = Transformations.map(liveData1, transformation(test));
//        return userName;
//    }

//    public Function transformation(String test){
//
//        Function function=new Function(){
//
//            @Override
//            public Object apply(Object test) {
//                String transformedString=liveData1.getValue()+test;
//                return transformedString;
//            }
//        };
//        return function;
//    }

//    LiveData userName = Transformations.map(liveData1, user -> {
//        return user.firstName + " " + user.lastName
//    });
//private val _liveData1 = MutableLiveData<String>()
//        val liveData1: LiveData<String> = _liveData1
//
        // [Transformations.map] on liveData1 that converts the value to uppercase:
//        val liveData2 = _liveData1.map { it.toUpperCase() }
//
//        fun setNewValue(newValue: String) {
//        _liveData1.value = newValue
//        }
        }
