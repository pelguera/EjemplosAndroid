package com.pelme.fragments.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.pelme.fragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    private TextView tvData;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vista = inflater.inflate(R.layout.fragment_detail, container, false);

        tvData = (TextView) vista.findViewById(R.id.tvData);
        return vista;
    }

    public void renderText(String texto){
        this.tvData.setText(texto);
    }

}
