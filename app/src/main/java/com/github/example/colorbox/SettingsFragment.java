package com.github.example.colorbox;

import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.github.colorbox.ColorBox;

public class SettingsFragment extends PreferenceFragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public void onResume() {
        super.onResume();

        ColorBox.registerPreferenceUpdater(getActivity());
    }
}