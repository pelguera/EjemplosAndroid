package com.pelme.ejemploserviceplaymusic.services;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import com.pelme.ejemploserviceplaymusic.R;

public class MyService extends Service {


    private MediaPlayer mp;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mp.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mp.stop();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mp = MediaPlayer.create(this, R.raw.rockstar);
        mp.setLooping(true);
    }
}
