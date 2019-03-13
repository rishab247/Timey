package rishab.listview.com.testmyapplication;



import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.sdsmdg.harjot.crollerTest.Croller;
import com.sdsmdg.harjot.crollerTest.OnCrollerChangeListener;

public class crolleractivity extends AppCompatActivity {
    private TextView txt;
    private Croller croller;
    private Button but;
    int a=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crollerlayout);

        setcroller();
        txt=findViewById(R.id.textView) ;
        but = findViewById(R.id.button2);
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt=findViewById(R.id.textView2);

            }
        });

        final TextView tv ;
        tv = findViewById(R.id.textView2);
        tv.setTextSize(12);
        final float endSize = 40;
        final int animationDuration = 600; // Animation duration in ms





        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setTextSize(12);
                ValueAnimator animator = ObjectAnimator.ofFloat(tv, "textSize", endSize);
                animator.setDuration(animationDuration);
                animator.start();
                a++;
                if(a>1){
                    tv.setTextSize(12);
                }
            }
        });
    }







    void setcroller(){
        croller = (Croller) findViewById(R.id.croller);
        croller.setIndicatorWidth(10);
        croller.setMin(0);
        croller.setLabel("");
        croller.setBackCircleColor(Color.parseColor("#EDEDED"));
        croller.setMainCircleColor(Color.WHITE);
        croller.setMax(12);
        croller.setStartOffset(45);
        croller.setIsContinuous(true);
        croller.setLabelColor(Color.BLACK);
        croller.setProgressPrimaryColor(Color.parseColor("#0B3C49"));
        croller.setIndicatorColor(Color.parseColor("#0B3C49"));
        croller.setProgressSecondaryColor(Color.parseColor("#EEEEEE"));

        croller = (Croller) findViewById(R.id.croller);
        croller.setOnProgressChangedListener(new Croller.onProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress) {
                // use the progress
                String str;
                str= Integer.toString(progress);
                txt.setText(str);
            }
        });

        croller.setOnCrollerChangeListener(new OnCrollerChangeListener() {
            @Override
            public void onProgressChanged(Croller croller, int progress) {
                // use the progress
            }

            @Override
            public void onStartTrackingTouch(Croller croller) {
                // tracking started
            }

            @Override
            public void onStopTrackingTouch(Croller croller) {
                // tracking stopped
            }
        });
    }

}
