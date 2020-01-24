package com.example.helloandroid;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      String dataLeAk = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
      android.util.Log.d("leak-1", dataLeAk);
   }
}
