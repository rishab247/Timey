package rishab.listview.com.testmyapplication;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
public class customMyAdapter extends RecyclerView.Adapter<customMyAdapter.MyViewHolder> {

    private Context context;

    private ArrayList<Information> data;

    private LayoutInflater inflater;

    private int previousPosition = 0;

    public customMyAdapter(Context context, ArrayList<Information> data) {

        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, final int position) {

        View view = inflater.inflate(R.layout.item_layout, parent, false);


        MyViewHolder holder = new MyViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, final int position) {

        myViewHolder.detailstitle.setText(data.get(position).title);
        myViewHolder.detailssettime.setText(data.get(position).setime);
        myViewHolder.detailsampm.setText(data.get(position).ampm);
        myViewHolder.detailsmo.setText(data.get(position).mon);
        myViewHolder.detailstue.setText(data.get(position).tue);
        myViewHolder.detailsthu.setText(data.get(position).thu);
        myViewHolder.detailsfri.setText(data.get(position).fri);
        myViewHolder.detailssat.setText(data.get(position).sat);
        myViewHolder.detailssun.setText(data.get(position).sun);
        myViewHolder.detailsimage.setImageResource(data.get(position).imageId);





        previousPosition = position;


        final int currentPosition = position;
        final Information infoData = data.get(position);

        myViewHolder.detailsimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "OnClick Called at position " + position, Toast.LENGTH_SHORT).show();
                addItem(currentPosition, infoData);
            }
        });

        myViewHolder.detailsimage.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                Toast.makeText(context, "OnLongClick Called at position " + position, Toast.LENGTH_SHORT).show();

                removeItem(infoData);

                return true;
            }


        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        TextView detailstitle,detailssettime,detailsampm,detailsmo,detailstue,detailswed,detailsthu,detailsfri,detailssat,detailssun;
        ImageView detailsimage;

        public MyViewHolder(View itemView) {
            super(itemView);

            detailstitle = (TextView) itemView.findViewById(R.id.detailstitle);
            detailssettime = (TextView) itemView.findViewById(R.id.detailssettime);
            detailsampm = (TextView) itemView.findViewById(R.id.detailsampm);
            detailsmo = (TextView) itemView.findViewById(R.id.detailsmo);
            detailstue = (TextView) itemView.findViewById(R.id.detailstu);
            detailswed = (TextView) itemView.findViewById(R.id.textView);
            detailsthu = (TextView) itemView.findViewById(R.id.detailsthu);
            detailsfri = (TextView) itemView.findViewById(R.id.detailsfri);
            detailssat = (TextView) itemView.findViewById(R.id.detailssat);
            detailssun = (TextView) itemView.findViewById(R.id.detailssun);
            detailsimage = (ImageView) itemView.findViewById(R.id.detailsimage);



        }
    }

    // This removes the data from our Dataset and Updates the Recycler View.
    private void removeItem(Information infoData) {

        int currPosition = data.indexOf(infoData);
        data.remove(currPosition);
        notifyItemRemoved(currPosition);
    }

    // This method adds(duplicates) a Object (item ) to our Data set as well as Recycler View.
    private void addItem(int position, Information infoData) {

        data.add(position, infoData);
        notifyItemInserted(position);
    }
}
