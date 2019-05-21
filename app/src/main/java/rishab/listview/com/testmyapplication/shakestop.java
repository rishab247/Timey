package rishab.listview.com.testmyapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Vibrator;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class shakestop extends Activity
{private ShakeListener mShaker;
TextView text;
int count = 0;
TextView txtlable;
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shakestop);
        Intent intent = getIntent();
        String lable = Objects.requireNonNull(intent.getExtras()).getString("lable");
        txtlable =  findViewById(R.id.shakelable);
        txtlable.setText(lable);
final String totalno = "50";
        final Vibrator vibe = (Vibrator)getSystemService(Context.VIBRATOR_SERVICE);
text = findViewById(R.id.skhakecount);
        mShaker = new ShakeListener(this);
        mShaker.setOnShakeListener(new ShakeListener.OnShakeListener () {
            public void onShake()
            {count++;
                vibe.vibrate(100);
                text.setText(Integer.toString(count)+"/"+totalno);
            }
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

