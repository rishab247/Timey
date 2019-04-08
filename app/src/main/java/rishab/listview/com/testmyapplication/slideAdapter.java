package rishab.listview.com.testmyapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class slideAdapter extends PagerAdapter {
    Context context;
    LayoutInflater inflater;

    // list of images

    // list of titles
    public String[] lst_title = {
            "MATH",
            "SHAKE",
            "SIMPLE"

    };
    // list of descriptions

    // list of background colors



    public slideAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return lst_title.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view==(LinearLayout)object);
    }

    @Override
    public Object instantiateItem(final ViewGroup container, final int position) {
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        final View view = inflater.inflate(R.layout.slide,container,false);
        LinearLayout layoutslide = (LinearLayout) view.findViewById(R.id.slidelinearlayout1);
        Button imgslide =   view.findViewById(R.id.viewpagerbutton);
        imgslide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (position)
                {
                    case 0:
                        Intent intent=new  Intent(context, math_activity.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        Intent intent1=new  Intent(context, shake.class);
                        context.startActivity(intent1);


                        break;
                    case 2:
                        Data1.mode = "Simple";

                        break;

                }

            }
        });

        //layoutslide.setBackgroundColor(lst_backgroundcolor[position]);
        imgslide.setText(lst_title[position]);
        //layoutslide.setBackgroundColor(lst_backgroundcolor[position]);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }
}