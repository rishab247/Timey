package rishab.listview.com.testmyapplication;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class detailsAdapter extends RecyclerView.Adapter<detailsAdapter.detailsViewHolder> {

    private Context context;
    private List<details_model> productlist;

    public detailsAdapter(Context context, List<details_model> productlist) {
        this.context = context;
        this.productlist = productlist;
    }
    @Override
    public detailsViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.details_row,null);
        detailsViewHolder detailsViewHolder=new detailsViewHolder(view);
        return detailsViewHolder;
    }

    @Override
    public void onBindViewHolder(detailsViewHolder holder, int i) {

        details_model product=productlist.get(i);
        holder.title.setText(product.getTitle());
        holder.showampm.setText(product.getShowTime());
       holder.imageView.setImageDrawable(context.getResources().getDrawable(product.getImage()));

    }

    @Override
    public int getItemCount() {
        return productlist.size();
    }

    class detailsViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title,showampm;

        public detailsViewHolder(View itemView) {

            super(itemView);
            imageView=itemView.findViewById(R.id.detailsimageid);
            title=itemView.findViewById(R.id.detailstitle);
            showampm=itemView.findViewById(R.id.deailsampm);


        }
    }

}
