package rishab.listview.com.testmyapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import com.sdsmdg.harjot.crollerTest.Croller;

public class MainActivity extends AppCompatActivity {
    private Button but;
    private Croller croller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            but = findViewById(R.id.button12);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new  Intent(MainActivity.this,MenuActivity.class);
                startActivity(intent);
            }
        });



    }
}
