package com.example.androidlearning.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidlearning.R;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.LinearViewHolder> {


    private Context mycontext;
    private OnItemClickListener mylistener;

    public GridAdapter(Context context, OnItemClickListener listener){
        this.mycontext = context;
        this.mylistener = listener;
    }



    @NonNull
    @Override
    public GridAdapter.LinearViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LinearViewHolder(LayoutInflater.from(mycontext).inflate(R.layout.layout_hor_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull GridAdapter.LinearViewHolder holder, final int position) {

        holder.textView.setText("Hey");
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
        return 80;
    }



    class LinearViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public LinearViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv_title);
        }
    }

    public interface OnItemClickListener{
        void OnClick(int pos);
    }
}
