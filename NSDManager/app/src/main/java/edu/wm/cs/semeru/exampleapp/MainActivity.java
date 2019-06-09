package edu.wm.cs.semeru.exampleapp;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    private String SERVICE_TYPE = "_http._tcp.";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final NsdManager nsdManager = (NsdManager)this.getSystemService(Context.NSD_SERVICE);

        NsdManager.DiscoveryListener listener = new NsdManager.DiscoveryListener() {

            String dataLeak = "";

            @Override
            public void onStartDiscoveryFailed(String s, int i) {

            }

            @Override
            public void onStopDiscoveryFailed(String s, int i) {

            }

            @Override
            public void onDiscoveryStarted(String serviceType) {
                dataLeak = java.util.Calendar.getInstance().getTimeZone().getDisplayName();

            }

            @Override
            public void onDiscoveryStopped(String s) {

            }

            @Override
            public void onServiceFound(NsdServiceInfo serviceInfo) {

                NsdManager.ResolveListener resolver = new NsdManager.ResolveListener() {

                    @Override
                    public void onResolveFailed(NsdServiceInfo serviceInfo, int errorCode) {
                        Log.d("leak", dataLeak);
                    }

                    @Override
                    public void onServiceResolved(NsdServiceInfo serviceInfo) {
                        Log.d("leak", dataLeak);
                    }
                };
                nsdManager.resolveService(serviceInfo, resolver);
            }

            @Override
            public void onServiceLost(NsdServiceInfo nsdServiceInfo) {

            }
        };
        nsdManager.discoverServices(SERVICE_TYPE, NsdManager.PROTOCOL_DNS_SD, listener);
    }


}
