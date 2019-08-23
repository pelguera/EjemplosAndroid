package com.pelme.fragmentsdinamicos.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pelme.fragmentsdinamicos.R;
import com.pelme.fragmentsdinamicos.modelo.Pelicula;

import java.util.List;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.ViewHolder> {

    private int layout;
    private List<Pelicula> listaPeliculas;
    private OnItemClickListener listener;

    public PeliculaAdapter(int layout, List<Pelicula> listaPeliculas, OnItemClickListener listener) {
        this.layout = layout;
        this.listaPeliculas = listaPeliculas;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(this.layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(this.listaPeliculas.get(position), this.listener);
    }

    @Override
    public int getItemCount() {
        return this.listaPeliculas.size();
    }

    //inner class de tipo ViewHolder, sirve para implementar el patron del mismo nombre
    public static class ViewHolder extends RecyclerView.ViewHolder {
        //aca declaro todos los componentes del card_view_item
        public TextView tvTitulo;
        public TextView tvDuracion;
        public ImageView ivPoster;

        //en el constructor instancio todos los componentes
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitulo = itemView.findViewById(R.id.tvTituloPelicula);
            tvDuracion = itemView.findViewById(R.id.tvDuracionPelcula);
            ivPoster = itemView.findViewById(R.id.ivPosterPelicula);
        }

        //este metodo es creado para setear la información del objeto en los respectivos componentes
        //es llamado desde el metodo onBindViewHolder
        public void bind(final Pelicula pelicula, final OnItemClickListener itemClickListener){
            tvTitulo.setText(pelicula.getNombre());
            tvDuracion.setText(pelicula.getDuracion());
            ivPoster.setImageResource(pelicula.getFoto());
            itemView.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    itemClickListener.onItemClick(pelicula, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener{
        void onItemClick(Pelicula pelicula, int position);
    }
}
