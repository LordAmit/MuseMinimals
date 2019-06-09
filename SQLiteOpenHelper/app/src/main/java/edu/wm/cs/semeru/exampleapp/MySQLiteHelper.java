package edu.wm.cs.semeru.exampleapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Calendar;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public MySQLiteHelper(Context context){
        super(context, "example", null, 1);

    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String dataLeak = Calendar.getInstance().getTimeZone().getDisplayName();
        Log.d("leak-1", dataLeak);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
