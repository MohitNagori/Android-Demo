package com.example.mohit.messengerdemo;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;

/**
 * Created by Mohit.
 */

public class SmsService extends IntentService {

    public static final String CHANNEL_ONE_ID = "com.example.mohit.messengerdemo.ONE";

    public SmsService() {
        super("CounterService");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        displayNotification(intent.getStringExtra("data"));
    }

    private void displayNotification(String message) {
        if (message != null) {
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ONE_ID)
                    .setSmallIcon(R.drawable.ic_notifications_none_white_24dp)
                    .setAutoCancel(true)
                    .setContentTitle(getString(R.string.app_name))
                    .setContentText(message);

            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            String otp = getOtpFromMessage(message);
            if (!otp.isEmpty()) {
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("otp", otp);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
                notificationBuilder.setContentIntent(pendingIntent);
            }

            notificationManager.notify(0, notificationBuilder.build());
        }
    }

    /*
    * work for at max four letter otp with format otp:1234
    * */
    private String getOtpFromMessage(String message) {
        String otp = "";
        if (message.contains("otp")) {
            int index = message.indexOf("otp");
            index += 4;
            try {
                otp += message.charAt(index);
            }catch ( Exception e) {
                return otp;
            }

            try {
                otp += message.charAt(index+1);
            }catch ( Exception e) {
                return otp;
            }

            try {
                otp += message.charAt(index+2);
            }catch ( Exception e) {
                return otp;
            }

            try {
                otp += message.charAt(index+3);
            }catch ( Exception e) {
                return otp;
            }
        }
        return otp;
    }
}