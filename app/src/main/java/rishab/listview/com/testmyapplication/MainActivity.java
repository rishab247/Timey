package rishab.listview.com.testmyapplication;
import android.content.Intent;
import android.graphics.ColorSpace;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import rishab.listview.com.testmyapplication.database.databasehandler;

public class MainActivity extends AppCompatActivity {
    private Button but;
    databasehandler mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb=new databasehandler(this);

            but = findViewById(R.id.button12);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(MainActivity.this, MenuActivity.class);
                startActivity(intent);

            }
        });
    }
}
