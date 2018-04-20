package com.example.mohit.notificationdemo.service;

import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.example.mohit.notificationdemo.util.NotificationID;
import com.example.mohit.notificationdemo.R;

/**
 * Created by Mohit on 11/8/2017.
 */

public class CounterService extends IntentService {

    public CounterService() {
        super("CounterService");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        for (int count = 1; count < 4; count++) {
            //one minute is 60*1000
            try {
                Thread.sleep(60 * 1000);
                displayNotification(count);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
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


    private void displayNotification(int count) {
        initChannels(getApplicationContext());
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext(), "default")
                .setSmallIcon(R.drawable.ic_notifications_none_white_24dp)
                .setAutoCancel(true)
                .setContentTitle(getString(R.string.app_name))
                .setContentText("Background Service Notification " +  count);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(NotificationID.getID(), notificationBuilder.build());
    }
}