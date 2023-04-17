package com.santi.ficusing;

import android.app.Application;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.Log;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

//Class to handle background action, ie, update frequency daily and check if it's time to water
public class LaDaily {
    //Tag for log this class
    private static final String TAG = "LADAILY";

    //Method that checks whether it's time to water and update dates according to backFrequency
    public boolean checkingDry() {
        PlantLab plantLab = PlantLab.get(App.getContext());
        //List all plant objects
        List<Plant> plants = plantLab.getPlants();
        //Strings list for names to display in the notification
        List<String> plantsToShow = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();
        int day_today = calendar.get(Calendar.DAY_OF_MONTH);
        int month_today = calendar.get(Calendar.MONTH);
        if (!plants.isEmpty()) {
            Log.i(TAG, "Recorriendo db: ");
            for (int i = 0; i < plants.size(); i++) {
                //day and month for the each plant
                Date date = plants.get(i).getAlarm();
                //Checks if today it's the day for watering
                if ((date.getDate()) == day_today &&
                        date.getMonth() == (month_today)) {
                    //Plant name to show in the notification
                    plantsToShow.add(plants.get(i).getName());
                    Log.i("LADAILY", "Añadida: " + plants.get(i).getName());
                    //Update object plant with new day to water
                    Plant mPlant = plants.get(i);
                    int backFrequency = plants.get(i).getBackFrequency();
                    Calendar calendar_plant = Calendar.getInstance();
                    calendar_plant.add(Calendar.DATE, backFrequency);
                    mPlant.setAlarm(calendar_plant.getTime());
                    plantLab.updatePlant(mPlant);
                }
            }
            //Since a day has passed, all plants need to update their frequency and state
            for (int i = 0; i < plants.size(); i++) {
                Plant mPlant = plants.get(i);
                int frequency = plants.get(i).getFrequency();
                if (frequency != 0) {
                    frequency--;
                    mPlant.setFrequency(frequency);
                }
                if (frequency == 0) {
                    mPlant.setState(0);
                }
                plantLab.updatePlant(mPlant);
            }
        }
        if (!plantsToShow.isEmpty()) {
            Log.i(TAG, "Lanzando notificación: ");
            //send Notification method
            sendNotes(getStringPlants(plantsToShow));
        }

        return true;
    }

    //Method to format the names to display on the notification
    private String getStringPlants(List<String> plantsToShow) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < plantsToShow.size(); i++) {
            sb.append(plantsToShow.get(i).toUpperCase(Locale.ROOT));
            sb.append(";");
        }
        String str = sb.toString();
        return str;
    }

    //Method to send Notification
    private void sendNotes(String list_of_plants) {
        Resources resources = App.getApplication().getResources();
        //Intent with no extras: from notification to PlantListActivity
        Intent i = new Intent(App.getContext(), PlantListActivity.class);
        i.setAction("FROM_NOWHERE");
        PendingIntent pi = PendingIntent.getActivity(App.getContext(), 0, i, 0);
        //Same intent for action Pass, extra_key = 0
        Intent iPass = new Intent(App.getContext(), PlantListActivity.class);
        iPass.setAction("FROM_PASS");
        iPass.putExtra("extra_key", 0);
        PendingIntent piP = PendingIntent.getActivity(App.getContext(), 1, iPass, 0);
        //Same intent for action Snooze, extra_key = 1
        Intent iSnooze = new Intent(App.getContext(), PlantListActivity.class);
        iSnooze.setAction("FROM_SNOOZE");
        iSnooze.putExtra("extra_key", 1);
        PendingIntent piS = PendingIntent.getActivity(App.getContext(), 2, iSnooze, 0);
        //Same intent for action Done, extra_key = 2
        Intent iDone = new Intent(App.getContext(), PlantListActivity.class);
        iDone.setAction("FROM_DONE");
        iDone.putExtra("extra_key", 2);
        PendingIntent piD = PendingIntent.getActivity(App.getContext(), 3, iDone, 0);
        //Builds notification and sends it.
        Notification notification = new NotificationCompat.Builder(App.getContext())
                .setTicker(resources.getString(R.string.app_name))
                .setSmallIcon(android.R.drawable.ic_menu_agenda)
                .setContentTitle(resources.getString(R.string.app_name))
                .setContentText(resources.getString(R.string.message_not) + list_of_plants)
                .setContentIntent(pi)
                .addAction(R.drawable.ic_add, "PASS",
                        piP)
                .addAction(R.drawable.ic_add, "SNOOZE",
                        piS)
                .addAction(R.drawable.ic_add, "DONE",
                        piD)
                .setAutoCancel(true)
                .build();
        NotificationManagerCompat notificationManager =
                NotificationManagerCompat.from(App.getContext());
        notificationManager.notify(0, notification);

    }
}
