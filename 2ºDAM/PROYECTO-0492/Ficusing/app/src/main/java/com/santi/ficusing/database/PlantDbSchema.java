package com.santi.ficusing.database;

//Inner class to define the table structure
public class PlantDbSchema {
    //This class only exist to define the String constants needed to describe the table definitions.
    public static final class PlantTable {
        //Name for the table
        public static final String NAME = "plants";

        //Name for the columns
        public static final class Cols {
            public static final String UUID = "uuid";
            public static final String NAME = "name";
            public static final String ABOUT = "about";
            public static final String FREQUENCY = "frequency";
            public static final String STATE = "state";
            public static final String BACK_FREQUENCY = "back_frequency";
            public static final String ALARM = "alarm";

        }
    }
}