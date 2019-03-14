package rishab.listview.com.testmyapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

public class MenuActivity extends AppCompatActivity {
private CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        cardView = findViewById(R.id.cardView2);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Timer().schedule(new TimerTask() {
                    @Override
                    public void run() {
                        cardView.setElevation(1);
                    }
                },500);

            }
        });
    }
}
