package rishab.listview.com.testmyapplication;

import android.app.AlarmManager;
import android.app.AppComponentFactory;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.util.Calendar;

public class Alarm extends AppCompatActivity {
    AlarmManager alarmManager;
    private PendingIntent pending_intent;
    private String datadiffmath="0";

    Alarm inst;
    Context context;
    String hour , minute;
    public Alarm() {


    }
    void setalarm(String hour ,String minutes){
        this.hour = hour;
        this.minute = minutes;
        int hour1 = Integer.parseInt(hour);
        int minutes1 = Integer.parseInt(minutes);

        this.context = this;

        final Intent myIntent = new Intent(this, AlarmReceiver.class);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        final Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 3);
        //setAlarmText("You clicked a button");



        Log.e("MyActivity", "In the receiver withutuo " + hour + " and " + minute);

        calendar.set(Calendar.HOUR_OF_DAY, hour1);
        calendar.set(Calendar.MINUTE, minutes1);

        myIntent.putExtra("extra", "yes");
        pending_intent = PendingIntent.getBroadcast(Alarm.this, 2, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pending_intent);


    }
    @Override
    public void onStart() {
        super.onStart();
        inst = this;
    }
}
