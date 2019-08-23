package com.pelme.ejemploserviceplaymusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.pelme.ejemploserviceplaymusic.services.MyService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnMusica;
    private MediaPlayer mp;
    private boolean isPlaying;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMusica = findViewById(R.id.btnMusica);
        btnMusica.setOnClickListener(this);
        //mp = MediaPlayer.create(this, R.raw.rockstar);
        //mp.setLooping(true);
    }

    @Override
    public void onClick(View view) {

        if(isPlaying){
            isPlaying = false;
            stopService(new Intent(this, MyService.class));
            this.btnMusica.setBackgroundResource(R.mipmap.play);
        }else{
            isPlaying = true;
            startService(new Intent(this, MyService.class));
            this.btnMusica.setBackgroundResource(R.mipmap.pause);
        }
        /*
        if(mp.isPlaying()){
            mp.pause();
            this.btnMusica.setBackgroundResource(R.mipmap.play);
            Toast.makeText(this, "Pausa a la musica", Toast.LENGTH_LONG).show();
        }else{
            mp.start();
            this.btnMusica.setBackgroundResource(R.mipmap.pause);
            Toast.makeText(this, "Play a la musica", Toast.LENGTH_LONG).show();
        }
        */
    }
}
