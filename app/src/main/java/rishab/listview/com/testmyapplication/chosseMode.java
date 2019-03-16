package rishab.listview.com.testmyapplication;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class chosseMode extends AppCompatActivity {
    private chooseModeAdapter modeAdapter;
    private ViewPager modeViewPager;
    int n=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chosse_mode);
        modeViewPager=findViewById(R.id.modeViewPager);

            modeAdapter=new chooseModeAdapter(this);
            modeViewPager.setAdapter(modeAdapter);


    }
}
