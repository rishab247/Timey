package rishab.listview.com.testmyapplication;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.Log;

import java.util.Objects;
import java.util.Random;

import static android.content.ContentValues.TAG;
import static java.lang.Integer.*;

public class RingtonePlayingService extends Service {

    Intent intent1;
    private boolean isRunning;
    private Context context;
    MediaPlayer mMediaPlayer;


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("MyActivity", "In the Richard service");
        return null;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {

        final NotificationManager mNM = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        //String state1 = intent.getExtras().getString("stop");
        String tone = Objects.requireNonNull(intent.getExtras()).getString("tone");
        String mode = intent.getExtras().getString("mode");
        String lable = intent.getExtras().getString("lable");
        String noofshake = intent.getExtras().getString("noofshake");
        String datanoofmath = intent.getExtras().getString("datanoofmath");
        String datadiffmath = intent.getExtras().getString("datadiffmath");
        String time = intent.getExtras().getString("time");
        if(mode==null) mode = "simple";
        if(noofshake==null) noofshake = "50";
        if(datadiffmath==null) datadiffmath = "1";
        if(datanoofmath==null) datanoofmath = "1";

        if(tone==null) tone = "3";
        if(time==null) time = "1200  ";


        switch(mode){
            case "Math":
            {
                intent1 = new Intent(this.getApplicationContext(), mathstop.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent1.putExtra("lable",lable);
                intent1.putExtra("datanoofmath",datanoofmath);
                intent1.putExtra("datadiffmath",datadiffmath);
                break;
            }
            case "Shake":
            {
                intent1 = new Intent(this.getApplicationContext(), shakestop.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent1.putExtra("lable",lable);
                intent1.putExtra("noofshake",noofshake);
                break;

            }
            default:
            {
                intent1 = new Intent(this.getApplicationContext(), simplestop.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                intent1.putExtra("lable",lable);
                break;
            }
        }
        intent1.putExtra("time",time);

        PendingIntent pIntent = PendingIntent.getActivity(this, 0, intent1,  PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_ONE_SHOT);

        Notification mNotify  = new Notification.Builder(this)
                .setContentTitle("Time' s UP !!!")
                .setContentText("Click me!")
                .setSmallIcon(R.drawable.ic_launcher_background)
                                .setContentIntent(pIntent)
                .setAutoCancel(true)
                .build();

        String state = intent.getExtras().getString("extra");


        assert state != null;
        switch (state) {
            case "no":
                startId = 0;
                break;
            case "yes":
                startId = 1;
                break;
            default:
                startId = 0;
                break;
        }


        int startId1;
        if(!this.isRunning && startId == 1) {
            Log.e("if there was not sound ", " and you want start");


            int random_number= Integer.parseInt(tone);
            Log.e("random number is ", String.valueOf(random_number));

            if (random_number == 1) mMediaPlayer = MediaPlayer.create(this, R.raw.alarmtone1);
            else if (random_number == 2) mMediaPlayer = MediaPlayer.create(this, R.raw.alarmtone2);
            else if (random_number == 3) mMediaPlayer = MediaPlayer.create(this, R.raw.alarmtone3);
            else if (random_number == 4) mMediaPlayer = MediaPlayer.create(this, R.raw.alarmtone4);
            else if (random_number == 5) mMediaPlayer = MediaPlayer.create(this, R.raw.alarmtone5);
            else if (random_number == 6) mMediaPlayer = MediaPlayer.create(this, R.raw.alarmtone6);
            else if (random_number == 7) mMediaPlayer = MediaPlayer.create(this, R.raw.alarmtone7);
            else if (random_number == 8) mMediaPlayer = MediaPlayer.create(this, R.raw.alarmtone8);
            else if (random_number == 9) mMediaPlayer = MediaPlayer.create(this, R.raw.alarmtone9);
            else if (random_number == 10)
                mMediaPlayer = MediaPlayer.create(this, R.raw.alarmtone10);
            else mMediaPlayer = MediaPlayer.create(this, R.raw.alarmtone1);
            //mMediaPlayer = MediaPlayer.create(this, R.raw.richard_dawkins_1);

            mMediaPlayer.start();


            mNM.notify(0, mNotify);

            this.isRunning = true;
            startId1 = 0;

        }
        else if (!this.isRunning && startId == 0){
            Log.e("if there was not sound ", " and you want end");

            this.isRunning = false;
            startId1 = 0;

        }

        else if (this.isRunning && startId == 1){
            Log.e("if there is sound ", " and you want start");

            this.isRunning = true;
            startId1 = 0;

        }
        else {
            Log.e("if there is sound ", " and you want end");

            mMediaPlayer.stop();
            mMediaPlayer.reset();

            this.isRunning = false;
            startId1 = 0;
        }


        Log.e("MyActivity", "In the service");

        return START_NOT_STICKY;

    }


    @Override
    public void onDestroy() {
        Log.e("JSLog", "on destroy called");
        super.onDestroy();

        this.isRunning = false;
    }







}
