package com.pelme.fragments.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;

import com.pelme.fragments.R;
import com.pelme.fragments.fragments.DataFragment;
import com.pelme.fragments.fragments.DetailFragment;

public class MainActivity extends AppCompatActivity implements DataFragment.DataListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void sendData(String texto) {

        DetailFragment detailFragment = (DetailFragment) getSupportFragmentManager().findFragmentById(R.id.fmDetail);
        detailFragment.renderText(texto);
    }
}
