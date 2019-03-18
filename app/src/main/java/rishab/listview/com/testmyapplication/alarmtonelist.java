package rishab.listview.com.testmyapplication;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class alarmtonelist extends AppCompatActivity {

    private ListView listView;
    int x=0;
    private customAdapterAlarmtone adapter;
    ArrayList<String> idImages;
    ArrayList<String>  AlarmnameList;

    private MediaPlayer mediaPlayer;
    ImageView  imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmtonelist);
        imageView=findViewById(R.id.playButton);

        mediaPlayer=new MediaPlayer();
        mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.alarmtone1);

        listView=  findViewById(R.id.alarmlist);
        AlarmnameList = new ArrayList<>();
        AlarmnameList=getNameList();
        idImages= new ArrayList<>();
        idImages=getList();
        adapter = new customAdapterAlarmtone(alarmtonelist.this,idImages,AlarmnameList);
        listView.setAdapter(adapter);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone11);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                {

                player(position,view);


                }
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
        AlarmnameList.add("Alarm tone 9");
        AlarmnameList.add("Alarm tone 10");
        AlarmnameList.add("Alarm tone 11");

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
        idImages.add("7");
        idImages.add("8");
        idImages.add("9");
        idImages.add("10");
        idImages.add("11");
        return idImages;
    }
void playpause(View view){
    switch (view.getId()) {
        case R.id.list: {
            if (mediaPlayer.isPlaying()) {

                if(mediaPlayer!=null)
                {
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    imageView.setBackgroundResource(android.R.drawable.ic_media_pause);

                }

            } else {
                if(mediaPlayer !=null){
                    mediaPlayer.start();
                    imageView= view.findViewById(R.id.playButton);
                    imageView.setBackgroundResource(android.R.drawable.ic_media_pause);
                        }
                }
            break;
            }
        }}
            public void player ( int a,View view){
                switch (a) {
                    case 0: {

                        if(x%2==0){
                        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone1);
                        playpause(view);
                        x=1;
                        }
                        else{
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            imageView.setBackgroundResource(android.R.drawable.ic_media_play);
                            x=0;
                        }

                        break;
                    }
                    case 1: {

                        if(x%2==0){
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone2);
                            playpause(view);
                            x=1;
                        }
                        else{
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            imageView.setBackgroundResource(android.R.drawable.ic_media_play);
                            x=0;
                        }
                        break;
                    }
                    case 2: {
                        if(x%2==0){
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone3);
                            playpause(view);
                            x=1;
                        }
                        else{
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            imageView.setBackgroundResource(android.R.drawable.ic_media_play);
                            x=0;
                        }
                        break;
                    }
                    case 3: {
                        if(x%2==0){
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone4);
                            playpause(view);
                            x=1;
                        }
                        else{
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            imageView.setBackgroundResource(android.R.drawable.ic_media_play);
                            x=0;
                        }
                        break;
                    }
                    case 4: {
                        if(x%2==0){
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone5);
                            playpause(view);
                            x=1;
                        }
                        else{
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            imageView.setBackgroundResource(android.R.drawable.ic_media_play);
                            x=0;
                        }
                        break;
                    }
                    case 5: {
                        if(x%2==0){
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone6);
                            playpause(view);
                            x=1;
                        }
                        else{
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            imageView.setBackgroundResource(android.R.drawable.ic_media_play);
                            x=0;
                        }
                        break;
                    }
                    case 6: {
                        if(x%2==0){
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone7);
                            playpause(view);
                            x=1;
                        }
                        else{
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            imageView.setBackgroundResource(android.R.drawable.ic_media_play);
                            x=0;
                        }
                        break;
                    }
                    case 7: {
                        if(x%2==0){
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone8);
                            playpause(view);
                            x=1;
                        }
                        else{
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            imageView.setBackgroundResource(android.R.drawable.ic_media_play);
                            x=0;
                        }
                        break;
                    }
                    case 8: {
                        if(x%2==0){
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone9);
                            playpause(view);
                            x=1;
                        }
                        else{
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            imageView.setBackgroundResource(android.R.drawable.ic_media_play);
                            x=0;
                        }
                        break;
                    }
                    case 9: {
                        if(x%2==0){
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone10);
                            playpause(view);
                            x=1;
                        }
                        else{
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            imageView.setBackgroundResource(android.R.drawable.ic_media_play);
                            x=0;
                        }
                        break;
                    }
                    case 10: {
                        if(x%2==0){
                            mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone11);
                            playpause(view);
                            x=1;
                        }
                        else{
                            mediaPlayer.stop();
                            mediaPlayer.release();
                            imageView.setBackgroundResource(android.R.drawable.ic_media_play);
                            x=0;
                        }
                        break;
                    }

                }

            }


    @Override
    protected void onDestroy() {
        if(mediaPlayer!=null&&mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;

        }
        super.onDestroy();
    }
}