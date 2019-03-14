package rishab.listview.com.testmyapplication;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class alarmtonelist extends AppCompatActivity {
    private TextView textView;
    ImageView imageView ;
    ListView listView;
    customAdapterAlarmtone adapter;
    ArrayList<String> idImages;
    ArrayList<String>  AlarmnameList;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmtonelist);
        listView= (ListView) findViewById(R.id.alarmlist);
        textView=findViewById(R.id.toneserialnum);
        AlarmnameList = new ArrayList<>();
        AlarmnameList=getNameList();
        idImages= new ArrayList<>();
        idImages=getList();
        adapter = new customAdapterAlarmtone(alarmtonelist.this,idImages,AlarmnameList);
        listView.setAdapter(adapter);




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){


            public void onItemClick(AdapterView<?> parent, View view , int position, long id) {
                Toast.makeText(alarmtonelist.this, "Item Id Is" +idImages.get(position), Toast.LENGTH_SHORT).show();
                ImageView imageView=view.findViewById(R.id.playButton);
                imageView.setBackgroundResource(android.R.drawable.ic_media_pause);

            }
        });

    }










    public ArrayList<String> getNameList(){
        AlarmnameList = new ArrayList<>();
        AlarmnameList.add("Alarm tone 1");
        AlarmnameList.add("Alarm tone 2");
        AlarmnameList.add("Alarm tone 3");
        AlarmnameList.add("Alarm tone 4");
        AlarmnameList.add("Alarm tone 5");
        AlarmnameList.add("Alarm tone 6");
        AlarmnameList.add("Alarm tone 7");
        AlarmnameList.add("Alarm tone 8");
        return AlarmnameList;
    }

    public ArrayList<String> getList(){
        idImages = new ArrayList<>();
        idImages.add("1");
        idImages.add("2");
        idImages.add("3");
        idImages.add("4");
        idImages.add("5");
        idImages.add("6");
        idImages.add("6");
        idImages.add("7");
        idImages.add("8");
        return idImages;
    }


}
