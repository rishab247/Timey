package rishab.listview.com.testmyapplication.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


public class databasehandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME= "Alarm1102121.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME= "alarms";
    public static final String Hours= "hours";
    public static final String Mintune= "minutes";
    public static final String Repeat_days= "repeat";
    public static final String Label= "lable";
    public static final String Tone= "alarm_tone";
    public static final String Mode= "mode";
    public static final String no_shake= "NO_OF_SHAKES";
    public static final String diff_math= "DIFF_MATH";
    public static final String no_MATH= "NO_OF_MATH ";
    public static final String KEY_ID= "id";


    public static final String CREATE_TABLE =
            "CREATE TABLE " + TABLE_NAME + "("
                    +KEY_ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                    +Hours + " TEXT,"+ Mintune + " TEXT,"+ Repeat_days+ " TEXT,"
                    + Label + " TEXT,"+ Tone + " TEXT,"+ Mode + " TEXT,"+ no_shake + " TEXT,"+
                    diff_math + " TEXT,"+no_MATH+ " TEXT"+")";
    public databasehandler( Context context) {
        super(context,  DATABASE_NAME, null, DATABASE_VERSION);
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


    public  boolean insertdata(String hours ,String minutes,String repeatingday,String label,String tone,String mode,String noshake,String diffmath,String noofmath){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();
        contentValues.put(Hours,hours);
        contentValues.put(Mintune,minutes);
        contentValues.put(Repeat_days,repeatingday);
        contentValues.put(Label,label);
        contentValues.put(Tone,tone);
        contentValues.put(Mode,mode);
        contentValues.put(no_shake,noshake);
        contentValues.put(diff_math,diffmath);
        contentValues.put(no_MATH,noofmath);
        long result= db.insert(TABLE_NAME,null,contentValues);
        db.close();

        return result != -1;
    }

    public int getCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
    public boolean deleteTitle(int  id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
       boolean a= db.delete(TABLE_NAME, KEY_ID + "=" + id    , null) > 0;
       db.execSQL(" UPDATE "+TABLE_NAME+" SET "+KEY_ID+" = "+KEY_ID +"-"+ 1 +" WHERE "+KEY_ID +">"+ id );
        Log.e(TAG, "deleteTitle: "+a);
db.close();
        return a;
    }
    public  boolean updatedata(String id,String hours ,String minutes,String repeatingday,String label,String tone,String mode,String noshake,String diffmath,String noofmath){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues= new ContentValues();
        contentValues.put(KEY_ID,id);
        contentValues.put(Hours,hours);
        contentValues.put(Mintune,minutes);
        contentValues.put(Repeat_days,repeatingday);
        contentValues.put(Label,label);
        contentValues.put(Tone,tone);
        contentValues.put(Mode,mode);
        contentValues.put(no_shake,noshake);
        contentValues.put(diff_math,diffmath);
        contentValues.put(no_MATH,noofmath);
       db.update(TABLE_NAME,contentValues,"ID = ?",new String[]{id});
       db.close();
       return true;
    }
    public Cursor getdata(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor ros = db.rawQuery("select * from "+TABLE_NAME,null);
return ros;
    }







    public List<constants> getalldata() {
        List<constants> alarmlist = new ArrayList<constants>();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                constants constants1= new constants();
               constants1.setKEY_ID(cursor.getString(0));
                constants1.setHours(cursor.getString(1));
                constants1.setMintune(cursor.getString(2));
                constants1.setRepeat_days(cursor.getString(3));
                constants1.setLabel(cursor.getString(4));
                constants1.setTone(cursor.getString(5));
                constants1.setMode(cursor.getString(6));
                constants1.setNo_shake(cursor.getString(7));
                constants1.setDiff_math(cursor.getString(8));
                constants1.setNo_MATH(cursor.getString(9));
                alarmlist.add(constants1);
            } while (cursor.moveToNext());
        }
                cursor.close();
        return alarmlist;
    }

    public int updatedata(constants constants1, int id) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Hours,constants1.getHours());
        contentValues.put(Mintune,constants1.getMintune());
        contentValues.put(Repeat_days,constants1.getRepeat_days());
        contentValues.put(Label,constants1.getLabel());
        contentValues.put(Tone,constants1.getTone());
        contentValues.put(Mode,constants1.getMode());
        contentValues.put(no_shake,constants1.getNo_shake());
        contentValues.put(diff_math,constants1.getDiff_math());
        contentValues.put(no_MATH,constants1.getNo_MATH());

        // updating row
        return db.update(TABLE_NAME, contentValues, KEY_ID + " = ?",
                new String[] { String.valueOf(id) });
    }

}

