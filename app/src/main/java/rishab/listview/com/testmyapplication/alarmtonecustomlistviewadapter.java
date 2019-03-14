package rishab.listview.com.testmyapplication;


import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class alarmtonecustomlistviewadapter extends ArrayAdapter<Dataitem> {

    Context context;
    int layoutResourceId;
     List<Dataitem> data =null;

    public alarmtonecustomlistviewadapter(Context context, int resource, List<Dataitem> objects) {
        super(context, resource,objects);
        this.layoutResourceId=resource;
        this.context=context;
        this.data=objects;

    }

    static class DataHolder{
         TextView alarmtoneName;
        // TextView toneSerialNum;
         ImageView buttonImage;
    }
    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        DataHolder holder=null;
        if(convertView==null)
        {
            LayoutInflater inflater=((Activity)context).getLayoutInflater();
            convertView=inflater.inflate(layoutResourceId,parent);
            holder=new DataHolder();
            holder.alarmtoneName=(TextView)convertView.findViewById(R.id.tonename);
           // holder.toneSerialNum=(TextView)convertView.findViewById(R.id.toneserialnum);
            holder.buttonImage=(ImageView)convertView.findViewById(R.id.playButton);
                convertView.setTag(holder);
        }
        else {
            holder=(DataHolder)convertView.getTag();

        }
        Dataitem dataitem=data.get(position);
        holder.alarmtoneName.setText(dataitem.alarmtoneName);
       // holder.toneSerialNum.setText(dataitem.alarmToneSerialno);
        holder.buttonImage.setImageResource(dataitem.resIdImage);
        return convertView;

    }
}
