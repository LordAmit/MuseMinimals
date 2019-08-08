package edu.wm.cs.semeru.exampleapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TelephonyManager manager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        manager.listen(new PhoneStateListener() {
            @Override
            public void onDataConnectionStateChanged(int state) {
                String dataLeAk = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
                android.util.Log.d("leak-1", dataLeAk);
            }
        }, PhoneStateListener.LISTEN_NONE);
    }
}
