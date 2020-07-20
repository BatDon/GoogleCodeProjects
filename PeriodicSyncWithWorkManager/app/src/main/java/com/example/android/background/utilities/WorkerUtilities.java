package com.example.android.background.utilities;

import androidx.work.Constraints;
import androidx.work.Worker;

import com.firebase.jobdispatcher.Constraint;


public class WorkerUtilities {
    private static WorkerUtilities constraintInstance= null;
    private static boolean sInitialized;


    public Constraints mConstraints;

    private WorkerUtilities(){

    }

    public static WorkerUtilities getInstance(){
        if(constraintInstance==null){
            constraintInstance=new WorkerUtilities();
        }
        return constraintInstance;
    }

    public Constraints getConstraints(){
        return new Constraints.Builder().setRequiresCharging(true).build();
    }



}
