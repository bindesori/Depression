package com.example.bindesoridevi.depression;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class HistoryDbAdapter {


    public static final String KEY_ROWID = "id";
    public static final String KEY_SC = "sc";
    public static final String KEY_TYPP = "typp";
    public static final String KEY_PackageName = "com.example.bindesoridevi.depression";
    public static final String KEY_DATE = "date";
    private static final String DATABASE_NAME = "hisdata";
    private static final String DATABASE_TABLE = "hisnotes";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE =
            "create table if not exists hisnotes (id integer primary key autoincrement, "
                    + "sc text not null, typp text not null, date text not null);";
    private final Context context;
    private static DatabaseHelper DBHelper;
    private static SQLiteDatabase db;
    public HistoryDbAdapter(Context ctx)
    {
        this.context = ctx;
        DBHelper = new DatabaseHelper(context);
    }
    public static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context)
        {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try {
                db.execSQL(DATABASE_CREATE);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // TODO Auto-generated method stub

        }

        //---opens the database---
        public DatabaseHelper open() throws SQLException
        {
            db = DBHelper.getWritableDatabase();
            return this;
        }

        public Cursor getAllRecords()
        {
            return db.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_SC,KEY_TYPP,
                    KEY_DATE}, null, null, null, null, null);
        }



    }
    public HistoryDbAdapter open() throws SQLException{
        // TODO Auto-generated method stub
        db = DBHelper.getWritableDatabase();
        return this;
    }
    public long createNote(String sc,String typp, String date) {
        // TODO Auto-generated method stub
        Log.d("dbadapter", "creating note");
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_SC, sc);
        initialValues.put(KEY_TYPP, typp);
        initialValues.put(KEY_DATE, date);
        return db.insert(DATABASE_TABLE, null, initialValues);
    }
    public void close() {
        // TODO Auto-generated method stub
        DBHelper.close();
    }
    public Cursor fetchAllNotes() {
        // TODO Auto-generated method stub
        return db.query(DATABASE_TABLE, new String[] {KEY_ROWID, KEY_SC,KEY_TYPP,
                KEY_DATE}, null, null, null, null, null);
    }

    //---deletes a particular record---
    public boolean deleteData(long rowId) {
        // TODO Auto-generated method stub
        return db.delete(DATABASE_TABLE, KEY_ROWID + "=" + rowId, null) > 0;
    }
    public static void deleteAll() {
        // TODO Auto-generated method stub
        db.delete(DATABASE_TABLE, null, null);
        Log.e("Delete", "Deleted");

    }


    public Cursor fetchNote(long rowId) throws SQLException {

        Cursor mCursor =

                db.query(true, DATABASE_TABLE, new String[] {KEY_ROWID,
                                KEY_SC, KEY_TYPP,KEY_DATE}, KEY_ROWID + "=" + rowId, null,
                        null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;

    }

    public boolean updateNote(long rowId, String typp, Integer sc,String date) {
        ContentValues args = new ContentValues();
        args.put(KEY_SC, sc);
        args.put(KEY_TYPP, typp);

        //This lines is added for personal reason
        args.put(KEY_DATE, date);

        //One more parameter is added for data
        return db.update(DATABASE_TABLE, args, KEY_ROWID + "=" + rowId, null) > 0;
    }


}
