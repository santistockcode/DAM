package com.santi.pec3_sas.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.santi.pec3_sas.R;

public class PlaceBaseHelper extends SQLiteOpenHelper {

    private static final int VERSION = 1;
    private static final String DATABASE_NAME = "crimeBase.db";

    //constructor (aquí solo usamos contexto, nombre de la base de datos y versión)
    public PlaceBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }
    //crea la base de datos
    @Override
    public void onCreate(SQLiteDatabase db) {
        //comandos sql para crear la tabla con sus columnas y rellenarla
        db.execSQL("create table " + PlaceDbSchema.PlaceTable.NAME + "(" +
                "id integer primary key autoincrement, " +
                PlaceDbSchema.PlaceTable.Cols.NAME + "," +
                PlaceDbSchema.PlaceTable.Cols.IMAGEID + "," +
                PlaceDbSchema.PlaceTable.Cols.RATINGCOUNT +
                ")"
        );

        ContentValues values1 = new ContentValues();
        values1.put(PlaceDbSchema.PlaceTable.Cols.NAME, "Asturias");
        values1.put(PlaceDbSchema.PlaceTable.Cols.IMAGEID, R.drawable.asturias);
        values1.put(PlaceDbSchema.PlaceTable.Cols.RATINGCOUNT, "0");
        db.insert(PlaceDbSchema.PlaceTable.NAME, null, values1);

        ContentValues values2 = new ContentValues();
        values2.put(PlaceDbSchema.PlaceTable.Cols.NAME, "Barcelona");
        values2.put(PlaceDbSchema.PlaceTable.Cols.IMAGEID, R.drawable.barcelona);
        values2.put(PlaceDbSchema.PlaceTable.Cols.RATINGCOUNT, "0");
        db.insert(PlaceDbSchema.PlaceTable.NAME, null, values2);

        ContentValues values3 = new ContentValues();
        values3.put(PlaceDbSchema.PlaceTable.Cols.NAME, "Cantabria");
        values3.put(PlaceDbSchema.PlaceTable.Cols.IMAGEID, R.drawable.cantabria);
        values3.put(PlaceDbSchema.PlaceTable.Cols.RATINGCOUNT, "0");
        db.insert(PlaceDbSchema.PlaceTable.NAME, null, values3);

        ContentValues values4 = new ContentValues();
        values4.put(PlaceDbSchema.PlaceTable.Cols.NAME, "Ciudad Real");
        values4.put(PlaceDbSchema.PlaceTable.Cols.IMAGEID, R.drawable.ciudadreal);
        values4.put(PlaceDbSchema.PlaceTable.Cols.RATINGCOUNT, "0");
        db.insert(PlaceDbSchema.PlaceTable.NAME, null, values4);

        ContentValues values5 = new ContentValues();
        values5.put(PlaceDbSchema.PlaceTable.Cols.NAME, "Gerona");
        values5.put(PlaceDbSchema.PlaceTable.Cols.IMAGEID, R.drawable.gerona);
        values5.put(PlaceDbSchema.PlaceTable.Cols.RATINGCOUNT, "0");
        db.insert(PlaceDbSchema.PlaceTable.NAME, null, values5);

        ContentValues values6 = new ContentValues();
        values6.put(PlaceDbSchema.PlaceTable.Cols.NAME, "Granada");
        values6.put(PlaceDbSchema.PlaceTable.Cols.IMAGEID, R.drawable.granada);
        values6.put(PlaceDbSchema.PlaceTable.Cols.RATINGCOUNT, "0");
        db.insert(PlaceDbSchema.PlaceTable.NAME, null, values6);

        ContentValues values7 = new ContentValues();
        values7.put(PlaceDbSchema.PlaceTable.Cols.NAME, "Madrid");
        values7.put(PlaceDbSchema.PlaceTable.Cols.IMAGEID, R.drawable.madrid);
        values7.put(PlaceDbSchema.PlaceTable.Cols.RATINGCOUNT, "0");
        db.insert(PlaceDbSchema.PlaceTable.NAME, null, values7);

        ContentValues values8 = new ContentValues();
        values8.put(PlaceDbSchema.PlaceTable.Cols.NAME, "Sevilla");
        values8.put(PlaceDbSchema.PlaceTable.Cols.IMAGEID, R.drawable.sevilla);
        values8.put(PlaceDbSchema.PlaceTable.Cols.RATINGCOUNT, "0");
        db.insert(PlaceDbSchema.PlaceTable.NAME, null, values8);

        ContentValues values9 = new ContentValues();
        values9.put(PlaceDbSchema.PlaceTable.Cols.NAME, "Valencia");
        values9.put(PlaceDbSchema.PlaceTable.Cols.IMAGEID, R.drawable.valencia);
        values9.put(PlaceDbSchema.PlaceTable.Cols.RATINGCOUNT, "0");
        db.insert(PlaceDbSchema.PlaceTable.NAME, null, values9);

        ContentValues values10 = new ContentValues();
        values10.put(PlaceDbSchema.PlaceTable.Cols.NAME, "Vizcaya");
        values10.put(PlaceDbSchema.PlaceTable.Cols.IMAGEID, R.drawable.vizcaya);
        values10.put(PlaceDbSchema.PlaceTable.Cols.RATINGCOUNT, "0");
        db.insert(PlaceDbSchema.PlaceTable.NAME, null, values10);


    }
    //actualiza si la versión es posterior
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
