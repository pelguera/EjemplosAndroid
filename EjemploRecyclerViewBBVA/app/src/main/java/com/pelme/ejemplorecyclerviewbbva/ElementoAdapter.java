package com.pelme.ejemplorecyclerviewbbva;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ElementoAdapter extends RecyclerView.Adapter<ElementoAdapter.ViewHolder> {

    private int layout;
    private List<Contacto> listado;

    public ElementoAdapter(int layout, List<Contacto> listado) {
        this.layout = layout;
        this.listado = listado;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(this.layout, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.ivFoto.setImageResource(this.listado.get(position).getIdFoto());
        holder.tvNombre.setText(this.listado.get(position).getNombreContacto());
    }

    @Override
    public int getItemCount() {
        return this.listado.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivFoto;
        private TextView tvNombre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            ivFoto = itemView.findViewById(R.id.ivFoto);
            tvNombre = itemView.findViewById(R.id.tvNombre);

        }
    }
}
