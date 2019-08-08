package edu.wm.cs.semeru.runonuithread;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String dataLeAk = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
                android.util.Log.d("leak-1", dataLeAk);
            }
        });
    }
}
