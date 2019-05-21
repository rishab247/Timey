package rishab.listview.com.testmyapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Objects;

public class mathstop extends AppCompatActivity {
TextView txtlable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathstop);
        Intent intent = getIntent();
        String lable = Objects.requireNonNull(intent.getExtras()).getString("lable");
        txtlable =  findViewById(R.id.mathlable);
        txtlable.setText(lable);
    }
}
