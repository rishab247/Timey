package rishab.listview.com.testmyapplication;



import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import com.sdsmdg.harjot.crollerTest.Croller;
import com.sdsmdg.harjot.crollerTest.OnCrollerChangeListener;

public class crolleractivity extends AppCompatActivity {
    private TextView txt;
    private Croller croller;
    private Button but,backbut;
    int countclick=0;
    private int startsize =12;
    private int endSize = 40;
    final int animationDuration = 600;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.crollerlayout);

        setcroller();
        txt=findViewById(R.id.crollertext1) ;
        but = findViewById(R.id.crollerbutton);
        backbut = findViewById(R.id.crollerback);




        backbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onback();
            }
        });
        but.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                if(countclick%2==0){
                  minutes();
                }
                else{
                   hours();
                }


                countclick++;
            }
        });
    }
    @Override
    public void onBackPressed() {
        onback();
    }
    void onback(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                this);

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertDialog.setNegativeButton("No",new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });

        alertDialog.setMessage("Do you want save changes ?");
        alertDialog.setTitle("Save");
        alertDialog.show();
    }

    void minutes(){
        croller.setProgress(0);
        Animatetext(txt,endSize,startsize);
        txt=findViewById(R.id.crollertext2);
        Animatetext(txt,startsize,endSize);
        setcroller();
        croller.setMax(59);
        but.setText("Minutes");
        croller.setOnProgressChangedListener(new Croller.onProgressChangedListener() {
            @Override
            public void onProgressChanged(int progress) { String str;
                str= Integer.toString(progress);
                txt.setText(str);
            }
        });
    }
void hours(){
    croller.setProgress(0);
    Animatetext(txt,endSize,startsize);
    txt=findViewById(R.id.crollertext1);
    Animatetext(txt,startsize,endSize);
    setcroller();
    croller.setMax(12);

    but.setText("Hours");
    croller.setOnProgressChangedListener(new Croller.onProgressChangedListener() {
        @Override
        public void onProgressChanged(int progress) { String str;
            str= Integer.toString(progress);
            txt.setText(str);
        }
    });
}
void Animatetext(TextView tv,int startsize,int endSize){


    tv.setTextSize(12);

    ValueAnimator animator = ObjectAnimator.ofFloat(tv, "textSize",startsize, endSize);
    animator.setDuration(animationDuration);
    animator.start();

}





    void setcroller(){
        croller = (Croller) findViewById(R.id.croller);
        croller.setProgress(0);
        croller.setIndicatorWidth(10);
        croller.setMin(00);
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
            public void onProgressChanged(int progress) { String str;
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
