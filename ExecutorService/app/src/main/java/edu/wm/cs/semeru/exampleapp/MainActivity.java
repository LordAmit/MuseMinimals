package edu.wm.cs.semeru.exampleapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ExecutorService service = Executors.newSingleThreadExecutor();
        service.submit(new Runnable() {
            @Override
            public void run() {
                String dataLeAk = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
                android.util.Log.d("leak-1", dataLeAk);
            }
        });
    }
}
