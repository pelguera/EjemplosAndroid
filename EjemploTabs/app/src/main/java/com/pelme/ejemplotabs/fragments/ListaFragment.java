package com.pelme.ejemplotabs.fragments;


import android.app.Person;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pelme.ejemplotabs.R;
import com.pelme.ejemplotabs.adapters.PersonaAdapter;
import com.pelme.ejemplotabs.modelo.Persona;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListaFragment extends Fragment {

    private RecyclerView rvPersonas;
    private List<Persona> listaPersonas;
    private PersonaAdapter personaAdapter;

    public ListaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_lista, container, false);
        listaPersonas = new ArrayList<Persona>();
        rvPersonas = vista.findViewById(R.id.rvPersonas);
        personaAdapter = new PersonaAdapter(R.layout.list_item_persona, listaPersonas);
        rvPersonas.setAdapter(personaAdapter);
        rvPersonas.setLayoutManager(new LinearLayoutManager(vista.getContext()));

        return vista;
    }

    public void addPersona(Persona persona){
        this.listaPersonas.add(persona);
        personaAdapter.notifyDataSetChanged();
    }

}
