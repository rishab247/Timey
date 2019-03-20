package rishab.listview.com.testmyapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class detailsAdapter extends RecyclerView.Adapter<detailsAdapter.detailsViewHolder> {

    private Context context;
    private List<detailsAdapter> product;

    public detailsAdapter(Context context, List<detailsAdapter> detailsAdapters) {
        this.context = context;
        this.product = detailsAdapters;
    }

    @NonNull
    @Override
    public detailsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.details_row,null);
        detailsViewHolder holder=new detailsViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull detailsViewHolder holder, int i) {

        detailsAdapter detailsAdapter=product.get(i);
       // holder.title.setText(product.getTitle());



    }

    @Override
    public int getItemCount() {
        return product.size();
    }

    class detailsViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title,showampm;

        public detailsViewHolder(@NonNull View itemView) {

            super(itemView);
            imageView=itemView.findViewById(R.id.detailsimageid);
            title=itemView.findViewById(R.id.detailstitle);
            showampm=itemView.findViewById(R.id.deailsampm);


        }
    }

}
