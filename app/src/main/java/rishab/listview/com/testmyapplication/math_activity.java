package rishab.listview.com.testmyapplication;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static java.util.logging.Logger.global;

public class math_activity extends AppCompatActivity {
    private TextView mathnotext,mathdifficulty;
    private SeekBar seekBar1,seekBar2;
    private Button mathback,mathsave;
    private String  pos,noofmath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_activity);
        mathback=findViewById(R.id.seekbarback);
        mathsave=findViewById(R.id.seekbarsave);
        seekBar1=findViewById(R.id.seekbarno);
        mathnotext=findViewById(R.id.mathnotext);
        seekBar2=findViewById(R.id.seekBardifficulti);
        mathdifficulty=findViewById(R.id.mathdifficulti);

        mathsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });

    seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String str= Integer.toString(progress);
                pos=str;
                switch (progress) {
                    case 0:
                        mathnotext.setText("22+48");
                        break;
                    case 1:
                        mathnotext.setText("46+39+43");
                        break;
                    case 2:
                        mathnotext.setText("29*20");
                        break;
                    case 3:
                        mathnotext.setText("45/23");
                        break;
                    case 4:
                        mathnotext.setText("23*41/21");
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        mathback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onbacks();
            }
        });

      seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
          @Override
          public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
              progress=progress+1;
              String str = Integer.toString(progress);
                noofmath=str;
              int max=seekBar2.getMax()+1;

              mathdifficulty.setText("No of Problems "+progress+"/"+max);

          }

          @Override
          public void onStartTrackingTouch(SeekBar seekBar) {

          }

          @Override
          public void onStopTrackingTouch(SeekBar seekBar) {

          }
      });
    }
    void onbacks(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);


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
}
