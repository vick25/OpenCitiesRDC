package net.osfac.opencitiesrdc.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHandler extends SQLiteOpenHelper {

    //database constants
    private static final String DATABASE_NAME = "opencities.sqlite";
    private static final int DATABASE_VERSION = 1;

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d("\tOSM Test", "In the OSM Test DBHandler class constructor");
        this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d("\topencities", "Creating the DB and inserting default values");
        db.execSQL("PRAGMA foreign_keys = ON;");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        Log.d("\topencities", "Upgrading DB from " + i + " to " + i1);
//        db.execSQL(CityPOIDB.DROP_CITY_TABLE);
//        db.execSQL(CityPOIDB.DROP_POI_TABLE);
        onCreate(db);
    }
}
