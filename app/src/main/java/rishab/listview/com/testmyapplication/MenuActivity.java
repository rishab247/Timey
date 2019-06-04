package rishab.listview.com.testmyapplication;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
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
    MediaPlayer  mediaPlayer ;
    AlarmManager alarmManager;
    private PendingIntent pending_intent;
    private String datadiffmath="0";

    MenuActivity inst;
    Context context;
boolean flag;
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
        Music music;
        final ImageView ivPlay;
        ivPlay = findViewById(R.id.setplaypause);
        final ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add( R.raw.alarmtone1);
        arrayList.add(R.raw.alarmtone2);
        arrayList.add( R.raw.alarmtone3);
        arrayList.add( R.raw.alarmtone4);
        arrayList.add(R.raw.alarmtone5);
        arrayList.add( R.raw.alarmtone6);
        arrayList.add( R.raw.alarmtone7);
        arrayList.add(R.raw.alarmtone8);
        arrayList.add( R.raw.alarmtone9);
        arrayList.add( R.raw.alarmtone10);
        arrayList.add( R.raw.alarmtone11);
        // play music
        mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.alarmtone1);
        ivPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag){                    mediaPlayer.release();

                    mediaPlayer = MediaPlayer.create(getApplicationContext(),arrayList.get(Integer.parseInt(dataTone)));
                    flag = false;
                }
                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.stop();
                    flag = true;
                    ivPlay.setImageResource(android.R.drawable.ic_media_play);
                } else {
                    mediaPlayer.start();
                    ivPlay.setImageResource(android.R.drawable.ic_media_pause);
                }
            }
        });
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

    finish();
    Intent intent=new  Intent(MenuActivity.this, DETAILS_Activity.class);
    startActivity(intent);
    savedata();

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
        setalarm();
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


void setalarm(){


    this.context = this;

    final Intent myIntent = new Intent(this, AlarmReceiver.class);

    alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);


    final Calendar calendar = Calendar.getInstance();

    final String hour = getDataHours();
    final String minute = getDataMintune();

    Log.e("MyActivity", "In the receiver withutuo " + hour + " and " + minute+"  "+getDataTone());

    int hour1  = Integer.parseInt(hour);
    int minute1  = Integer.parseInt(minute);
    calendar.set(Calendar.HOUR_OF_DAY, hour1);
    calendar.set(Calendar.MINUTE, minute1);
    calendar.set(Calendar.SECOND, 0);

    myIntent.putExtra("extra", "yes");
    myIntent.putExtra("tone", getDataTone());
    myIntent.putExtra("mode", Data1.mode);
    myIntent.putExtra("lable", dataLabel);
    myIntent.putExtra("noofshake", datanoofshakes);
    myIntent.putExtra("datanoofmath", datanoofmath);
    myIntent.putExtra("datadiffmath", datadiffmath);
    myIntent.putExtra("time", dataHours+dataMintune);

    final int code = Integer.valueOf(dataHours+dataMintune);


    pending_intent = PendingIntent.getBroadcast(MenuActivity.this, code, myIntent, PendingIntent.FLAG_UPDATE_CURRENT );

    alarmManager.set(AlarmManager.RTC_WAKEUP,  calendar.getTimeInMillis(), pending_intent);


}
@Override
    public void onStart() {
        super.onStart();
        inst = this;
    }

}