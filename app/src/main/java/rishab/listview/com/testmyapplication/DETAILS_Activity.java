package rishab.listview.com.testmyapplication;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class DETAILS_Activity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        getMenuInflater().inflate(R.menu.details_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {
           // case R.id.about:
                //Toast.makeText(getApplicationContext(),"about",Toast.LENGTH_SHORT).show();
            case R.id.Theme:
                Toast.makeText(getApplicationContext(),"Theme",Toast.LENGTH_SHORT).show();
            case R.id.time24:
                Toast.makeText(getApplicationContext(),"time 24 hour format",Toast.LENGTH_SHORT).show();
           // case R.id.setting:
                //Toast.makeText(getApplicationContext(),"setting",Toast.LENGTH_SHORT).show();
            case R.id.snooze:
                Toast.makeText(getApplicationContext(),"snooze",Toast.LENGTH_SHORT).show();

        }
        return true;
    }
}
