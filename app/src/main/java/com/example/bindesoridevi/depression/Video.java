package com.example.bindesoridevi.depression;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


/**
 * Created by BINDESORI DEVI on 20-06-2016.
 */
public class Video extends AppCompatActivity {
        Button b1,b2,b3,b4;


        @Override

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_video);
            b1=(Button) findViewById(R.id.med);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent i  =new Intent(Video.this,Thumbnaillist.class);
                    i.putExtra("v",1);
                    startActivity(i);

                }
            });
            b2=(Button) findViewById(R.id.nsd);
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent  i  =new Intent(Video.this,Thumbnaillist.class);

                    i.putExtra("v",2);
                    startActivity(i);

                }
            });
            b3=(Button) findViewById(R.id.ted);
            b3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent  i  =new Intent(Video.this,Thumbnaillist.class);
                    i.putExtra("v",3);
                    startActivity(i);

                }
            });
            b4=(Button) findViewById(R.id.intrst);
            b4.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent  i  =new Intent(Video.this,Thumbnaillist.class);
                    i.putExtra("v",4);
                    startActivity(i);

                }
            });
            // Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            //setSupportActionBar(toolbar);

       /* FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.action_settings) {
                return true;
            }

            return super.onOptionsItemSelected(item);
        }
    }


