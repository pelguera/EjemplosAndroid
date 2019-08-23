package com.pelme.ejemplobroadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvMensaje;
    private IntentFilter cargandoIntentFilter;
    private ChargingBroadcastReceiver chargingBroadcastReceiver;

    public static final String CHANNEL_HIGH = "Canal01";
    public static final String CHANNEL_LOW = "Canal02";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMensaje = findViewById(R.id.tvMensaje);
        chargingBroadcastReceiver = new ChargingBroadcastReceiver();
        cargandoIntentFilter = new IntentFilter();
        cargandoIntentFilter.addAction(Intent.ACTION_POWER_CONNECTED);

    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(this.chargingBroadcastReceiver, this.cargandoIntentFilter);
        createNotificationChannel();
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(this.chargingBroadcastReceiver);
    }

    private void createNotificationChannel(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){

            NotificationChannel notificacionAlta = new NotificationChannel(CHANNEL_HIGH,
                    "CanalAltaImportancia", NotificationManager.IMPORTANCE_HIGH);
            notificacionAlta.setDescription("Importancia Alta");


            NotificationChannel notificacionBaja = new NotificationChannel(CHANNEL_LOW,
                    "CanalBajaImportancia", NotificationManager.IMPORTANCE_LOW);
            notificacionBaja.setDescription("Importancia Baja");

            NotificationManager manager= getSystemService(NotificationManager.class);
            manager.createNotificationChannel(notificacionAlta);
            manager.createNotificationChannel(notificacionBaja);
        }

    }
}
