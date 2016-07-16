package com.example.bindesoridevi.depression;

import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by BINDESORI DEVI on 14-05-2016.
 */
public class Common extends AppCompatActivity {
    TextView tt4;
TextView tt5;
    public static int numTitle = 1;
    public static String curDate = "";
    public static String curText = "";
    private TextView mTypeOfDText;
    private TextView mScoreText;
    private TextView mDateText;
    private Long mRowId;

    private Cursor note;
    private HistoryDbAdapter mDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        tt4 = (TextView) findViewById(R.id.textView2);
        int value = getIntent().getIntExtra("SUM", 0);
        tt4.setText(String.valueOf(value));
        suggestion(value);
        mDbHelper = new HistoryDbAdapter(this);
        mDbHelper.open();

               //  Toolbar toolbr = (Toolbar) findViewById(R.id.toolbar);

        // setSupportActionBar(toolbr);
        mTypeOfDText = (TextView) findViewById(R.id.textView3);
        mScoreText = (TextView) findViewById(R.id.textView2);
    mDateText = (TextView) findViewById(R.id.notehist_date);

        long msTime = System.currentTimeMillis();
        Date curDateTime = new Date(msTime);

        SimpleDateFormat formatter = new SimpleDateFormat("d'/'M'/'y");
        curDate = formatter.format(curDateTime);

        mDateText.setText(""+curDate);


        mRowId = (savedInstanceState == null) ? null :
                (Long) savedInstanceState.getSerializable(HistoryDbAdapter.KEY_ROWID);
        if (mRowId == null) {
            Bundle extras = getIntent().getExtras();
            mRowId = extras != null ? extras.getLong(HistoryDbAdapter.KEY_ROWID)
                    : null;
        }

//        populateFields();

    }

    public static class LineEditText extends EditText{
        // we need this constructor for LayoutInflater
        public LineEditText(Context context, AttributeSet attrs) {
            super(context, attrs);
            mRect = new Rect();
            mPaint = new Paint();
            mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
            mPaint.setColor(Color.BLUE);
        }

        private Rect mRect;
        private Paint mPaint;

        @Override
        protected void onDraw(Canvas canvas) {

            int height = getHeight();
            int line_height = getLineHeight();

            int count = height / line_height;

            if (getLineCount() > count)
                count = getLineCount();

            Rect r = mRect;
            Paint paint = mPaint;
            int baseline = getLineBounds(0, r);

            for (int i = 0; i < count; i++) {

                canvas.drawLine(r.left, baseline + 1, r.right, baseline + 1, paint);
                baseline += getLineHeight();

                super.onDraw(canvas);
            }

        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        saveState();
        outState.putSerializable(HistoryDbAdapter.KEY_ROWID, mRowId);
    }

    @Override
    protected void onPause() {
        super.onPause();
        saveState();
    }

    @Override
    protected void onResume() {
        super.onResume();
        populateFields();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.history_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_about:

             /* Here is the introduce about myself */
                AlertDialog.Builder dialog = new AlertDialog.Builder(Common.this);
                dialog.setTitle("About");
                dialog.setMessage("Hello! "
                );
                dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();

                    }
                });
                dialog.show();
                return true;
            /** case R.id.menu_delete:
             if(note != null){
             note.close();
             note = null;
             }
             if(mRowId != null){
             mDbHelper.deleteNote(mRowId);
             }
             finish();

             return true;
             case R.id.menu_save:
             saveState();
             finish();
             **/
             default:
             return super.onOptionsItemSelected(item);

        }
    }


    private void saveState() {
        String type = mTypeOfDText.getText().toString();
        String score1 = mScoreText.getText().toString();
          int score = Integer.parseInt(score1);
        mDbHelper.createNote(String.valueOf(score), type, curDate);
        Log.d("savestate", "creating");
//        if(mRowId == null){
//            long id = mDbHelper.createNote(String.valueOf(score), typp, curDate);
//            if(id > 0){
//                mRowId = id;
//            }else{
//                Log.e("saveState","failed to create note");
//            }
//        }else{
//
//            if(!mDbHelper.updateNote(mRowId, typp, score, curDate)){
//                Log.e("saveState","failed to update note");
//            }
//        }
    }


    private void populateFields() {
        if (mRowId != null) {
            note = mDbHelper.fetchNote(mRowId);
            startManagingCursor(note);
            if (note != null) {
                if (note.moveToFirst())

                {
                    mTypeOfDText.setText(note.getString(
                            note.getColumnIndexOrThrow(HistoryDbAdapter.KEY_TYPE)));
                    mScoreText.setText(note.getString(
                            note.getColumnIndexOrThrow(HistoryDbAdapter.KEY_SCORE)));
                    curText = note.getString(
                            note.getColumnIndexOrThrow(HistoryDbAdapter.KEY_DATE));
                }

            }
            if(note != null && !note.isClosed())
            {
                note.close();
            }
        }
    }




    void suggestion(int sum)
    {
        tt5= (TextView) findViewById(R.id.textView3);

        if(sum >= 1 && sum <= 4)
            tt5.setText("none");
        else
            if (sum >= 5 && sum <= 9)
                tt5.setText("mild");
        else
                if (sum >= 10 && sum <= 14)
                    tt5.setText("moderate");
        else if (sum >= 15 && sum <= 19)
                    tt5.setText("ms");
        else
                    tt5.setText("severe");


    }
}