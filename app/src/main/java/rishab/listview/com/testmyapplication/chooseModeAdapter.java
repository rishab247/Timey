package rishab.listview.com.testmyapplication;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



    public class chooseModeAdapter extends PagerAdapter {
        public int pos;

        private Button modeButton;
        Context context;
        LayoutInflater inflater;
        private LinearLayout linearLayout;

        public String[] button_text_mode={
               "math",
                "shake",
                "simple"
        };



        //list of background colors
        public int[] lst_BacgroundColors={
                Color.rgb(55,55,55),
                Color.rgb(239,85,85),
                Color.rgb(110,49,89),
                Color.rgb(1,186,212)
        };
        public  chooseModeAdapter(Context context)
        {
            this.context=context;
        }


        @Override
        public int getCount() {
            return button_text_mode.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {

            return (view==o);
        }
        @Override
        public Object instantiateItem(ViewGroup container, final int position) {
            inflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            View view=inflater.inflate(R.layout.mode_row,container,false);
            linearLayout=view.findViewById(R.id.linearLayout);
            modeButton=view.findViewById(R.id.modeButton);
           pos = position;
          //  LinearLayout linearLayout=view.findViewById(R.id.linearLayout2);
            modeButton.setText(button_text_mode[position]);
            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem( ViewGroup container, int position, @NonNull Object object) {
            container.removeView((LinearLayout)object);
        }
    }


