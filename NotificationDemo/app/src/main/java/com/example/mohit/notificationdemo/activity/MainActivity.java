package com.example.mohit.notificationdemo.activity;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.mohit.notificationdemo.util.NotificationID;
import com.example.mohit.notificationdemo.R;
import com.example.mohit.notificationdemo.service.CounterService;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent(this, CounterService.class);
        startService(intent);
    }

    void initChannels(Context context) {
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationChannel channel = new NotificationChannel("default",
                "NOTIFICATION_DEMO_CHANNEL",
                NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription("Notification Demo Channel description");
        if (notificationManager != null) {
            notificationManager.createNotificationChannel(channel);
        }
    }

    public void displayNotification(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        initChannels(getApplicationContext());
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext(), "default")
                .setSmallIcon(R.drawable.ic_notifications_none_white_24dp)
                .setAutoCancel(true)
                .setContentTitle(getString(R.string.app_name))
                .setContentText("Local Notification")
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(NotificationID.getID(), notificationBuilder.build());
    }
}
