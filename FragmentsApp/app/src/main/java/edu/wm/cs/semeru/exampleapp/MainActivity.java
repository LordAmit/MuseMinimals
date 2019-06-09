package edu.wm.cs.semeru.exampleapp;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.Calendar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Fragment test = new LeakyFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.container, test).commit();
    }
    public static class LeakyFragment extends Fragment {
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            String dataLeak = Calendar.getInstance().getTimeZone().getDisplayName();
            Log.d("leak-1", dataLeak);
            return inflater.inflate(R.layout.fragment_leaky, container, false);
        }
    }

}
