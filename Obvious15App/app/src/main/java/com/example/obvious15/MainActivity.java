package com.example.obvious15;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String dataLeAk = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        android.util.Log.d("leak-1", dataLeAk);
    }
}
