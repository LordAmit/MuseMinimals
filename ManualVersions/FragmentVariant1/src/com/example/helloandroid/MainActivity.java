package com.example.helloandroid;


import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.app.Fragment;

public class MainActivity extends Activity {
   int i = 0;
   static String dataLeAk0 = "0";
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      dataLeAk0 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
      getFragmentManager().beginTransaction()
      .add(R.id.container, new SimpleFragment())
      .commit();
//        }
   }

   public void buttonClicked(View view) {
      //        android.util.Log.d("amit", "button clicked");
              TextView t = (TextView)findViewById(R.id.textView);
              String counter = "Counter: " + i;
              i++;
              t.setText(counter);
      
   }
   
   public static class SimpleFragment extends Fragment {


      public SimpleFragment() {
          // Required empty public constructor
         //  android.util.Log.d("leak-0-1", dataLeAk0);
      }


      @Override
      public View onCreateView(LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState) {
         android.util.Log.d("leak-0-1", dataLeAk0);

          // Inflate the layout for this fragment
         View rootView = inflater.inflate(R.layout.fragment_simple, container, false);
         return rootView;
//            return inflater.inflate(R.layout.fragment_simple, container, false);
      }

  }
}
