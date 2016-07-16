package com.example.bindesoridevi.depression;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class Todolist {

    private static final String TAG = "DBAdapter"; //used for logging database version changes

    // Field Names:
    public static final String KEY_ROW_ID = "_id";
    public static final String KEY_TYPE = "type";
    public static final String KEY_DATE = "date";
    public static final String KEY_SCORE = "score";

    public static final String[] ALL_KEYS = new String[] {KEY_ROW_ID, KEY_TYPE, KEY_DATE, KEY_SCORE};

    // Column Numbers for each Field Name:
    public static final int COL_ROWID = 0;
    public static final int COL_TYPE = 1;
    public static final int COL_DATE = 2;
    public static final int COL_SCORE = 3;
    Cursor cursor;
    // DataBase info:
    private static final String DATABASE_NAME = "hisdata";
    private static final String DATABASE_TABLE = "hisnotes";
    public static final int DATABASE_VERSION = 2; // The version number must be incremented each time a change to DB structure occurs.

    //SQL statement to create database
    private static final String DATABASE_CREATE_SQL =
            "CREATE TABLE " + DATABASE_TABLE
                    + " (" + KEY_ROW_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + KEY_TYPE + " TEXT NOT NULL, "
                    + KEY_DATE + " TEXT NOT NULL,  "
                    + KEY_SCORE + " INTEGER NOT NULL"
                    + ");";

    private final Context context;
    private DatabaseHelper myDBHelper;
    private SQLiteDatabase db;



    public Todolist(Context ctx) {
        this.context = ctx;
        myDBHelper = new DatabaseHelper(context);
    }

    // Open the database connection.
    public Todolist open() {
        db = myDBHelper.getWritableDatabase();
//        cursor= db.rawQuery("SELECT * FROM mainToDo ",null);
        return this;
    }

    // Close the database connection.
    public void close() {
        myDBHelper.close();
    }

    // Add a new set of values to be inserted into the database.
    public long insertRow(String type, String date, String score) {
        ContentValues initialValues = new ContentValues();
        initialValues.put(KEY_TYPE, type);
        initialValues.put(KEY_DATE, date);
        initialValues.put(KEY_SCORE, score);

        // Insert the data into the database.
        return db.insert(DATABASE_TABLE, null, initialValues);
    }

    // Delete a row from the database, by rowId (primary key)
    public boolean deleteRow(long rowId) {
        String where = KEY_ROW_ID + "=" + rowId;
        return db.delete(DATABASE_TABLE, where, null) != 0;
    }

    public Cursor fetchAllNotes() {
        // TODO Auto-generated method stub
        return db.query(DATABASE_TABLE, new String[] {KEY_ROW_ID, KEY_SCORE,KEY_TYPE,
                KEY_DATE}, null, null, null, null, null);
    }


    public void deleteAll() {
        Cursor c = getAllRows();
        long rowId = c.getColumnIndexOrThrow(KEY_ROW_ID);
        if (c.moveToFirst()) {
            do {
                deleteRow(c.getLong((int) rowId));
            } while (c.moveToNext());
        }
        c.close();
    }

    // Return all data in the database.
    public Cursor getAllRows() {
        String where = null;
        //Cursor c = 	db.query(true, DATABASE_TABLE, ALL_KEYS, where, null, null, null, null, null);
        Cursor c=    db.rawQuery("SELECT * FROM mainToDo", null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    // Get a specific row (by rowId)
    public Cursor getRow(long rowId) {
        String where = KEY_ROW_ID + "=" + rowId;
        Cursor c = 	db.query(true, DATABASE_TABLE, ALL_KEYS,
                where, null, null, null, null, null);
        if (c != null) {
            c.moveToFirst();
        }
        return c;
    }

    //Change an existing row to be equal to new data.
    public boolean updateRow(long rowId, String type, String date, String score) {
        String where = KEY_ROW_ID + "=" + rowId;
        ContentValues newValues = new ContentValues();
        newValues.put(KEY_TYPE, type);
        newValues.put(KEY_DATE, date);
        newValues.put(KEY_SCORE, score);
        // Insert it into the database.
        return db.update(DATABASE_TABLE, newValues, where, null) != 0;
    }


    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        @Override
        public void onCreate(SQLiteDatabase _db) {
            _db.execSQL(DATABASE_CREATE_SQL);
        }

        @Override
        public void onUpgrade(SQLiteDatabase _db, int oldVersion, int newVersion) {
            Log.w(TAG, "Upgrading application's database from version " + oldVersion
                    + " to " + newVersion + ", which will destroy all old data!");

            // Destroy old database:
            _db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE);

            // Recreate new database:
            onCreate(_db);
        }
    }


}

