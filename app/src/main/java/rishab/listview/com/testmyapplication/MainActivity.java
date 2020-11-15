package rishab.listview.com.testmyapplication;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.Timer;
import java.util.TimerTask;

import rishab.listview.com.testmyapplication.database.databasehandler;

public class MainActivity extends AppCompatActivity {
    private Button but;
    databasehandler mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb=new databasehandler(this);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent=new  Intent(MainActivity.this, DETAILS_Activity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                startActivity(intent);
            }
        },1000);

    }
}
