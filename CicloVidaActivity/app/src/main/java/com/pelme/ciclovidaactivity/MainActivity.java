package com.pelme.ciclovidaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "Metodo onCreate");
        Toast.makeText(this, "Metodo onCreate", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MainActivity", "Metodo onStart");
        Toast.makeText(this, "Metodo onStart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MainActivity", "Metodo onResume");
        Toast.makeText(this, "Metodo onResume", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Metodo onPause", Toast.LENGTH_LONG).show();
        Log.d("MainActivity", "Metodo onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Metodo onStop", Toast.LENGTH_LONG).show();
        Log.d("MainActivity", "Metodo onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Metodo onDestroy", Toast.LENGTH_LONG).show();
        Log.d("MainActivity", "Metodo onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "Metodo onRestart", Toast.LENGTH_LONG).show();
        Log.d("MainActivity", "Metodo onRestart");
    }
}
