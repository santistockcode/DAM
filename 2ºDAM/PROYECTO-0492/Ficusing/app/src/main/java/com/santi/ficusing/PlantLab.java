package com.santi.ficusing;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.santi.ficusing.database.PlantCursorWrapper;
import com.santi.ficusing.database.PlantBaseHelper;
import com.santi.ficusing.database.PlantDbSchema;
import com.santi.ficusing.database.PlantDbSchema.PlantTable;


import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

//Centralized data stash for Plant objects
public class PlantLab {

    private static PlantLab sPlantLab;
    private Context mContext;
    private SQLiteDatabase mDatabase;

    //Constructor for singleton
    private PlantLab(Context context) {
        mContext = context.getApplicationContext();
        //Opens plantBase.db and creates the db if it's opened for the first time,
        //If it's not, it checks for version and upgrades it if necessary
        mDatabase = new PlantBaseHelper(mContext).getWritableDatabase();
    }

    //Method to get a list of Plant objects from the db
    public List<Plant> getPlants() {
        List<Plant> plants = new ArrayList<>();
        PlantCursorWrapper cursor = queryPlants(null, null);
        try {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                plants.add(cursor.getPlant());
                cursor.moveToNext();
            }
        } finally {
            cursor.close();
        }
        return plants;
    }

    //Method to get one Plant from the db
    public Plant getPlant(UUID id) {

        PlantCursorWrapper cursor = queryPlants(
                PlantTable.Cols.UUID + " = ?",
                new String[]{id.toString()}
        );
        try {
            if (cursor.getCount() == 0) {
                return null;
            }
            cursor.moveToFirst();
            return cursor.getPlant();
        } finally {
            cursor.close();
        }
    }

    //Get for singleton design pattern
    public static PlantLab get(Context context) {
        if (sPlantLab == null) {
            sPlantLab = new PlantLab(context);
        }
        return sPlantLab;
    }

    //Metodo que se encarga de pasar un Plant a una instancia de ContentValues
    private static ContentValues getContentValues(Plant plant) {
        ContentValues values = new ContentValues();
        values.put(PlantTable.Cols.UUID, plant.getId().toString());
        values.put(PlantTable.Cols.NAME, plant.getName());
        values.put(PlantTable.Cols.ABOUT, plant.getAbout());
        values.put(PlantTable.Cols.FREQUENCY, plant.getFrequency());
        values.put(PlantTable.Cols.STATE, plant.getState());
        values.put(PlantTable.Cols.BACK_FREQUENCY, plant.getBackFrequency());
        values.put(PlantTable.Cols.ALARM, plant.getAlarm().getTime());
        return values;
    }

    //Method to add plant to db according to values in content values.
    public void addPlant(Plant p) {
        ContentValues values = getContentValues(p);
        mDatabase.insert(PlantTable.NAME, null, values);
    }

    //Metodo para actualizar a plant
    public void updatePlant(Plant plant) {
        String uuidString = plant.getId().toString();
        ContentValues values = getContentValues(plant);
        mDatabase.update(PlantTable.NAME, values,
                PlantTable.Cols.UUID + " = ?",
                new String[]{uuidString});
    }

    /*private Cursor queryPlants(String whereClause, String[] whereArgs)*/
    private PlantCursorWrapper queryPlants(String whereClause, String[] whereArgs) {
        Cursor cursor = mDatabase.query(
                PlantTable.NAME,
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
        //return cursor;
        return new PlantCursorWrapper(cursor);
    }

    //Metodo para proporcionar una ruta de almacenamiento para la foto
    public File getPhotoFile(Plant plant) {
        File filesDir = mContext.getFilesDir();
        return new File(filesDir, plant.getPhotoFilename());
    }

    //Method for deleting plant
    public void delete(Plant p) {
        ContentValues values = getContentValues(p);
        //aquí se construye la sentencia sql, en el "?" se construye la id (fuente:https://stackoverflow.com/questions/7510219/deleting-row-in-sqlite-in-android)
        mDatabase.delete(PlantTable.NAME, PlantTable.Cols.UUID + " =?", new String[]{p.getId().toString()});
    }

}
