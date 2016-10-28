package com.example.android.boardingpass.utilities;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;

import com.example.android.boardingpass.BoardingPassInfo;
import com.example.android.boardingpass.R;

/**
 * Will be used to determine if the user should be notified of their boarding time and to also
 * display the notification for the reminder.
 */
public class NotificationUtils {

    // If the user opens the app within 15 minutes of boarding time, we should notify them
    private static final int REMINDER_THRESHOLD_MINUTES = 15;

    // Arbitrarily chosen constant value to identify our boarding alert notification
    private static final int BOARDING_ALERT_NOTIFICATION_ID = 224422;

    public static boolean shouldNotify(BoardingPassInfo info) {
        if (info.getMinutesUntilBoarding() <= REMINDER_THRESHOLD_MINUTES) {
            return true;
        } else {
            return false;
        }
    }

    public static void notifyUser(Context context, String title, String text) {

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context)
                .setColor(ContextCompat.getColor(context, R.color.colorPrimary))
                .setSmallIcon(android.R.drawable.ic_dialog_alert)
                .setContentTitle(title)
                .setContentText(text)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(text))
                .setAutoCancel(true);

        NotificationManager notificationManager = (NotificationManager)
                context.getSystemService(Context.NOTIFICATION_SERVICE);

        /* BOARDING_ALERT_NOTIFICATION_ID allows you to update or cancel the notification later on */
        notificationManager.notify(BOARDING_ALERT_NOTIFICATION_ID, notificationBuilder.build());
    }
}