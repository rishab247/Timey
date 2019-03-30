package rishab.listview.com.testmyapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mode2 extends AppCompatActivity {

    private Button shakebutton,shakenext,shakeprev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode2);
        shakebutton=findViewById(R.id.modeshake);
        shakenext=findViewById(R.id.shakenext);
        shakeprev=findViewById(R.id.shakeprev);


        shakebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(mode2.this,shake.class);
                startActivity(intent);
            }
        });
        shakenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(mode2.this,mode3.class);
                startActivity(intent);
            }
        });
        shakeprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(mode2.this,mode1.class);
                startActivity(intent);
            }
        });
    }
}
