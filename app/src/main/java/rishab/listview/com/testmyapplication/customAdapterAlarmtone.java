package rishab.listview.com.testmyapplication;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class customAdapterAlarmtone extends BaseAdapter {

    private Context context;
    private ArrayList<String> ids;
    private ArrayList<String> names;
    public customAdapterAlarmtone(Context context, ArrayList<String> ids, ArrayList<String> names) {
        this.context = context;
        this.ids=ids;
        this.names = names;
    }


    @Override
    public int getCount() {
        return names.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = View.inflate(context, R.layout.alarm_tone_list_row, null);
        }

        TextView toneSerialNum = (TextView) convertView.findViewById(R.id.toneserialnum);
        TextView toneName=(TextView)convertView.findViewById(R.id.tonename);
        toneName.setText(names.get(position));

        toneSerialNum.setText(ids.get(position));

        return convertView;

    }

}
