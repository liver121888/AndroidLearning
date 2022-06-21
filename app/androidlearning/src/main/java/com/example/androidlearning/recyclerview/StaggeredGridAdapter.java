package com.example.androidlearning.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidlearning.R;

public class StaggeredGridAdapter extends RecyclerView.Adapter<StaggeredGridAdapter.LinearViewHolder> {


    private Context mycontext;
    private OnItemClickListener mylistener;

    public StaggeredGridAdapter(Context context, OnItemClickListener listener){
        this.mycontext = context;
        this.mylistener = listener;
    }



    @NonNull
    @Override
    public StaggeredGridAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mycontext).inflate(R.layout.layout_staggeredgrid_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StaggeredGridAdapter.LinearViewHolder holder, final int position) {

        if (position%2 !=0)
            holder.imageView.setImageResource(R.drawable.michellechangescopy);
        else
            holder.imageView.setImageResource(R.drawable.samchanges);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(mycontext, "click..."+position,Toast.LENGTH_SHORT).show();
                mylistener.OnClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return 30;
    }



    class LinearViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv);
        }
    }

    public interface OnItemClickListener{
        void OnClick(int pos);
    }
}
