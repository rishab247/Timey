package rishab.listview.com.testmyapplication;
import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class alarmtonelist extends AppCompatActivity {
int a=0;
    ArrayList<String> idImages;
    ArrayList<String>  AlarmnameList;
    private MediaPlayer mediaPlayer;
    int x=0;
    ImageView imageView;
    public ArrayList<String> data(){
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

    public ArrayList<String> list() {


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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmtonelist);

        AlarmnameList = new ArrayList<>();
        idImages= new ArrayList<>();
        ListView lv = (ListView) findViewById(R.id.alarmlist);
        lv.setAdapter(new MyListAdaper(this, R.layout.alarm_tone_list_row, data()));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(alarmtonelist.this, "List item was clicked at " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }






    private class MyListAdaper extends ArrayAdapter<String> {
        private int layout;
        private List<String> mObjects;
        private List<String> o;

        private MyListAdaper(Context context, int resource, List<String> objects) {
            super(context, resource, objects);
            mObjects = objects;
            layout = resource;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder mainViewholder = null;
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(getContext());
                convertView = inflater.inflate(R.layout.alarm_tone_list_row, parent, false);
                ViewHolder viewHolder = new ViewHolder();
                viewHolder.thumbnail = (TextView) convertView.findViewById(R.id.toneserialnum);
                viewHolder.title=convertView.findViewById(R.id.tonename);
                viewHolder.button = (Button) convertView.findViewById(R.id.playButton);
                convertView.setTag(viewHolder);
            }
            mainViewholder = (ViewHolder) convertView.getTag();

            //final ViewHolder finalMainViewholder = mainViewholder;
            final ViewHolder finalMainViewholder1 = mainViewholder;
            mainViewholder.button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    player(position,finalMainViewholder1);

                    Toast.makeText(getContext(), "Button was clicked for list item " + position, Toast.LENGTH_SHORT).show();
                }
            });
            mainViewholder.thumbnail.setText(getItem(position));
            for(int i=1;i<=12;i++)
            {
                mainViewholder.title.setText("Alarm tone "+getItem(position));
            }


            return convertView;
        }
    }

    public class ViewHolder {

        TextView thumbnail;
        TextView title;
        Button button;
    }






    void playpause(ViewHolder finalMainViewholder1){
         if (mediaPlayer.isPlaying()) {

                    if(mediaPlayer!=null)
                    {
                        mediaPlayer.pause();
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        finalMainViewholder1.button.setBackgroundResource(android.R.drawable.ic_media_play);
                    }

                } else {
                    if(mediaPlayer !=null){
                        mediaPlayer.start();
                        finalMainViewholder1.button.setBackgroundResource(android.R.drawable.ic_media_play);
                    
                    }
                
        }}
    public void player ( int a,ViewHolder finalMainViewholder1){
        switch (a) {
            case 0: {

                if(x%2==0){
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone1);
                    playpause(finalMainViewholder1);
                    x=1;
                }
                else{
                    mediaPlayer.pause();
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    finalMainViewholder1.button.setBackgroundResource(android.R.drawable.ic_media_play);
                    x=0;
                }

                break;
            }
            case 1: {

                if(x%2==0){
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone2);
                    playpause(finalMainViewholder1);
                    x=1;
                }
                else{
                    mediaPlayer.pause();
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    finalMainViewholder1.button.setBackgroundResource(android.R.drawable.ic_media_play);
                    x=0;
                }
                break;
            }
            case 2: {
                if(x%2==0){
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone3);
                    playpause(finalMainViewholder1);
                    x=1;
                }
                else{
                    mediaPlayer.pause();
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    finalMainViewholder1.button.setBackgroundResource(android.R.drawable.ic_media_play);
                    x=0;
                }
                break;
            }
            case 3: {
                if(x%2==0){
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone4);
                    playpause(finalMainViewholder1);
                    x=1;
                }
                else{
                    mediaPlayer.pause();
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    finalMainViewholder1.button.setBackgroundResource(android.R.drawable.ic_media_play);

                    x=0;
                }
                break;
            }
            case 4: {
                if(x%2==0){
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone5);
                    playpause(finalMainViewholder1);
                    x=1;
                }
                else{
                    mediaPlayer.pause();
                    mediaPlayer.stop();

                    mediaPlayer.release();
                    finalMainViewholder1.button.setBackgroundResource(android.R.drawable.ic_media_play);
                    x=0;
                }
                break;
            }
            case 5: {
                if(x%2==0){
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone6);
                    playpause(finalMainViewholder1);
                    x=1;
                }
                else{
                    mediaPlayer.pause();
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    finalMainViewholder1.button.setBackgroundResource(android.R.drawable.ic_media_play);
                    x=0;
                }
                break;
            }
            case 6: {
                if(x%2==0){
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone7);
                    playpause(finalMainViewholder1);
                    x=1;
                }
                else{
                    mediaPlayer.pause();
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    finalMainViewholder1.button.setBackgroundResource(android.R.drawable.ic_media_play);
                    x=0;
                }
                break;
            }
            case 7: {
                if(x%2==0){
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone8);
                    playpause(finalMainViewholder1);
                    x=1;
                }
                else{
                    mediaPlayer.pause();
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    finalMainViewholder1.button.setBackgroundResource(android.R.drawable.ic_media_play);
                    x=0;
                }
                break;
            }
            case 8: {
                if(x%2==0){
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone9);
                    playpause(finalMainViewholder1);
                    x=1;
                }
                else{
                    mediaPlayer.pause();
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    finalMainViewholder1.button.setBackgroundResource(android.R.drawable.ic_media_play);
                    x=0;
                }
                break;
            }
            case 9: {
                if(x%2==0){
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone10);
                    playpause(finalMainViewholder1);
                    x=1;
                }
                else{
                    mediaPlayer.pause();
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    finalMainViewholder1.button.setBackgroundResource(android.R.drawable.ic_media_play);
                    x=0;
                }
                break;
            }
            case 10: {
                if(x%2==0){
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone11);
                    playpause(finalMainViewholder1);
                    x=1;
                }
                else{
                    mediaPlayer.pause();
                    mediaPlayer.stop();
                    mediaPlayer.release();
                    finalMainViewholder1.button.setBackgroundResource(android.R.drawable.ic_media_play);
                    x=0;
                }
                break;
            }

        }

    }


    @Override
    protected void onDestroy() {
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.alarmtone3);
        if(mediaPlayer!=null&&mediaPlayer.isPlaying()){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;

        }
        super.onDestroy();
        finish();

}}