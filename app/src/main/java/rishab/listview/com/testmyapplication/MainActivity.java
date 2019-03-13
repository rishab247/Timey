package rishab.listview.com.testmyapplication;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sdsmdg.harjot.crollerTest.Croller;
import com.sdsmdg.harjot.crollerTest.OnCrollerChangeListener;

public class MainActivity extends AppCompatActivity {
        private TextView txt;
        private Croller croller;
    private Button but;

    final float startSize = 10; // Size in pixels
    final float endSize = 40;
    final int animationDuration = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



            but = findViewById(R.id.button12);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(MainActivity.this,alarmtonelist.class);
                startActivity(intent);

            }
        });



    }
}
