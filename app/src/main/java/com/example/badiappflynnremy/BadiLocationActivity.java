package com.example.badiappflynnremy;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.gms.maps.model.LatLng;

import org.osmdroid.api.IMapController;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BadiLocationActivity extends AppCompatActivity {

    MapView map = null;
    String badiName;
    Double latitude;
    Double longitude;
    GeoPoint geoPoint;

    //In der OnCreate Methode wird hauptsächlich die Karte initialisiert und angezeigt.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Context ctx = getApplicationContext();
        Configuration.getInstance().load(ctx, PreferenceManager.getDefaultSharedPreferences(ctx));
        setContentView(R.layout.activity_badi_location);
        map = (MapView) findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);
        Intent intent = getIntent();
        badiName = intent.getStringExtra("badiOrt");
        getBadiOrt();
        IMapController mapController = map.getController();
        mapController.setZoom(18.5);
        mapController.setCenter(geoPoint);

        setTitle(R.string.location);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        map.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        map.onPause();
    }

    //Latitude und Longitude vom Ort holen, damit man den Startpunkt der Karte dorthin setzen kann.
    private void getBadiOrt() {
        if (Geocoder.isPresent()) {
            try {
                Geocoder gc = new Geocoder(this);
                List<Address> adressen = new ArrayList<Address>();
                adressen = gc.getFromLocationName(badiName, 1); // get the found Address Objects

                for (Address a : adressen) {
                    if (a.hasLatitude() && a.hasLongitude()) {
                        latitude = a.getLatitude();
                        longitude = a.getLongitude();
                    }
                }
                geoPoint = new GeoPoint(latitude, longitude);
            } catch (IOException e) {
                generateAlertDialog();
            }
        }
    }

    //Generelle Fehlermeldung
    private void generateAlertDialog() {
        AlertDialog.Builder dialogBuilder;
        dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {             // Closes this activity
                finish();
            }
        });
        dialogBuilder.setMessage(R.string.alert_description_data_fail).setTitle(R.string.alert);
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
    }
}
