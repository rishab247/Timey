package rishab.listview.com.testmyapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class mode3 extends AppCompatActivity {
    private Button simplebutton,simplenext,simpleprev;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode3);
        simplebutton=findViewById(R.id.modesimple);
        simplenext=findViewById(R.id.simplenext);
        simpleprev=findViewById(R.id.simpleprev);


        simplebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MenuActivity m =new MenuActivity();
                Intent intent=new  Intent(mode3.this,mode1.class);
                startActivity(intent);
            }
        });
        simplenext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(mode3.this,mode1.class);
                startActivity(intent);
            }
        });
        simpleprev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new  Intent(mode3.this,mode2.class);
                startActivity(intent);
            }
        });
    }
}
