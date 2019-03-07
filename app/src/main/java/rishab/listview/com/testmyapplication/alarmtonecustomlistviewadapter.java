package rishab.listview.com.testmyapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.Inflater;

public class alarmtonecustomlistviewadapter extends BaseAdapter {
    private Context context;
    private static LayoutInflater inflater=null;
    private ArrayList<HashMap<String,String>> Tone;
    public alarmtonecustomlistviewadapter (Context mcontext, ArrayList<HashMap<String,String>>data) {
        mcontext = context;
        Tone = data;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
      View view=convertView;
      if(convertView==null)
      {
          view=inflater.inflate(R.layout.alarm_tone_list_row,null);
          TextView toneserialnum=view.findViewById(R.id.toneserialnum);
          TextView tonename=view.findViewById(R.id.tonename);
          ImageView toneplay=view.findViewById(R.id.toneplay);
          HashMap<String,String> tones=new HashMap<>();
          tones=Tone.get(position);

          toneserialnum.setText(tones.get("tonesserialnum"));
          tonename.setText(tones.get("tonename"));
          toneplay.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_launcher_background));

      }
        return null;
    }
}
