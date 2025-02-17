/*
 *  Zenmotions
 *  by SagarMakhar
 */

package com.asus.zenmotions;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.support.v14.preference.PreferenceFragment;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceCategory;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.preference.PreferenceScreen;
import android.support.v14.preference.SwitchPreference;
import android.support.v7.preference.TwoStatePreference;
import android.provider.Settings;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuInflater;
import android.app.Fragment;

import com.asus.zenmotions.settings.ScreenOffGestureSettings;
import com.asus.zenmotions.gestures.AmbientGesturePreferenceActivity;
import com.asus.zenmotions.kcal.DisplayCalibration;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Date;

import android.util.Log;
import android.os.SystemProperties;
import java.io.*;
import android.widget.Toast;

import com.asus.zenmotions.R;

public class Zenmotions extends PreferenceFragment implements
        Preference.OnPreferenceChangeListener {
    private static final boolean DEBUG = true;
    private static final String TAG = "Zenmotions";

    private Preference mKcalPref;
    private Preference mAmbientPref;
    private Preference mGesturesPref;
    private Context mContext;
    private SharedPreferences mPreferences;

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
        setPreferencesFromResource(R.xml.zenmotions, rootKey);
        mGesturesPref = findPreference("screen_gestures");
                mGesturesPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                     @Override
                     public boolean onPreferenceClick(Preference preference) {
                         Intent intent = new Intent(getContext(), ScreenOffGestureSettings.class);
                         startActivity(intent);
                         return true;
                     }
                });
	mAmbientPref = findPreference("ambient_display_gestures");
               mAmbientPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                     @Override
                     public boolean onPreferenceClick(Preference preference) {
                         Intent intent = new Intent(getContext(), AmbientGesturePreferenceActivity.class);
                         startActivity(intent);
                         return true;
                     }
                });

	mKcalPref = findPreference("kcal");
                mKcalPref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
                     @Override
                     public boolean onPreferenceClick(Preference preference) {
                         Intent intent = new Intent(getContext(), DisplayCalibration.class);
                         startActivity(intent);
                         return true;
                     }
                });
}

    @Override
    public boolean onPreferenceTreeClick(Preference preference) {
        return super.onPreferenceTreeClick(preference);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case android.R.id.home:
            return true;
        default:
            break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        final String key = preference.getKey();
        return true;
    }
}
