package com.pelme.fragments.fragments;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.pelme.fragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends Fragment {

    private EditText etDato;
    private Button btnEnviar;
    private DataListener callback;

    public DataFragment() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try{
            callback = (DataListener) context;
        }catch (Exception e){

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_data, container, false);

        etDato = (EditText) vista.findViewById(R.id.etDato);
        btnEnviar = (Button) vista.findViewById(R.id.btnEnviar);
        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String texto = etDato.getText().toString();
                callback.sendData(texto);
            }
        });

        return vista;
    }


    public interface DataListener{
        void sendData(String texto);
    }
}
