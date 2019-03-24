package rishab.listview.com.testmyapplication;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class chosseMode extends AppCompatActivity {
    private chooseModeAdapter modeAdapter;
    private ViewPager modeViewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosse_mode);
        modeViewPager=findViewById(R.id.modeViewPager);
        modeAdapter=new chooseModeAdapter(this);
        modeViewPager.setAdapter(modeAdapter);

}}
