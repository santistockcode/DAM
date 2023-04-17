package com.santi.ficusing.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.santi.ficusing.Plant;


import java.util.Date;
import java.util.UUID;

import com.santi.ficusing.database.PlantDbSchema.PlantTable;

//Wrapper class for Cursor that delegates all calls to the actual cursor object.
public class PlantCursorWrapper extends CursorWrapper {
    public PlantCursorWrapper(Cursor cursor) {
        super(cursor);
    }

    //Method for extractin information from relevan columns
    public Plant getPlant() {
        //Travel columns and storages data in variables
        String uuidString = getString(getColumnIndex(PlantTable.Cols.UUID));
        String name = getString(getColumnIndex(PlantTable.Cols.NAME));
        String about = getString(getColumnIndex(PlantTable.Cols.ABOUT));
        int frequency = getInt(getColumnIndex(PlantTable.Cols.FREQUENCY));
        int state = getInt(getColumnIndex(PlantTable.Cols.STATE));
        int backFrequency = getInt(getColumnIndex(PlantTable.Cols.BACK_FREQUENCY));
        long date = getLong(getColumnIndex(PlantTable.Cols.ALARM));
        //Create the new plant object to return
        Plant plant = new Plant(UUID.fromString(uuidString));
        plant.setName(name);
        plant.setAbout(about);
        plant.setFrequency(frequency);
        plant.setState(state);
        plant.setBackFrequency(backFrequency);
        plant.setAlarm(new Date(date));
        return plant;
    }
}