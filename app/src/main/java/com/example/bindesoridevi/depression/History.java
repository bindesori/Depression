package com.example.bindesoridevi.depression;


import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;


public class History extends ListActivity {




    private HistoryDbAdapter hDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("oncreate","ok");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        setTitle("Diary");


        hDbHelper = new HistoryDbAdapter (this);
        hDbHelper.open();
        Cursor notesCursor = hDbHelper.fetchAllNotes();
        startManagingCursor(notesCursor);
        notesCursor.moveToFirst();
        Log.d("oncreate123", notesCursor.getString(1));
        String[] from = new String[] { HistoryDbAdapter.KEY_SCORE , HistoryDbAdapter.KEY_TYPE, HistoryDbAdapter.KEY_DATE};
        int[] to = new int[] { R.id.score ,R.id.typeofdep, R.id.datehis};
        SimpleCursorAdapter notes= new SimpleCursorAdapter(this, R.layout.history_row, notesCursor, from,to,0);
        ListView l= (ListView)findViewById(android.R.id.list);
        l.setAdapter(notes);
        //if(!(hDbHelper == null)) {
        //fillData();
//}
        registerForContextMenu(getListView());
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        fillData();

    }

    private void fillData() {

        Cursor notesCursor = hDbHelper.fetchAllNotes();
        startManagingCursor(notesCursor);
        String[] from = new String[] { HistoryDbAdapter.KEY_TYPE , HistoryDbAdapter.KEY_DATE, HistoryDbAdapter.KEY_SCORE};
        int[] to = new int[] { R.id.typeofdep ,R.id.datehis, R.id.score};
        SimpleCursorAdapter notes= new SimpleCursorAdapter(this, R.layout.history_row, notesCursor, from,to,0);
        ListView l= (ListView)findViewById(android.R.id.list);
        l.setAdapter(notes);



    }



    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        fillData();
    }



}