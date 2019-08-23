package com.pelme.ejemplorecyclerviewpersonalizado.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pelme.ejemplorecyclerviewpersonalizado.R;
import com.pelme.ejemplorecyclerviewpersonalizado.modelo.Contactos;

import java.util.List;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.ViewHolder>{

    private int layout;
    private List<Contactos> listaContactos;
    private OnItemClickListener itemClickListener;

    public ContactoAdapter(int layout, List<Contactos> listaContactos, OnItemClickListener itemClickListener) {
        this.layout = layout;
        this.listaContactos = listaContactos;
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
        holder.bind(listaContactos.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return listaContactos.size();
    }

    public interface OnItemClickListener{
        void onItemClick(Contactos contacto, int position);
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvNombre;
        public TextView tvDescripcion;
        public ImageView ivFoto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombre = itemView.findViewById(R.id.tvNombre);
            tvDescripcion = itemView.findViewById(R.id.tvDescripcion);
            ivFoto = itemView.findViewById(R.id.ivFoto);
        }

        public void bind(final Contactos contacto, final OnItemClickListener listener){
            tvNombre.setText(contacto.getNombre());
            tvDescripcion.setText(contacto.getDescripcion());
            ivFoto.setImageResource(contacto.getIdFoto());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(contacto, getAdapterPosition());
                }
            });
        }
    }


}
