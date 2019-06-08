package edu.wm.cs.semeru.exampleapp;

import android.Manifest;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    private static final int MY_PERMISSIONS_REQUEST_Location = 0;
    private LocationListener locationListener = new LocationListener() {
        private String dataLeak = "";

        @Override
        public void onLocationChanged(Location location) {
            Log.d("leak", dataLeak);
        }

        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {
            Log.d("info", "status changed");
            dataLeak = java.util.Calendar.getInstance().getTimeZone().getDisplayName();
        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("info", "initial");
        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(
                        this, Manifest.permission.ACCESS_COARSE_LOCATION) !=
                        PackageManager.PERMISSION_GRANTED) {
            Log.d("info", "permission denied");

            Log.d("info", "requesting permission");

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, MY_PERMISSIONS_REQUEST_Location);

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, MY_PERMISSIONS_REQUEST_Location);
        } else {
            Log.d("info", "requesting has permission");
            LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListener);
        }
    }


}
