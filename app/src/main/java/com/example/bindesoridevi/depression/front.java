package com.example.bindesoridevi.depression;

import android.content.Intent;
import android.os.Bundle;
/*import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;*/
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class front extends AppCompatActivity {
    Button testb, cureb, helpb;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front);
        testb=(Button) findViewById(R.id.test);
        testb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent  i  =new Intent(front.this,TestActivity.class);
               startActivity(i);

            }
        });
        cureb=(Button) findViewById(R.id.cure);
        cureb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent  i  =new Intent(front.this,cureact.class);
                                startActivity(i);

            }
        });
        helpb=(Button) findViewById(R.id.help);
        helpb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent  i  =new Intent(front.this,TestActivity.class);
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
