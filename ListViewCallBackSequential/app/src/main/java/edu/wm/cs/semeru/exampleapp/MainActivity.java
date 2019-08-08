package edu.wm.cs.semeru.exampleapp;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

import static android.R.layout.simple_list_item_1;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Example> examples = new ArrayList<Example>();
        examples.add(new Example());
        ListView serviceTable = (ListView) findViewById(R.id.listview);
        serviceTable.setAdapter(new ArrayAdapter<Example>(this,
                simple_list_item_1, examples));
        serviceTable.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Example example = (Example) parent.getItemAtPosition(position);
                example.foo();
                example.bar();
            }
        });
    }

    private class Example {
        String dataLeAk;

        public void foo() {
            dataLeAk = Calendar.getInstance().getTimeZone().getDisplayName();
        }
        public void bar() {
            Log.d("leak", dataLeAk);
        }
    }
}