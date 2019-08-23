package com.pelme.ejemplobroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class ChargingBroadcastReceiver extends BroadcastReceiver {

    private static final String MENSAJE = "Cargador conectado";
    private static final String TITULO = "Notificacion";

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)){
            Toast.makeText(context, "Se reconocio el broadcast", Toast.LENGTH_SHORT).show();
            this.crearNotificacion(context,false);
        }

    }

    private void crearNotificacion(Context context, boolean esImportante){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            if(esImportante)
                mostrarNotificacionConCanal(context, MainActivity.CHANNEL_HIGH);
            else
                mostrarNotificacionConCanal(context, MainActivity.CHANNEL_LOW);
        }else{
            mostrarNotificacionSinCanal(context);
        }
    }

    private void mostrarNotificacionConCanal(Context context, String idChannel){
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context, idChannel)
                        .setSmallIcon(R.drawable.ic_notifications)
                        .setContentTitle(TITULO)
                        .setContentText(MENSAJE);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
        managerCompat.notify(0, builder.build());
    }

    private void mostrarNotificacionSinCanal(Context context){
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(context)
                        .setSmallIcon(R.drawable.ic_notifications)
                        .setContentTitle(TITULO)
                        .setContentText(MENSAJE);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
        managerCompat.notify(1, builder.build());
    }

}
