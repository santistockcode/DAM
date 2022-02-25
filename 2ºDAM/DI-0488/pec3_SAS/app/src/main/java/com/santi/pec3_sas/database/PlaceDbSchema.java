package com.santi.pec3_sas.database;

public class PlaceDbSchema {

    //clase para deiminir la tabla
    public static final class PlaceTable{
        //define el nombre de la tabla
        public static final String NAME = "places";

        //en una clase interna definimos las columnas
        public static final class Cols {
            public static final String NAME = "name";
            public static final String IMAGEID = "imageId";
            public static final String RATINGCOUNT = "ratingCount";
        }

    }

}
