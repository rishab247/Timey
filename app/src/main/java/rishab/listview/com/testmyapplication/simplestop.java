package rishab.listview.com.testmyapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

import in.shadowfax.proswipebutton.ProSwipeButton;

public class simplestop extends AppCompatActivity {
    private PendingIntent pending_intent;
    AlarmManager alarmManager;
    TextView txtlable;
    String lable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simplestop);

        String time  =  Objects.requireNonNull(getIntent().getExtras()).getString("time");
        if (time==null)
            time = "1200";
        final int code = Integer.valueOf(time);

             lable = getIntent().getExtras().getString("lable");

        txtlable =  findViewById(R.id.simplelabel);
        txtlable.setText(lable);
        final Intent myIntent = new Intent(this, AlarmReceiver.class);
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        final ProSwipeButton proSwipeBtn = findViewById(R.id.proswipebutton_main_error);
        proSwipeBtn.setSwipeDistance(0.1f);
        proSwipeBtn.setOnSwipeListener(new ProSwipeButton.OnSwipeListener() {
            @Override
            public void onSwipeConfirm() {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        proSwipeBtn.showResultIcon(true);
                        pending_intent = PendingIntent.getBroadcast(simplestop.this,code, myIntent, PendingIntent.FLAG_CANCEL_CURRENT);

                        myIntent.putExtra("extra", "no");
                        sendBroadcast(myIntent);
                        alarmManager.cancel(pending_intent);
                    }
                }, 500);            }
        });
    }
}
