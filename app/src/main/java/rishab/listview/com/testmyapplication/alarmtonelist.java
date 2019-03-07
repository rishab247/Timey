package rishab.listview.com.testmyapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class alarmtonelist extends AppCompatActivity {
    private ListView alarmTonelistView;
    private alarmtonecustomlistviewadapter alarmtonecustomlistviewadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmtonelist);
        final String[] ToneSerialNum=new String[]{
                "1","2","3","4","5","6","7","8","9","10","11"

        };
        final String[] Tonename=new String[]{
                "alarmtone 1",
                "alarmtone 2",
                "alarmtone 3",
                "alarmtone 4",
                "alarmtone 5",
                "alarmtone 6",
                "alarmtone 7",
                "alarmtone 8",
                "alarmtone 9",
                "alarmtone 10",
                "alarmtone 11"

        };
        ArrayList<HashMap<String,String>> Tonelist=new ArrayList<>();
        for(int i=0;i<11;i++)
        {
            HashMap<String,String> data=new HashMap<>();
            data.put("toneserialnum",ToneSerialNum[i]);
            data.put("tonename",Tonename[i]);
            Tonelist.add(data);
        }
        alarmTonelistView=findViewById(R.id.alarmlist);
        alarmtonecustomlistviewadapter=new alarmtonecustomlistviewadapter(getApplicationContext(),Tonelist);
        alarmTonelistView.setAdapter(alarmtonecustomlistviewadapter);
    }
}
