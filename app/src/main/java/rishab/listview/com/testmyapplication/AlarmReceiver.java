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
            Log.e("MyActivity", "In the receiver with " + state);

            Intent serviceIntent = new Intent(context,RingtonePlayingService.class);
            serviceIntent.putExtra("extra", state);
            serviceIntent.putExtra("tone", tone);
            serviceIntent.putExtra("mode", mode);
            serviceIntent.putExtra("lable", lable);

            context.startService(serviceIntent);
        }
    }