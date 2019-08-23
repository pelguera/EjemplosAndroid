package com.pelme.ejemplohilos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar progressBar;
    private Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = findViewById(R.id.progress);
        btnIniciar = findViewById(R.id.btnIniciar);
    }



    private class TareaPesada extends AsyncTask<Void, Integer, Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }
}
