package Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.marvel_demo.MainFragment;
import com.example.marvel_demo.R;

import java.util.List;

import ModelClasses.ListModelClass;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private final Context mContext;
    private final List<ListModelClass> data;

    private ItemClickListener mClickListener;


    public Adapter(Context mContext, List<ListModelClass> data) {
        this.mContext = mContext;
        this.data = data;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.fragment_item_list, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

       // holder.description.setText(data.get(position).getDescription());

        Glide.with(mContext)
                .load(data.get(position).getThumbnail().getPath() + "." + data.get(position).getThumbnail().getExtension())
                .into(holder.path);


       // Log.i("onBindViewHolder", data.get(position).getDescription());
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
    @Override
    public int getItemCount() {
        return data.size();
    }
    public   void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView path;
        TextView description;


        public  MyViewHolder(@NonNull View itemView) {
            super(itemView);

            path = itemView.findViewById(R.id.imageView);
            description = itemView.findViewById(R.id.tv_Description);
            itemView.setOnClickListener(this);



        }

        @Override
        public void onClick(View view) {


           // navController.navigate(R.id.action_mainFragment_to_descriptionFragment);
            if (mClickListener != null) mClickListener.onItemClick(view, getAbsoluteAdapterPosition());

        }







    }
}
