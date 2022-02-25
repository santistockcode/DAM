package com.santi.pec3_sas.database;

import android.database.Cursor;
import android.database.CursorWrapper;

import com.santi.pec3_sas.Place;

public class PlaceCursorWrapper extends CursorWrapper {

    /**
     * Creates a cursor wrapper.
     *
     * @param cursor The underlying cursor to wrap.
     */
    public PlaceCursorWrapper (Cursor cursor) {
        super(cursor);
    }

    //método propio
    public Place getPlace(){
        String name = getString(getColumnIndex(PlaceDbSchema.PlaceTable.Cols.NAME));
        int imageId = getInt(getColumnIndex(PlaceDbSchema.PlaceTable.Cols.IMAGEID));
        int ratingCount = getInt(getColumnIndex(PlaceDbSchema.PlaceTable.Cols.RATINGCOUNT));
        Place place = new Place();
        place.setName(name);
        place.setImageResourceId(imageId);
        place.setRatingCount(ratingCount);
        return place;
    }
}
