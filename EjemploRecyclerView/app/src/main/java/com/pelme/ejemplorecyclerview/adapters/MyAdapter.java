package com.pelme.ejemplorecyclerview.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pelme.ejemplorecyclerview.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private int layout;
    private List<String> names;
    private OnItemClickListener itemClickListener;


    public MyAdapter(int layout, List<String> names, OnItemClickListener itemClickListener) {
        this.layout = layout;
        this.names = names;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(names.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return this.names.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tvName = itemView.findViewById(R.id.textViewName);
        }

        public void bind(final String name, final OnItemClickListener listener){
            this.tvName.setText(name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(name, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener{

        void onItemClick(String name, int position);

    }

}

