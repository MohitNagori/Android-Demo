package com.example.mohit.messengerdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;

/**
 * Created by Mohit.
 */

public class IncomingSms extends BroadcastReceiver {

        // Get the object of SmsManager
    final SmsManager sms = SmsManager.getDefault();

    public void onReceive(Context context, Intent intent) {

        // Retrieves a map of extended data from the intent.
        final Bundle bundle = intent.getExtras();

        try {
            if (bundle != null) {
                final Object[] pdusObj = (Object[]) bundle.get("pdus");

                for (int i = 0; i < pdusObj.length; i++) {

                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);

                    String senderNum = currentMessage.getDisplayOriginatingAddress();
                    String message = currentMessage.getDisplayMessageBody();

                    Intent serviceIntent = new Intent(context, SmsService.class);
                    serviceIntent.putExtra("data", "SenderNum: "+ senderNum + "\n Message: " + message);
                    context.startService(serviceIntent);

                    /*Log.i("SmsReceiver", "SenderNum: "+ senderNum + "\n Message: " + message);
                    // Show Alert
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context,"senderNum: "+ senderNum + ", message: " + message, duration);
                    toast.show();*/
                }
            }
        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" +e);
        }
    }
}