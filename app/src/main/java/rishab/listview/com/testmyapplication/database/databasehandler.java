package rishab.listview.com.testmyapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.NoCopySpan;


import static rishab.listview.com.testmyapplication.database.constants.TABLE_NAME;


public class databasehandler extends SQLiteOpenHelper {
    public static final String CREATE_TABLE =
            "CREATE TABLE " + constants.TABLE_NAME + "("
                    +constants.KEY_ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + constants.Hours + " INTEGER,"+ constants.Mintune + " INTEGER,"+ constants.Repeat_days+ " TEXT,"
                    + constants.Label + " TEXT,"+ constants.Tone + " INTEGER,"+ constants.Mode + " TEXT)";



    public databasehandler( Context context) {
        super(context,  constants.DATABASE_NAME, null, constants.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }


    public  boolean insertdata(String hours ,String minutes,String repeatingday,String label,int tone,String mode){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(constants.Hours,hours);
        contentValues.put(constants.Mintune,minutes);
        contentValues.put(constants.Repeat_days,repeatingday);
        contentValues.put(constants.Label,label);
        contentValues.put(constants.Tone,tone);
        contentValues.put(constants.Mode,mode);
        long result= db.insert(TABLE_NAME,null,contentValues);
        if(result==-1){
            return false;
        }
        else {
            return true;
        }
    }
}
