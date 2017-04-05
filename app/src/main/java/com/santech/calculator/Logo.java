package com.santech.calculator;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.widget.Toast;

public class Logo extends Activity {
    int k = 0,c=0;



    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo);
         Thread timer1 = new Thread() {
            public void run() {
                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    Intent compute = new Intent("com.santech.calculator.COMPUTE");
                    if (c==0){
                        startActivity(compute);
                    }
                }

            }

        };
        timer1.start();

    }

    @Override
    public void onBackPressed() {

        k++;
        if (k == 1) {
            Vibrator v = (Vibrator)getSystemService(VIBRATOR_SERVICE);
            v.vibrate(75);
            Toast.makeText(getApplicationContext(), "press again to exit", Toast.LENGTH_SHORT).show();
            Thread timer = new Thread() {
                public void run() {
                    try {
                        sleep(1500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        k = 0;
                    }
                }
            };
            timer.start();
        } else {
            c++;
            finish();
        }
    }

}
