package com.example.android.background;

import android.content.Context;
import androidx.annotation.NonNull;
import android.util.Log;


import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.android.background.sync.ReminderTasks;

public class MyWorker extends Worker {

    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }


    @NonNull
    @Override
    public Result doWork() {
//        ReminderTasks.incrementWaterCount(getApplicationContext());
        for (int i = 0; i < 100; i++) {
            Log.i("MyWorker","doWork "+i);
        }
        ReminderTasks.issueChargingReminder(getApplicationContext());

        return Result.success();
    }
}
