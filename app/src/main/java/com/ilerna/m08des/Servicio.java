package com.ilerna.m08des;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

public class Servicio extends Service {

    MediaPlayer player;

    public Servicio() {
        //Según la Videotutoría no hace falta pero lo dejo
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(getApplicationContext(),"Iniciando música",Toast.LENGTH_SHORT).show();

        if(player!=null && player.isPlaying()){
            player.stop();
        }

        player = MediaPlayer.create(this,R.raw.wizard);
        player.setVolume(100,100);
        player.setLooping(true);
        player.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"Parando Música",Toast.LENGTH_SHORT).show();

        if(player !=null){
            player.release();
        }
        stopSelf();

    }
}
