package com.pelme.fragmentsdinamicos.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pelme.fragmentsdinamicos.R;
import com.pelme.fragmentsdinamicos.adapters.PeliculaAdapter;
import com.pelme.fragmentsdinamicos.modelo.Pelicula;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaFragment extends Fragment {

    private RecyclerView rvListaPeliculas;
    private List<Pelicula> peliculas;
    private OnFragmentInteractionListener mListener;

    public ListaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lista, container, false);
        rvListaPeliculas = view.findViewById(R.id.rvListaPeliculas);
        llenarDatos();
        PeliculaAdapter adapter = new PeliculaAdapter(R.layout.recycler_list_item, this.peliculas, new PeliculaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Pelicula pelicula, int position) {
                mListener.onListClick(pelicula);
            }
        });
        rvListaPeliculas.setLayoutManager(new LinearLayoutManager(view.getContext()));
        rvListaPeliculas.setAdapter(adapter);
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnFragmentInteractionListener){
            mListener = (OnFragmentInteractionListener) context;
        }else{
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void llenarDatos(){
        this.peliculas = new ArrayList<Pelicula>();

        Pelicula pelicula = new Pelicula("Aladino", R.mipmap.aladdin, "Comedia", "2:14", "");
        this.peliculas.add(pelicula);

        pelicula = new Pelicula("Avengers Infinity war", R.mipmap.infinitywar, "Accion", "2:54", "");
        this.peliculas.add(pelicula);

        pelicula = new Pelicula("Dumbo", R.mipmap.dumbo, "Comedia", "1:48", "");
        this.peliculas.add(pelicula);

        pelicula = new Pelicula("Glass", R.mipmap.glass, "Accion - Suspenso", "2:23", "");
        this.peliculas.add(pelicula);

    }

    public interface OnFragmentInteractionListener{
        void onListClick(Pelicula pelicula);
    }
}
