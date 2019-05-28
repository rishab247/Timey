package rishab.listview.com.testmyapplication;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Vibrator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class shakestop extends Activity
{private ShakeListener mShaker;
TextView text;

    AlarmManager alarmManager;
    private PendingIntent pending_intent;

int count = 0;
TextView txtlable;



    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shakestop);
        Intent intent = getIntent();
        String lable = Objects.requireNonNull(intent.getExtras()).getString("lable");
        String time  =  Objects.requireNonNull(intent.getExtras()).getString("time");
        final int code = Integer.valueOf(time);

        txtlable =  findViewById(R.id.shakelable);
        txtlable.setText(lable);
final String totalno =Objects.requireNonNull(intent.getExtras()).getString("noofshake");
        final Vibrator vibe = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
text = findViewById(R.id.skhakecount);
        mShaker = new ShakeListener(this);
        mShaker.setOnShakeListener(new ShakeListener.OnShakeListener () {
            @SuppressLint("SetTextI18n")
            public void onShake()
            {count++;
                vibe.vibrate(100);
                text.setText(count +"/"+totalno);
            }
        });

        final Intent myIntent = new Intent(this, AlarmReceiver.class);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        Button btn  = findViewById(R.id.shakebut);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                        if(count >= Integer.parseInt(totalno)){
                            pending_intent = PendingIntent.getBroadcast(shakestop.this,code, myIntent, PendingIntent.FLAG_UPDATE_CURRENT);
                        myIntent.putExtra("extra", "no");
                        sendBroadcast(myIntent);
                        alarmManager.cancel(pending_intent);
            }}
        });
    }

    @Override
    public void onResume()
    {
        mShaker.resume();
        super.onResume();
    }
    @Override
    public void onPause()
    {
        mShaker.pause();
        super.onPause();
    }
}

