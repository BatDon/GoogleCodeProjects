package com.test.table.notiificationscheduler;

import androidx.appcompat.app.AppCompatActivity;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup networkOptions;
    private JobScheduler mScheduler;
    private static final int JOB_ID = 0;
    private Switch mDeviceIdleSwitch;
    private Switch mDeviceChargingSwitch;
    private SeekBar mSeekBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        networkOptions=findViewById(R.id.networkOptions);
        mDeviceIdleSwitch=findViewById(R.id.idleSwitch);
        mDeviceChargingSwitch=findViewById(R.id.chargingSwitch);
        mSeekBar=findViewById(R.id.seekBar);
        final TextView seekBarProgress=findViewById(R.id.seekBarProgress);
        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(i>0){
                    seekBarProgress.setText(i +" s");
                }
                else{
                    seekBarProgress.setText(R.string.not_set);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void scheduleJob(View view) {

        mScheduler=(JobScheduler)(getSystemService(JOB_SCHEDULER_SERVICE));

        int selectedNetworkID=networkOptions.getCheckedRadioButtonId();
        int selectedNetworkOption= JobInfo.NETWORK_TYPE_NONE;

        switch(selectedNetworkID){
            case R.id.noNetwork:
                selectedNetworkOption=JobInfo.NETWORK_TYPE_NONE;
                break;
            case R.id.anyNetwork:
                selectedNetworkOption=JobInfo.NETWORK_TYPE_ANY;
                break;
            case R.id.wifiNetwork:
                selectedNetworkOption=JobInfo.NETWORK_TYPE_UNMETERED;
                break;
        }
        ComponentName serviceName= new ComponentName(getPackageName()
                ,NotificationJobService.class.getName());
        JobInfo.Builder builder=new JobInfo.Builder(JOB_ID, serviceName);
        builder.setRequiredNetworkType(selectedNetworkOption);
        builder.setRequiresDeviceIdle(mDeviceIdleSwitch.isChecked());
        builder.setRequiresCharging(mDeviceChargingSwitch.isChecked());

        int seekBarInteger= mSeekBar.getProgress();
        boolean seekBarSet= seekBarInteger>0;
        if(seekBarSet){
            builder.setOverrideDeadline(seekBarInteger*1000);
        }


        boolean constraintSet = (selectedNetworkOption != JobInfo.NETWORK_TYPE_NONE
                || mDeviceChargingSwitch.isChecked() || mDeviceIdleSwitch.isChecked()
                || seekBarSet);

        if(constraintSet){
            JobInfo myJobInfo=builder.build();
            mScheduler.schedule(myJobInfo);
            Toast.makeText(this,getString(R.string.job_scheduled), Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, R.string.set_one_constraint
            ,Toast.LENGTH_SHORT).show();
        }

    }

    public void cancelJobs(View view) {
        if(mScheduler!=null){
            mScheduler.cancelAll();
            mScheduler=null;
            Toast.makeText(this, R.string.jobs_cancelled,Toast.LENGTH_SHORT);
        }
    }
}