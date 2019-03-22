package rishab.listview.com.testmyapplication.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class databasehandler extends SQLiteOpenHelper {



    public databasehandler( Context context) {
        super(context,  constants.DATABASE_NAME, null, constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
