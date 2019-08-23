package com.pelme.fragmentsdinamicos.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.pelme.fragmentsdinamicos.R;
import com.pelme.fragmentsdinamicos.modelo.Pelicula;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetalleFragment extends Fragment {

    private TextView tvTitulo, tvDescripcion, tvTipo, tvDuracion;
    private ImageView ivPoster;

    public DetalleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_detalle, container, false);

        tvTitulo = view.findViewById(R.id.tvTituloPelicula);
        tvDescripcion = view.findViewById(R.id.tvDescripcionPelicula);
        tvTipo = view.findViewById(R.id.tvTipoPelicula);
        tvDuracion = view.findViewById(R.id.tvDuracionPelcula);
        ivPoster = view.findViewById(R.id.ivPosterPelicula);

        return view;
    }


    public void renderizarPelicula(Pelicula pelicula){
        ivPoster.setImageResource(pelicula.getFoto());
        tvTitulo.setText(pelicula.getNombre());
        tvDescripcion.setText(pelicula.getDescripcion());
        tvTipo.setText(pelicula.getTipo());
        tvDuracion.setText(pelicula.getDuracion());
    }
}
