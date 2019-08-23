package com.pelme.ejemplobottomnavigation.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.pelme.ejemplobottomnavigation.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NuevoFragment extends Fragment {


    public NuevoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_nuevo, container, false);
    }

}
