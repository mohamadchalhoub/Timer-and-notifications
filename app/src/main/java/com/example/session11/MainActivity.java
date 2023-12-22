package com.example.session11;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.provider.AlarmClock;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText Tnumber;
Button start, hide;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tnumber=(EditText) findViewById(R.id.IntSeconds);
        start=(Button) findViewById(R.id.Start);
        hide=(Button) findViewById(R.id.btnHide);
        Tnumber.setVisibility(View.GONE);
        start.setVisibility(View.GONE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel("Notification One", "Notification one", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

    public void HideT(View view) {
        Tnumber.setVisibility(View.GONE);
        start.setVisibility(View.GONE);
    }

    public void ShowT(View view) {
        Tnumber.setVisibility(View.VISIBLE);
        start.setVisibility(View.VISIBLE);
    }

    public void StartT(View view) {
        Integer nb = Integer.parseInt(Tnumber.getText().toString());
        Intent intentTimer = new Intent(AlarmClock.ACTION_SET_TIMER)
                .putExtra(AlarmClock.EXTRA_MESSAGE, "wait time")
                .putExtra(AlarmClock.EXTRA_LENGTH, nb)
                .putExtra(AlarmClock.EXTRA_SKIP_UI, false);
        startActivity(intentTimer);
    }

    public void Notification(View view) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainActivity.this, "Notification One");
                builder.setContentTitle("Hello there");
                builder.setSmallIcon(R.drawable.th);
                builder.setAutoCancel(true);
        NotificationManagerCompat NM=NotificationManagerCompat.from(MainActivity.this);
        NM.notify(1, builder.build());
    }
}