package com.example.bindesoridevi.depression;

/**
 * Created by BINDESORI DEVI on 07-05-2016.
 */
        import android.content.Intent;
        import android.os.Bundle;
       /* import android.support.design.widget.FloatingActionButton;
        import android.support.design.widget.Snackbar;*/
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

public class QuestionsActivity extends AppCompatActivity {
    Button opa, opb, opc, opd;
    TextView tv1, tv2;
    int sum = 0;
    int cntr=1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques);

        opa = (Button) findViewById(R.id.button1);
        opb = (Button) findViewById(R.id.button2);
        opc = (Button) findViewById(R.id.button3);
        opd = (Button) findViewById(R.id.button4);
        tv1 = (TextView) findViewById(R.id.textView);
        tv2 = (TextView) findViewById(R.id.textView2);

        opa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                cntr++;
                counter(cntr);
                sum = sum + 0;
            }
        });


        opb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                cntr++;
                counter(cntr);
                sum = sum + 1;
            }
        });
        opc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cntr++;
                counter(cntr);
                sum = sum + 2;
            }
        });

        opd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cntr++;
                counter(cntr);
                sum = sum + 3;
            }
        });



        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


    }

    void score() {
        if (cntr > 9 && (sum >= 1 && sum <= 4)) {

            //  Intent ic = new Intent(getApplicationContext(),None_test.class);
            Intent ic = new Intent(QuestionsActivity.this,Common.class);
            ic.putExtra("SUM" ,sum);
            startActivity(ic);

        }
        else if(cntr>9 && (sum >= 5 && sum <= 9))
        {Intent ic = new Intent(QuestionsActivity.this,Common.class);
            ic.putExtra("SUM" ,sum);
            startActivity(ic);}
        else if (cntr>9 && (sum >= 10 && sum <= 14))
        {Intent ic2 = new Intent(QuestionsActivity.this,Common.class);
            ic2.putExtra("SUM" ,sum);
            startActivity(ic2);}
        else if(cntr>9 && (sum >= 15 && sum <= 19))
        {Intent ic3 = new Intent(QuestionsActivity.this,Common.class);
            ic3.putExtra("SUM" ,sum);
            startActivity(ic3);}
        else
        {Intent ic4 = new Intent(QuestionsActivity.this,Common.class);
            ic4.putExtra("SUM" ,sum);
            startActivity(ic4);}
    }

    void counter(int cntr)
    {


        switch (cntr) {
            case 1:
                tv2.setText("Little interest or pleasure in doing things");
                break;
            case 2:
                tv2.setText("Feeling down,depressed,or hopeless");
                break;

            case 3:
                tv2.setText("Trouble falling or staying asleep,or sleeping too much");
                break;

            case 4:
                tv2.setText("Feeling tired or having little energy");
                break;

            case 5:
                tv2.setText("Poor appetite or overeating");
                break;

            case 6:
                tv2.setText("Feeling bad about yourself - or that you are a failure or have let yourself or your family down");
                break;

            case 7:
                tv2.setText("Trouble concentrating on things,such as reading the newspaper or watching television");  break;

            case 8:
                tv2.setText("Moving or speaking noticeably slower than usual or the opposite, faster than usual");
                break;

            case 9:
                tv2.setText("Thoughts that you would be better off dead or of hurting yourself in some way ");
                break;
            default: score();

        }
    }
}
