package rishab.listview.com.testmyapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mode1 extends AppCompatActivity {
    private Button mathbutton,mathnext,mathprev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode1);
        mathbutton=findViewById(R.id.modemath);
        mathnext=findViewById(R.id.mathnext);
        mathprev=findViewById(R.id.mathprev);
        mathbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(mode1.this,math_activity.class);
                startActivity(intent);
            }
        });
        mathnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(mode1.this,mode2.class);
                startActivity(intent);
            }
        });
        mathprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(mode1.this,mode3.class);
                startActivity(intent);
            }
        });
    }
}
