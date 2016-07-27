package com.example.android.sunshine.app;

import android.app.Activity;
import android.os.Bundle;

import com.example.android.sunshine.app.SettingsFragment;

public class SettingsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }



}