package rishab.listview.com.testmyapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class math_activity extends AppCompatActivity {
    private TextView mathnotext,mathdifficulty;
    private SeekBar seekBar1,seekBar2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_activity);
        seekBar1=findViewById(R.id.seekbarno);
        mathnotext=findViewById(R.id.mathnotext);
        seekBar2=findViewById(R.id.seekBardifficulti);
        mathdifficulty=findViewById(R.id.mathdifficulti);
        seekBar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
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

      seekBar2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
          @Override
          public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
              progress=progress+1;

              mathdifficulty.setText("No of Problems "+progress+"/"+seekBar2.getMax());

          }

          @Override
          public void onStartTrackingTouch(SeekBar seekBar) {

          }

          @Override
          public void onStopTrackingTouch(SeekBar seekBar) {

          }
      });







    }
}
