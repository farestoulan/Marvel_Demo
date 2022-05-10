package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.marvel_demo.R;

import java.util.List;

import ModelClasses.ListModelClass;
import ModelClasses.ThumbnailModel;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private final Context mContext;
    private final List<ListModelClass> data;

    public Adapter(Context mContext, List<ListModelClass> data) {
        this.mContext = mContext;
        this.data = data;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Glide.with(mContext)
                .load(data.get(position).getThumbnail().getPath() + "." + data.get(position).getThumbnail().getExtension())
                .into(holder.path);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView path;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            path = itemView.findViewById(R.id.imageView);

        }
    }
}
