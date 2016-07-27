package com.example.android.sunshine.app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class MainActivity extends ActionBarActivity {

    private final String LOG_TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ForecastFragment())
                    .commit();
        }

        Log.i(LOG_TAG,"On Create");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the detail; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent settingsIntent = new Intent(this,SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }
        else if (R.id.action_location_map == item.getItemId()){
            resolveMapLocation();
        }

        return super.onOptionsItemSelected(item);
    }

    private void resolveMapLocation() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        String location = sharedPreferences.getString(getString(R.string.pref_location_key),getString(R.string.pref_location_default));

        Intent mapIntend = new Intent();
        mapIntend.setAction(Intent.ACTION_VIEW);
        String uri = String.format(Locale.ENGLISH, "geo:0,0?q=%s", location);
        mapIntend.setData(Uri.parse(uri));

        // Verify that the intent will resolve to an activity
        if (mapIntend.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntend);
        }
        else{
            Log.i(LOG_TAG,"No app available to show our location");
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LOG_TAG,"On Pause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOG_TAG,"On Resume");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG,"On Destroy");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LOG_TAG,"On Stop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LOG_TAG,"On Start");
    }
}


