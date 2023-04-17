package com.santi.ficusing;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

//Class to set and manage service for alarm manager and notifications
public class PollService extends IntentService {
    //Constant for log this class
    private static final String TAG = "PollService";
    //Constant for repeting alarm at 1 minute, only for testing.
    //private static final long POLL_INTERVAL_MS = TimeUnit.MINUTES.toMillis(1);

    //intent for calling this class everytime the alarm goes
    public static Intent newIntent(Context context) {
        return new Intent(context, PollService.class);
    }

    public PollService() {
        super(TAG);
    }

    //Method to set alarm at certain hour passed by parameter
    public static void setServiceAlarm(Context context, boolean isOn, Date fecha) {
        Intent i = PollService.newIntent(context);
        PendingIntent pi = PendingIntent.getService(context, 0, i, 0);
        AlarmManager alarmManager = (AlarmManager)
                context.getSystemService(Context.ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, fecha.getHours());
        calendar.set(Calendar.MINUTE, fecha.getMinutes());
        //If time has already passed, the alarm is set for tomorrow, otherwise it would never
        if (calendar.getTimeInMillis() - Calendar.getInstance().getTimeInMillis() <= 0) {
            calendar.add(Calendar.DATE, 1);
        }
        //POLL_INTERNAL_MS for testing instead of AlarmManager.INTERVAL_DAY
        if (isOn) {
            alarmManager.setInexactRepeating(alarmManager.RTC_WAKEUP,
                    calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, pi);
        } else {
            alarmManager.cancel(pi);
            pi.cancel();
        }

    }

    //Method to hanlde intents
    @SuppressLint("WrongThread")
    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(TAG, "Received an intent at time perfect so i'm gonna try to async chore " + intent);
        new SecondTask().execute();
    }

    //Class to work with a background thread, which creates a background thread and runs it.
    private class SecondTask extends AsyncTask<Void, Void, Void> {
        //Method to run the background thread.
        @Override
        protected Void doInBackground(Void... params) {
            try {
                Boolean result = new LaDaily().checkingDry();
                Log.i(TAG, "Doing background and it went: " + result
                );
            } catch (Exception ioe) { //why ioexception ONLY TESTING
                Log.e(TAG, "Failed to access db: ", ioe);
            }
            return null;
        }
    }

    //chekc if the alarm is on and cancel it
    public static boolean isServiceAlarmOn(Context context) {
        Intent i = PollService.newIntent(context);
        PendingIntent pi = PendingIntent
                .getService(context, 0, i, PendingIntent.FLAG_NO_CREATE);
        return pi != null;
    }
}
