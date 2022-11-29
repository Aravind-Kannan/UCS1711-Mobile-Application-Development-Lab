package com.k12mate.ex10;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import java.util.Calendar;
import java.time.OffsetTime;

public class MainActivity extends AppCompatActivity {
    Button start;
    Button stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start= findViewById(R.id.button);
        stop= findViewById(R.id.button1);

        start.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                startAlert();
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                stop();
            }
        });


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public void startAlert(){

        TimePicker timePicker;
        timePicker = (TimePicker) findViewById(R.id.timePicker1);

        int hour_t = timePicker.getCurrentHour();
        int min_t = timePicker.getCurrentMinute();

        System.out.println("Hour T:" + hour_t);
        System.out.println("Minute T:" + min_t);

        long sec_t = hour_t * 60 * 60 + min_t * 60;
        sec_t = sec_t * 1000;

        OffsetTime time = OffsetTime.now();
        long hour_s = time.getHour();
        long min_s = time.getMinute();
        long sec_s1 = time.getSecond();

        System.out.println("Hour S:" + hour_s);
        System.out.println("Minute S:" + min_s);
        System.out.println("Second S:" + sec_s1);

        long sec_s = hour_s * 60 * 60 + min_s * 60;
        System.out.println("Before Seconds::"+sec_s);
        sec_s += sec_s1;
        sec_s = sec_s * 1000;

        long sec_d;

        System.out.println("Seconds T:" + sec_t);
        System.out.println("Seconds S:" + sec_s);

        sec_d = sec_t - sec_s;

        System.out.println(sec_d/1000);

        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this.getApplicationContext(), 234324243, intent, PendingIntent.FLAG_IMMUTABLE);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (sec_d), pendingIntent);
        Toast.makeText(this, "Alarm set",Toast.LENGTH_LONG).show();
    }

    public void stop() {
        AlarmReceiver ar = new AlarmReceiver();
        ar.stop();
    }
}