package com.santi.pec3_sas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.santi.pec3_sas.database.PlaceBaseHelper;
import com.santi.pec3_sas.database.PlaceCursorWrapper;
import com.santi.pec3_sas.database.PlaceDbSchema;

import java.util.ArrayList;
import java.util.List;
//capa de negocio entre el modelo de datos y las vistas
public class PlaceManager {

    private static PlaceManager sPlaceManager;

    private Context mContext;
    private SQLiteDatabase mDatabase;

    private PlaceManager(Context context){
        mContext = context.getApplicationContext();
        //genero el objeto database con el que voy a trabajo y marco que su acceso es de escritura
        mDatabase=new PlaceBaseHelper(mContext).getWritableDatabase();
    }

    public static PlaceManager get(Context context){
        if(sPlaceManager == null){
            sPlaceManager = new PlaceManager(context);
        }
        return sPlaceManager;
    }
    public List<Place> getPlaces(){
        //return mCrimes;
        List<Place> places = new ArrayList<>();
        PlaceCursorWrapper cursor = queryPlaces(null, null);
        try {
            cursor.moveToFirst();
            while(!cursor.isAfterLast()){
                places.add(cursor.getPlace()); //getPlace encapsula mucho codigo
                cursor.moveToNext();
            }
        }finally{
            cursor.close();
        }
        return places; //es decir hemos llenado el arraylist desde la db
    }


    //un cursor sirve para recorrer
    private PlaceCursorWrapper queryPlaces(String whereClause, String[] whereArgs){
        //private Cursor queryCrimes(String whereClause, String[]whereArgs){
        Cursor cursor = mDatabase.query(
                //en qué tabla buscar
                PlaceDbSchema.PlaceTable.NAME,
                //quiero todas las columnas
                null,
                whereClause,
                whereArgs,
                null,
                null,
                null
        );
        //return cursor;
        return new PlaceCursorWrapper(cursor);
    }
    //el acceso a datos necesita de una construcción de este tipo
    public static ContentValues getContentValues(Place place){
        ContentValues values = new ContentValues();
        values.put(PlaceDbSchema.PlaceTable.Cols.NAME, place.getName().toString());
        values.put(PlaceDbSchema.PlaceTable.Cols.IMAGEID, place.getImageResourceId());
        values.put(PlaceDbSchema.PlaceTable.Cols.RATINGCOUNT, place.getRatingCount());
        return values;
    }

    //método propio para actualizar un crimen, que será usado por tanto en Crime Fragment on pause
    public void updatePlace(Place place){
        String name_place = place.getName().toString();
        ContentValues values = getContentValues(place);
        mDatabase.update(PlaceDbSchema.PlaceTable.NAME, values,
                PlaceDbSchema.PlaceTable.Cols.NAME + " = ?",
                new String[] {name_place});
    }

}

