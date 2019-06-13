package com.example.variantroute;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    int i = 0;
    String dataLeAk1 = "0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        if (savedInstanceState == null) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, new SimpleFragment())
                .commit();
//        }


        habijabi();

    }


    private void habijabi(){
        dataLeAk1 = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
    }


    public void button1Clicked(View view) {

        TextView t = findViewById(R.id.textView);

        t.setText(generateString());

    }

    private String generateString() {
        String counter = "Counter: " + i;
        i++;
        android.util.Log.d("leak-1-0", dataLeAk1);


        return counter;
    }

    public void button2Clicked(View view) {
        TextView t = findViewById(R.id.textView);

        t.setText(generateString());

    }


    public static class SimpleFragment extends Fragment {


        public SimpleFragment() {
            // Required empty public constructor

        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View rootView = inflater.inflate(R.layout.fragment_simple, container, false);
            return rootView;
        }

    }
}
