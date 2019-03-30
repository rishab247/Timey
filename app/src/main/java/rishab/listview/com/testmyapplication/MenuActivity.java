package rishab.listview.com.testmyapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class MenuActivity extends AppCompatActivity {
private CardView cardView1,cardView2,cardView3,cardView4;
 int mo=0,tu=0,we=0,th=0,fr=0,sa=0,su=0;
private TextView textmo,texttu,textwe,textth,textfr,textsa,textsu;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        cardanimation();
        textselector();
    }
void cardanimation(){
    cardView1 = findViewById(R.id.cardView2);
    cardView1.setElevation(5);
    cardView1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            cardView1.setElevation(1);
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    cardView1.setElevation(5);
                }
            },100);
            Intent intent=new  Intent(MenuActivity.this,crolleractivity.class);
            startActivity(intent);

        }
    });

    cardView2 = findViewById(R.id.cardView3);
    cardView2.setElevation(5);
    cardView2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            cardView2.setElevation(1);
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    cardView2.setElevation(5);
                }
            },100);
            Intent intent=new  Intent(MenuActivity.this,crolleractivity.class);
            startActivity(intent);

        }
    });
    cardView3 = findViewById(R.id.cardView4);
    cardView3.setElevation(5);
    cardView3.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            cardView3.setElevation(1);
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    cardView3.setElevation(5);
                }
            },100);

        }
    });
    cardView4 = findViewById(R.id.cardView5);
    cardView4.setElevation(5);
    cardView4.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            cardView4.setElevation(1);
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    cardView4.setElevation(5);
                }
            },100);
            Intent intent=new  Intent(MenuActivity.this,alarmtonelist.class);
            startActivity(intent);

        }
    });
}

void textselector() {
textmo =findViewById(R.id.setmo);
    texttu =findViewById(R.id.settu);
    textwe =findViewById(R.id.setwe);
    textth =findViewById(R.id.setth);
    textfr =findViewById(R.id.setfr);
    textsa =findViewById(R.id.setsa);
    textsu =findViewById(R.id.setsu);
    textmo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(mo%2==0){
            textmo.setBackgroundColor(0xFF304FFE);
            textmo.setTextColor(0xFFFFFFFF);}
            else{

                textmo.setBackgroundColor(0xFFFFFFFF);
                textmo.setTextColor(0xFF000000);
            }

        mo++;
        }
    });


    texttu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(tu%2==0){
                texttu.setBackgroundColor(0xFF304FFE);
                texttu.setTextColor(0xFFFFFFFF);}
            else{

                texttu.setBackgroundColor(0xFFFFFFFF);
                texttu.setTextColor(0xFF000000);
            }

            tu++;
        }
    });
    textwe.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(we%2==0){
                textwe.setBackgroundColor(0xFF304FFE);
                textwe.setTextColor(0xFFFFFFFF);}
            else{

                textwe.setBackgroundColor(0xFFFFFFFF);
                textwe.setTextColor(0xFF000000);
            }

            we++;
        }
    });
    textth.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(th%2==0){
                textth.setBackgroundColor(0xFF304FFE);
                textth.setTextColor(0xFFFFFFFF);}
            else{

                textth.setBackgroundColor(0xFFFFFFFF);
                textth.setTextColor(0xFF000000);
            }

            th++;
        }
    });
    textfr.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(fr%2==0){
                textfr.setBackgroundColor(0xFF304FFE);
                textfr.setTextColor(0xFFFFFFFF);}
            else{

                textfr.setBackgroundColor(0xFFFFFFFF);
                textfr.setTextColor(0xFF000000);
            }
            fr++;
        }
    });
    textsa.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(sa%2==0){
                textsa.setBackgroundColor(0xFF304FFE);
                textsa.setTextColor(0xFFFFFFFF);}
            else{

                textsa.setBackgroundColor(0xFFFFFFFF);
                textsa.setTextColor(0xFF000000);
            }

            sa++;
        }
    });
    textsu.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(su%2==0){
                textsu.setBackgroundColor(0xFF304FFE);
                textsu.setTextColor(0xFFFFFFFF);}
            else{

                textsu.setBackgroundColor(0xFFFFFFFF);
                textsu.setTextColor(0xFF000000);
            }

            su++;
        }
    });



}

}