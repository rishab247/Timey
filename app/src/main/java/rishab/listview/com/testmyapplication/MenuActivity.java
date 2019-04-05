package rishab.listview.com.testmyapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

import rishab.listview.com.testmyapplication.database.databasehandler;

public class MenuActivity extends AppCompatActivity {
    private databasehandler db;
private CardView cardView1,cardView2,cardView3,cardView4;
 private  int mo=0,tu=0,we=0,th=0,fr=0,sa=0,su=0;
private TextView textmo,texttu,textwe,textth,textfr,textsa,textsu;
private Button savebut,backbut;
private EditText alarmtitle;
    private int dataHours= 12;
    private int dataMintune= 00;
    private String dataRepeat_days= null;
    private String dataLabel= null;
    private int dataTone= 1;
    private String dataMode= "simple";
    private String str=null;
    private int datanoofshakes=0;
    private int datanoofmath=0;
    private int datadiffmath=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        cardanimation();
        textselector();
        savebut = findViewById(R.id.setsave);
        savebut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               save();
            }
        });
        backbut = findViewById(R.id.setback);
        backbut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            onback();
            }
        });
        alarmtitle = findViewById(R.id.setalarmtitle);

        str=alarmtitle.getText().toString();
        setDataLabel(str);
    }

    public int getDatanoofshakes() {
        return datanoofshakes;
    }

    public void setDatanoofshakes(int datanoofshakes) {
        this.datanoofshakes = datanoofshakes;
    }

    public int getDatanoofmath() {
        return datanoofmath;
    }

    public void setDatanoofmath(int datanoofmath) {
        this.datanoofmath = datanoofmath;
    }

    public int getDatadiffmath() {
        return datadiffmath;
    }

    public void setDatadiffmath(int datadiffmath) {
        this.datadiffmath = datadiffmath;
    }

    public int getDataHours() {
        return dataHours;
    }

    public void setDataHours(int dataHours) {
        this.dataHours = dataHours;
    }

    public int getDataMintune() {
        return dataMintune;
    }

    public void setDataMintune(int dataMintune) {
        this.dataMintune = dataMintune;
    }

    public String getDataRepeat_days() {
        return dataRepeat_days;
    }

    public void setDataRepeat_days(String dataRepeat_days) {
        this.dataRepeat_days = dataRepeat_days;
    }

    public String getDataLabel() {
        return dataLabel;
    }

    public void setDataLabel(String dataLabel) {
        this.dataLabel = dataLabel;
    }

    public int getDataTone() {
        return dataTone;
    }

    public void setDataTone(int dataTone) {
        this.dataTone = dataTone;
    }

    public String getDataMode() {
        return dataMode;
    }

    public void setDataMode(String dataMode) {
        this.dataMode = dataMode;
    }

    void onback(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                this);

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
                Intent intent=new  Intent(MenuActivity.this,MenuActivity.class);
                startActivity(intent);



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
void repeatingdays()
{str = " ";
    if(mo%2==0){
        str=concat(str,"1 ");
    }
    if(tu%2==0){
        str=concat(str,"2 ");
    }
    if(we%2==0){
        str=concat(str,"3 ");
    }
    if(th%2==0){
        str=concat(str,"4 ");
    }
    if(fr%2==0){
        str=concat(str,"5 ");
    }
    if(sa%2==0){
        str=concat(str,"6 ");
    }
    if(su%2==0){
        str=concat(str,"5 ");
    }
}
void save(){
        repeatingdays();
        MenuActivity m = new MenuActivity();
        m.setDataRepeat_days(str);
    finish();}
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
            finish();
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
            finish();
            Intent intent=new  Intent(MenuActivity.this,button_mode.class);
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
            finish();
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
void savedata(){
        db.insertdata(getDataHours(),getDataMintune(),getDataRepeat_days(),getDataLabel(),getDataTone(),getDataMode(),getDatanoofshakes(),getDatadiffmath(),getDatanoofmath());

}
}