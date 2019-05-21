package rishab.listview.com.testmyapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class customMyAdapter extends SimpleAdapter {
    private final Context context;
   private final ArrayList<HashMap<String, String>> arrayList;


    public customMyAdapter(Context context, ArrayList<HashMap<String, String>> data, int resource, String[] from, int[] to) {
        super(context, data, resource, from, to);
        this.context = context;
        this.arrayList = data;

        LayoutInflater.from(context);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = super.getView(position, convertView, parent);
        ImageView imageView = view.findViewById(R.id.detailsimage);

        TextView textmo =view.findViewById(R.id.detailsmo);
        TextView texttu =view.findViewById(R.id.detailstu);
        TextView textwe =view.findViewById(R.id.detailswe);
        TextView textth =view.findViewById(R.id.detailsthu);
        TextView  textfr =view.findViewById(R.id.detailsfri);
        TextView textsa =view.findViewById(R.id.detailssat);
        TextView textsu =view.findViewById(R.id.detailssun);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, String> hashmap= arrayList.get(position);
                String string= hashmap.get("repeat");
                string = Objects.requireNonNull(string).trim();


                Toast.makeText(context,string,Toast.LENGTH_SHORT).show();
            }
        });

        HashMap<String, String> hashmap= arrayList.get(position);
        String string= Objects.requireNonNull(hashmap.get("repeat")).trim();
       String[] separated = Objects.requireNonNull(string).split("");

            for(int i=1;i<=string.length();i++){
                String number = separated[i] ;
                int result = Integer.parseInt(number);
               if(result<8 && result>0){
                if(result==1) {
                    textmo.setBackgroundColor(0xFF304FFE);
                    textmo.setTextColor(0xFFFFFFFF); }
                else if(result==2){
                        texttu.setBackgroundColor(0xFF304FFE);
                        texttu.setTextColor(0xFFFFFFFF);}
                else if(result==3){
                        textwe.setBackgroundColor(0xFF304FFE);
                        textwe.setTextColor(0xFFFFFFFF);}
                else if(result==4){
                        textth.setBackgroundColor(0xFF304FFE);
                        textth.setTextColor(0xFFFFFFFF);}
                else if(result==5){
                        textfr.setBackgroundColor(0xFF304FFE);
                        textfr.setTextColor(0xFFFFFFFF);}
                else if(result==6){
                        textsa.setBackgroundColor(0xFF304FFE);
                        textsa.setTextColor(0xFFFFFFFF);}
                else {
                    textsu.setBackgroundColor(0xFF304FFE);
                    textsu.setTextColor(0xFFFFFFFF);
                }
                }}




        return view;

    }

}