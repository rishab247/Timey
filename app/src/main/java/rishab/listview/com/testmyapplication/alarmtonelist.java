package rishab.listview.com.testmyapplication;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


@SuppressWarnings("ALL")
public class alarmtonelist extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarmtonelist);


        ListView songList = findViewById(R.id.alarmlist);
        ArrayList<Music> arrayList = new ArrayList<>();
        arrayList.add(new Music("Alarm Tone 1",1, R.raw.alarmtone1));
        arrayList.add(new Music("Alarm Tone 2", 2,R.raw.alarmtone2));
        arrayList.add(new Music("Alarm Tone 3",3, R.raw.alarmtone3));
        arrayList.add(new Music("Alarm Tone 4",4, R.raw.alarmtone4));
        arrayList.add(new Music("Alarm Tone 5", 5,R.raw.alarmtone5));
        arrayList.add(new Music("Alarm Tone 6",6, R.raw.alarmtone6));
        arrayList.add(new Music("Alarm Tone 7",7, R.raw.alarmtone7));
        arrayList.add(new Music("Alarm Tone 8",8, R.raw.alarmtone8));
        arrayList.add(new Music("Alarm Tone 9",9, R.raw.alarmtone9));
        arrayList.add(new Music("Alarm Tone 10",10, R.raw.alarmtone10));
        arrayList.add(new Music("Alarm Tone 11",11, R.raw.alarmtone11));

        CustomMusicAdapter adapter = new CustomMusicAdapter(this, R.layout.alarm_tone_list_row, arrayList);
        songList.setAdapter(adapter);
        songList.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                Intent intent = new Intent();
                intent.putExtra("tone", Integer.toString(position+1));

                setResult(RESULT_OK, intent);


                finish();            }
        });

    }
}



@SuppressWarnings("ALL")
class CustomMusicAdapter extends BaseAdapter {

        private final Context context;
        private final int layout;
        @SuppressWarnings("deprecation")
        private final ArrayList<Music> arrayList;
        private MediaPlayer mediaPlayer;
        private Boolean flag = true;

        public CustomMusicAdapter(Context context, int layout, ArrayList<Music> arrayList) {
            this.context = context;
            this.layout = layout;
            this.arrayList = arrayList;
        }

        @Override
        public int getCount() {
            return arrayList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        private class ViewHolder {
            TextView txtName;
            TextView txtno;
            ImageView ivPlay;

        }

        @SuppressLint("SetTextI18n")
        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            final ViewHolder viewHolder;
            if(convertView == null){
                viewHolder = new ViewHolder();
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                assert layoutInflater != null;
                convertView = layoutInflater.inflate(layout, null);
                viewHolder.txtName = convertView.findViewById(R.id.tonename);
                viewHolder.ivPlay = convertView.findViewById(R.id.playButton);
                viewHolder.txtno = convertView.findViewById(R.id.toneserialnum);
                convertView.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) convertView.getTag();
            }

            final Music music = arrayList.get(position);
            viewHolder.txtName.setText(music.getName());
            viewHolder.txtno.setText(Integer.toString(music.getno()));
            // play music
            viewHolder.ivPlay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(flag){
                        mediaPlayer = MediaPlayer.create(context, music.getSong());
                        flag = false;
                    }
                    if(mediaPlayer.isPlaying()) {
                        mediaPlayer.pause();
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        flag = true;
                        viewHolder.ivPlay.setImageResource(android.R.drawable.ic_media_play);
                    } else {
                        mediaPlayer.start();
                        viewHolder.ivPlay.setImageResource(android.R.drawable.ic_media_pause);
                    }
                }
            });



            return convertView;
        }
    }
