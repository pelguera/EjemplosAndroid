package com.pelme.ejemplotabs.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pelme.ejemplotabs.R;
import com.pelme.ejemplotabs.modelo.Persona;
import com.pelme.ejemplotabs.utils.Utils;
import com.squareup.picasso.Picasso;

import java.util.List;

public class PersonaAdapter extends RecyclerView.Adapter<PersonaAdapter.ViewHolder> {

    private int layout;
    private List<Persona> personas;

    public PersonaAdapter(int layout, List<Persona> personas) {
        this.layout = layout;
        this.personas = personas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(this.layout, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvNombrePersona.setText(this.personas.get(position).getNombrePersona());
        String url = Utils.URL_FOTO_PAIS + this.personas.get(position).getPais().getCodigo() + ".png";
        Picasso.get().load(url).into(holder.ivFotoPais);
    }

    @Override
    public int getItemCount() {
        return this.personas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivFotoPais;
        public TextView tvNombrePersona;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivFotoPais = itemView.findViewById(R.id.ivPais);
            tvNombrePersona = itemView.findViewById(R.id.tvNombrePersona);

        }

    }
}
