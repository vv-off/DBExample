package com.github.vv_off.dbexample;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.List;

public class DataBaseHandler extends SQLiteOpenHelper implements IDataBaseHandler{

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "noteBook";
    private static final String DATABASE_TABLE_NAME = "note";
    private static final String KEY_ID = "id";
    private static final String KEY_HEADER = "header";
    private static final String KEY_MESSAGE = "message";

    public DataBaseHandler(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + DATABASE_TABLE_NAME + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_HEADER + " TEXT,"
                + KEY_MESSAGE + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_NAME);
        onCreate(db);
    }

    @Override
    public DataDB getDataDB(int id) {
        return null;
    }

    @Override
    public List<DataDB> getAllDataDB() {
        return null;
    }

    @Override
    public int countDataDB() {
        return 0;
    }

    @Override
    public void addDataDB(DataDB dataDB) {

    }

    @Override
    public int updateDataDB(DataDB dataDB) {
        return 0;
    }

    @Override
    public void deleteDataDB(DataDB dataDB) {

    }

    @Override
    public void deleteAll() {

    }
}
