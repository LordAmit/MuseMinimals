package edu.wm.cs.semeru.exampleapp;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String dataLeAk = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        android.util.Log.d("leak-1", dataLeAk);
    }
}
