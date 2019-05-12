package rishab.listview.com.testmyapplication;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class button_mode extends AppCompatActivity {

    private ViewPager viewPager;
    private slideAdapter myadapter;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_mode);
        viewPager = findViewById(R.id.viewpager);
        myadapter = new slideAdapter(this);
        viewPager.setAdapter(myadapter);

    }

}
