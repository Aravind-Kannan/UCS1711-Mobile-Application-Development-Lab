package com.k12mate.ex10;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

public class AlarmReceiver extends BroadcastReceiver {
    static MediaPlayer mp;

    @Override
    public void onReceive(Context context, Intent intent) {
        mp=MediaPlayer.create(context, R.raw.mallipoo);
        mp.start();
        Toast.makeText(context, "Alarm is Ringing Now", Toast.LENGTH_LONG).show();
    }

    public void stop(){
        mp.stop();
        mp.release();
    }
}