package rishab.listview.com.testmyapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import rishab.listview.com.testmyapplication.database.databasehandler;

public class MenuActivity extends AppCompatActivity {
    private databasehandler db;
private CardView cardView1,cardView2,cardView3,cardView4;
 private  int mo=0,tu=0,we=0,th=0,fr=0,sa=0,su=0;
private TextView textmo,texttu,textwe,textth,textfr,textsa,textsu,texttime,alarmtone;
private Button savebut,backbut;
private EditText alarmtitle;
private TextView textmode;
private ImageView toneedit;
    private String dataHours= "12";
    private String dataMintune= "00";
    private String dataRepeat_days= "mo";
    private String dataLabel= "hello";
    private String dataTone= "1";
    private String dataMode= "simple";
    private String str=" ",str1=null;
    private String datanoofshakes="0";
    private String datanoofmath="0";
    private String datadiffmath="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        tone();
        cardanimation();
        textselector();
      db= new databasehandler(this);
      db.getWritableDatabase();
        savebut = findViewById(R.id.setsave);
        savebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               save();
            }
        });
        texttime = findViewById(R.id.settime);
        backbut = findViewById(R.id.setback);

        backbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            onback();
            }
        });
        alarmtitle = findViewById(R.id.setalarmtitle);
textmode = findViewById(R.id.setalarmmode);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                dataHours = data.getStringExtra("hours");
                dataMintune= data.getStringExtra("minutes");
            }
        }
        if (requestCode==3){
            if(resultCode == RESULT_OK) {
                dataTone = data.getStringExtra("tone");

            }
        }
        if(requestCode ==2){
            if(resultCode==RESULT_OK){
                dataMode = data.getStringExtra("mode");
                if(dataMode.equals("math")){
                    datadiffmath = data.getStringExtra("diffmath");
                    datanoofmath = data.getStringExtra("noofmath");


                }
                else if(dataMode.equals("shake")){
                    datanoofshakes = data.getStringExtra("noofshake");


                }
            }
        }
    }





    public String getDatanoofshakes() {
        return datanoofshakes;
    }


    public String getDatanoofmath() {
        return datanoofmath;
    }


    public String getDatadiffmath() {
        return datadiffmath;
    }


    public String getDataHours() {
        return dataHours;
    }


    public String getDataMintune() {
        return dataMintune;
    }



    public String getDataRepeat_days() {
        return dataRepeat_days;
    }


    public String getDataLabel() {
        return dataLabel;
    }


    public String getDataTone() {
        return dataTone;
    }


    public String getDataMode() {
        return dataMode;
    }


    void onback(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);

        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
               save();
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
    public static String concat(String s1, String s2)
    {
        return new StringBuilder(s1).append(s2).toString();
    }
    void tone(){

        toneedit = findViewById(R.id.seteditalarmtone);
        alarmtone = findViewById(R.id.setalarmtone);
        toneedit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new  Intent(MenuActivity.this,alarmtonelist.class);
                startActivityForResult(intent,3);

            }
        });
    }
void repeatingdays()
{
    if(mo%2!=0){
        str=concat(str,"1");
    }
    if(tu%2!=0){
        str=concat(str,"2");
    }
    if(we%2!=0){
        str=concat(str,"3");
    }
    if(th%2!=0){
        str=concat(str,"4");
    }
    if(fr%2!=0){
        str=concat(str,"5");
    }
    if(sa%2!=0){
        str=concat(str,"6");
    }
    if(su%2!=0){
        str=concat(str,"7");
    }
}
void save(){

    str1=alarmtitle.getText().toString();
    dataLabel=str1.trim();
        repeatingdays();
       dataRepeat_days=str;
       savedata();

    finish();
    Intent intent=new  Intent(MenuActivity.this, DETAILS_Activity.class);
    startActivity(intent);

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
            startActivityForResult(intent,1);


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
            Intent intent=new  Intent(MenuActivity.this,button_mode.class);
            startActivityForResult(intent,2);

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
                Toast.makeText(getApplicationContext(),getDataTone(),Toast.LENGTH_LONG).show();

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
void savedata(){
    Toast.makeText(getApplicationContext(),Data1.mode,Toast.LENGTH_SHORT).show();
       db.insertdata(getDataHours(),getDataMintune(),getDataRepeat_days(),getDataLabel(),getDataTone(),getDataMode(),getDatanoofshakes(),getDatadiffmath(),getDatanoofmath());
       db.close();
        refresh();
}

    @Override
    protected void onPostResume() {
        updateactivity();
        super.onPostResume();
    }

    void updateactivity(){
        dataMode = Data1.mode;
        datanoofshakes=Data1.nos;
       datanoofmath=Data1.nom;
       datadiffmath=Data1.diffom;
    textmode.setText(Data1.mode+" Mode");
        alarmtone.setText("Alarm Tone "+getDataTone());
         texttime.setText(String.format("%s:%s", dataHours, dataMintune));
}
void refresh (){
        Data1.mode="Simple";
        Data1.nos=null;
        Data1.nom=null;
        Data1.diffom=null;
}
}