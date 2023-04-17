package com.santi.ficusing.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.santi.ficusing.database.PlantDbSchema.PlantTable;

//Helper class to manage database creation and version management.
public class PlantBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    //Name for the database
    private static final String DATABASE_NAME = "plantBase.db";

    //Create a helper object to create, open, and/or manage a database.
    public PlantBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    //Called when the database is created for the first time.
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + PlantTable.NAME + "(" +
                "_id integer primary key autoincrement, " +
                PlantTable.Cols.UUID + ", " +
                PlantTable.Cols.NAME + ", " +
                PlantTable.Cols.ABOUT + ", " +
                PlantTable.Cols.FREQUENCY + ", " +
                PlantTable.Cols.STATE + ", " +
                PlantTable.Cols.BACK_FREQUENCY + "," +
                PlantTable.Cols.ALARM +
                ")"
        );
    }

    //Called when the database needs to be upgraded
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}