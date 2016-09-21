package de.hama.edvstraf.aktiehq.app;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.widget.Toast;

/**
 * Created by edvstraf on 21.09.2016.
 */

public class EinstellungenActivity extends PreferenceActivity implements Preference.OnPreferenceChangeListener {

    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.preferences);

        SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(this);

        //OnPreferenceChangeListener registrieren
        Preference aktienlistePref = findPreference(getString(R.string.preference_aktienliste_key));
        aktienlistePref.setOnPreferenceChangeListener(this);

        //onPreferenceChange sofort aufrufen mit der in Sharedpreferences gespeicherten Aktienliste
        String gespeicherteAktienliste = sharedPrefs.getString(aktienlistePref.getKey(), "");
        onPreferenceChange(aktienlistePref, gespeicherteAktienliste);

        //OnPreferenceChangeListener für Indexliste registrieren
        Preference indexlistePref = findPreference(getString(R.string.preference_indizeliste_key));
        aktienlistePref.setOnPreferenceChangeListener(this);

        //onPreferenceChange sofort aufrufen mit der in Sharedpreferences gespeicherten Indexliste
        String gespeicherteIndizeliste = sharedPrefs.getString(indexlistePref.getKey(), "");
        onPreferenceChange(indexlistePref, gespeicherteIndizeliste);
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object value){

        preference.setSummary(value.toString());

        return true;
    }
}
