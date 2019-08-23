package com.pelme.ejemplotabs.fragments;


import android.app.Person;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.pelme.ejemplotabs.MainActivity;
import com.pelme.ejemplotabs.R;
import com.pelme.ejemplotabs.modelo.Pais;
import com.pelme.ejemplotabs.modelo.Persona;
import com.pelme.ejemplotabs.utils.Utils;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class IngresoFragment extends Fragment implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    private EditText etNombrePersona;
    private Spinner spPais;
    private Button btnGrabar;

    private Pais pais;
    private List<Pais> paises;
    private personaInterface ipersona;

    public IngresoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof personaInterface){
            ipersona = (personaInterface)context;
        }else{
            throw new RuntimeException(context.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_ingreso, container, false);
        etNombrePersona = vista.findViewById(R.id.etContacto);
        spPais = vista.findViewById(R.id.spPais);
        btnGrabar = vista.findViewById(R.id.btnGrabar);
        btnGrabar.setOnClickListener(this);
        paises = Utils.getPaises();

        ArrayAdapter<Pais> adapterPais = new ArrayAdapter<Pais>(getContext(),
                                                                android.R.layout.simple_spinner_dropdown_item,
                                                                paises);
        spPais.setAdapter(adapterPais);
        spPais.setOnItemSelectedListener(this);
        return vista;
    }

    @Override
    public void onClick(View view) {
        if(!etNombrePersona.getText().toString().isEmpty()){
            Persona persona = new Persona(etNombrePersona.getText().toString(), (Pais) spPais.getSelectedItem());
            ipersona.addPersona(persona);
        }else{
            Toast.makeText(getContext(), "Ingrese el nombre de la Persona", Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //this.pais = this.spPais.getSelectedItem();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public interface personaInterface{
        void addPersona(Persona persona);
    }
}
