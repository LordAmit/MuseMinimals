package edu.wm.cs.semeru.exampleapp;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String dataLeak = Calendar.getInstance().getTimeZone().getDisplayName();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("leak-1", dataLeak);
            }
        });
        thread.start();
    }


}
