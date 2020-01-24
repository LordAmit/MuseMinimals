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
   static String dataLeAk1 = "0";
   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_main);
      getFragmentManager().beginTransaction()
      .add(R.id.container, new SimpleFragment())
      .commit();
      habijabi();

//        }
   }
   private void habijabi(){
    dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
}

   public void buttonClicked(View view) {

      
      TextView t = (TextView)findViewById(R.id.textView);

      t.setText(generateString());

  }

  private String generateString(){
      android.util.Log.d("leak-1-0", dataLeAk1);

      String counter = "Counter: "+i;
      i++;
      return counter;
  }

  public void button2Clicked(View view) {
      TextView t = (TextView)findViewById(R.id.textView);

      t.setText(generateString());

  }
   
   public static class SimpleFragment extends Fragment {


      public SimpleFragment() {
          // Required empty public constructor
         //  android.util.Log.d("leak-0-1", dataLeAk0);
      }


      @Override
      public View onCreateView(LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState) {
          // Inflate the layout for this fragment
         View rootView = inflater.inflate(R.layout.fragment_simple, container, false);
         return rootView;
//            return inflater.inflate(R.layout.fragment_simple, container, false);
      }

  }
}
