package com.pelme.consumoservicioscardview.adapters;

import android.animation.LayoutTransition;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pelme.consumoservicioscardview.R;
import com.pelme.consumoservicioscardview.modelo.Heroe;
import com.squareup.picasso.Picasso;

import java.util.List;


public class SuperHeroAdapter extends RecyclerView.Adapter<SuperHeroAdapter.ViewHolder> {

    private int layout;
    private List<Heroe> listaHeroes;

    public SuperHeroAdapter(int layout, List<Heroe> listaHeroes) {
        this.layout = layout;
        this.listaHeroes = listaHeroes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(this.layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(this.listaHeroes.get(position));
        Log.d("MainActivity", "imagen: " + this.listaHeroes.get(position).getImagen().getUrl());
    }

    @Override
    public int getItemCount() {
        return this.listaHeroes.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvNombreHeroe;
        ImageView ivFotoHeroe;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvNombreHeroe = itemView.findViewById(R.id.tvNombreHeroe);
            ivFotoHeroe = itemView.findViewById(R.id.ivHeroe);
        }

        public void bind(final Heroe heroe){
            tvNombreHeroe.setText(heroe.getName());
            Picasso.with(itemView.getContext()).load(heroe.getImagen().getUrl()).into(ivFotoHeroe);
        }
    }
}
