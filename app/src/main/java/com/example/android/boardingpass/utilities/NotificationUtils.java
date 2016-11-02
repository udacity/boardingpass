package com.example.android.boardingpass.utilities;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v4.content.ContextCompat;

import com.example.android.boardingpass.MainActivity;
import com.example.android.boardingpass.R;

/**
 * Will be used to determine if the user should be notified of their boarding time and to also
 * display the notification for the reminder.
 */
public class NotificationUtils {

    // COMPLETED (1) create a constant number to identify the notification you are about to create
    // Arbitrarily chosen constant value to identify our boarding alert notification
    private static final int BOARDING_ALERT_NOTIFICATION_ID = 224422;


    public static void notifyUser(Context context, String title, String text) {

        // COMPLETED (2) Create a notification builder with the correct context
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                // COMPLETED (3) Set the notification color to ContextCompat's colorPrimary
                .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
                // COMPLETED (4) Set the small Icon to android.R.drawable.ic_dialog_alert
                .setSmallIcon(android.R.drawable.ic_dialog_alert)
                // COMPLETED (5) Set the title to the passed in argument title
                .setContentTitle(title)
                // COMPLETED (6) Set the text to the passed in argument text
                .setContentText(text)
                // COMPLETED (7) Set the auto cancel to true
                .setAutoCancel(true);


        // COMPLETED (8) Create an intent that directs to MainActivity
        Intent notificationIntent = new Intent(context, MainActivity.class);
        // COMPLETED (9) Create a taskStackBuilder and add the intent using addNextIntentWithParentStack
        TaskStackBuilder taskStackBuilder = TaskStackBuilder.create(context);
        taskStackBuilder.addNextIntentWithParentStack(notificationIntent);
        // COMPLETED (10) Create a Pending intent from the taskStackBuilder
        PendingIntent pIntent = taskStackBuilder
                .getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        // COMPLETED (11) Set the notificationBuilder's content intent to the pending intent
        notificationBuilder.setContentIntent(pIntent);

        // COMPLETED (12) Create a notification manager from context.getSystemService
        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        // COMPLETED (13) Show the notification using notify
        /* BOARDING_ALERT_NOTIFICATION_ID allows you to update or cancel the notification later on */
        notificationManager.notify(BOARDING_ALERT_NOTIFICATION_ID, notificationBuilder.build());
    }
}