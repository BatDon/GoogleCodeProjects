package com.test.table.notiificationscheduler;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;


public class NotificationJobService extends JobService {

    NotificationManager mNotifyManager;
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    @Override
    public boolean onStartJob(JobParameters jobParameters) {

        createNotificationChannel();
        PendingIntent contentPendingIntent=PendingIntent.getActivity(this
                ,0,new Intent(this,MainActivity.class)
                ,PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder builder=new NotificationCompat.Builder(this,PRIMARY_CHANNEL_ID)
                .setContentTitle(getString(R.string.job_service_title))
                .setContentText(getString(R.string.job_service_content))
                .setContentIntent(contentPendingIntent)
                .setSmallIcon(R.drawable.ic_job_running_foreground)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(true);

        mNotifyManager.notify(0,builder.build());
        //don't offload task onto background thread if fails
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        //if job fails reschedule job
        return true;
    }

    public void createNotificationChannel(){
        mNotifyManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);

        if(Build.VERSION.SDK_INT>=android.os.Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new NotificationChannel(
                    PRIMARY_CHANNEL_ID,getString(R.string.job_service_name),
                    NotificationManager.IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription(getString(R.string.notification_description));

            mNotifyManager.createNotificationChannel(notificationChannel);

        }
    }
}
