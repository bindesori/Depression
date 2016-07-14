package com.example.bindesoridevi.depression;

import android.support.v7.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
/*import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;*/
import android.view.View;
import android.widget.Button;

/**
 * Created by BINDESORI DEVI on 07-05-2016.
 */
public class TestActivity extends AppCompatActivity {

        Button button1,button2;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_test);
            button1=(Button)findViewById(R.id.startb);
            button2=(Button)findViewById(R.id.historyb);
            button1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent  ic  =new Intent(TestActivity.this,QuestionsActivity.class);
                    startActivity(ic);


                }
            });
            button2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent  ic  =new Intent(TestActivity.this,History.class);
                    startActivity(ic);


                }
            });

         /*   Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
*/
        }

    }

