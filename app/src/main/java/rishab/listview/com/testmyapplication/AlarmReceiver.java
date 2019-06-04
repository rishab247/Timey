package rishab.listview.com.testmyapplication;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Objects;

public class AlarmReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String state = Objects.requireNonNull(intent.getExtras()).getString("extra");
            String tone = Objects.requireNonNull(intent.getExtras()).getString("tone");
            String mode = Objects.requireNonNull(intent.getExtras()).getString("mode");
            String lable = Objects.requireNonNull(intent.getExtras()).getString("lable");
            String noofshake  =  Objects.requireNonNull(intent.getExtras()).getString("noofshake");
            String datanoofmath = Objects.requireNonNull(intent.getExtras()).getString("datanoofmath");
            String datadiffmath  =  Objects.requireNonNull(intent.getExtras()).getString("datadiffmath");

            String time  =   Objects.requireNonNull(intent.getExtras()).getString("time");
            Log.e("MyActivity", "In the receiver with 1231232133231231231  " + time);

            Intent serviceIntent = new Intent(context,RingtonePlayingService.class);
            serviceIntent.putExtra("extra", state);
            serviceIntent.putExtra("tone", tone);
            serviceIntent.putExtra("mode", mode);
            serviceIntent.putExtra("lable", lable);
            serviceIntent.putExtra("noofshake", noofshake);
            serviceIntent.putExtra("datanoofmath", datanoofmath);
            serviceIntent.putExtra("datadiffmath", datadiffmath);
            serviceIntent.putExtra("time", time);

            context.startService(serviceIntent);
        }
    }