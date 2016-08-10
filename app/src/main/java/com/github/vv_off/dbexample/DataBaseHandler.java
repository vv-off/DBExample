package com.github.vv_off.dbexample;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
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
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(DATABASE_TABLE_NAME, new String[] {KEY_ID,
                                    KEY_HEADER,KEY_MESSAGE}, KEY_ID + "=?",
                                    new String[] {String.valueOf(id)}, null, null, null, null);
        if(cursor != null){
            cursor.moveToFirst();
        }
        DataDB dataDB = new DataDB(Integer.parseInt(cursor.getString(0)), cursor.getString(1), cursor.getString(2));
        return dataDB;
    }

    @Override
    public List<DataDB> getAllDataDB() {
        List<DataDB>  dataDBList = new ArrayList<DataDB>();
        String selectQuery = "SELECT  * FROM " + DATABASE_TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if(cursor.moveToFirst()){
            do{
                DataDB dataDB = new DataDB();
                dataDB.setID(Integer.parseInt(cursor.getString(0)));
                dataDB.setHeader(cursor.getString(1));
                dataDB.setMessage(cursor.getString(2));
                dataDBList.add(dataDB);
            }while(cursor.moveToNext());
        }
        return dataDBList;
    }

    @Override
    public int getCountDataDB() {
        String countQuery = "SELECT  * FROM " + DATABASE_TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();

        return cursor.getCount();
    }

    @Override
    public void addDataDB(DataDB dataDB) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_HEADER,dataDB.getHeader());
        values.put(KEY_MESSAGE,dataDB.getMessage());

        db.insert(DATABASE_TABLE_NAME,null,values);
        db.close();
    }

    @Override
    public int updateDataDB(DataDB dataDB) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_HEADER, dataDB.getHeader());
        values.put(KEY_MESSAGE, dataDB.getMessage());

        return db.update(DATABASE_TABLE_NAME, values, KEY_ID + " = ?",
                new String[] { String.valueOf(dataDB.getID()) });
    }

    @Override
    public void deleteDataDB(DataDB dataDB) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE_NAME, KEY_ID + " = ?", new String[] { String.valueOf(dataDB.getID()) });
        db.close();
    }

    @Override
    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(DATABASE_TABLE_NAME,null,null);
        db.close();
    }
}
