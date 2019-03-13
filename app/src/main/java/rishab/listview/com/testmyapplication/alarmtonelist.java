package rishab.listview.com.testmyapplication;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class alarmtonelist extends AppCompatActivity  {
    private ListView alarmTonelistView;
    private alarmtonecustomlistviewadapter alarmtonecustomlistviewadapter;
    private MediaPlayer mediaPlayer;
    private Button tonePlay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmtonelist);
        final String[] ToneSerialNum=new String[]{"1","2","3","4","5","6","7","8","9"};
        final String[] Tonename=new String[]{
                "alarmtone 1",
                "alarmtone 2",
                "alarmtone 3",
                "alarmtone 4",
                "alarmtone 5",
                "alarmtone 6",
                "alarmtone 7",
                "alarmtone 8",
                "alarmtone 9"
        };
        ArrayList<HashMap<String,String>> Tonelist=new ArrayList<>();
        for(int i=0;i<8;++i)
        {
            HashMap<String,String> data=new HashMap<>();
            data.put("tonesserialnum",ToneSerialNum[i]);
            data.put("tonename",Tonename[i]);
            Tonelist.add(data);
        }
        alarmTonelistView=findViewById(R.id.alarmlist);
        alarmtonecustomlistviewadapter=new alarmtonecustomlistviewadapter(getApplicationContext(),Tonelist);
        alarmTonelistView.setAdapter(alarmtonecustomlistviewadapter);
        alarmTonelistView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int myPosition = position;
                String itemClikedId = alarmTonelistView.getItemAtPosition(myPosition).toString();
                Toast.makeText(getApplicationContext(), "item cliked" + itemClikedId, Toast.LENGTH_SHORT).show();

            }
        });
    }


}
