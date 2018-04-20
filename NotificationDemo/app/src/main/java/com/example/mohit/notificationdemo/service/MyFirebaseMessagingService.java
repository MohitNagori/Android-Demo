package com.example.mohit.notificationdemo.service;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.example.mohit.notificationdemo.R;
import com.example.mohit.notificationdemo.activity.MainActivity;
import com.example.mohit.notificationdemo.util.NotificationID;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

/**
 * Created by Mohit.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "1234";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        String body = "";

        Log.d(TAG, remoteMessage.getFrom());

        if (remoteMessage.getNotification() != null) {
            body = remoteMessage.getNotification().getBody();
            Log.d(TAG, body);
        }

        displayNotification(remoteMessage.getFrom(), body);
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

    private void displayNotification(String title, String body) {
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        initChannels(getApplicationContext());
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext(), "default")
                .setSmallIcon(R.drawable.ic_notifications_none_white_24dp)
                .setAutoCancel(true)
                .setContentTitle("Push Notification")
                .setContentText(body)
                .setSound(defaultSoundUri)
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(NotificationID.getID(), notificationBuilder.build());
    }
}
