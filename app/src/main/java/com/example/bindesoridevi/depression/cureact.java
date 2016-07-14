package com.example.bindesoridevi.depression;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by BINDESORI DEVI on 07-05-2016.
 */
public class cureact extends AppCompatActivity {
    Button diar;
      Button vid;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cure);
        diar = (Button) findViewById(R.id.diar);
        diar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(cureact.this, diary.class);
                startActivity(i);
            }
        });
        vid = (Button) findViewById(R.id.vid);
        vid.setOnClickListener(new View.OnClickListener() {
      @Override
            public void onClick(View v) {
                Intent i = new Intent(cureact.this, Video.class);
                                        startActivity(i);
                                    }
                                });
        /** Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);

         FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
         fab.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
        .setAction("Action", null).show();
        }
        });
         **/}


}