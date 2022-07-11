package com.example.myapplication.network;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.myapplication.MainActivity;

import java.util.List;

public class Location implements LocationListener {

    LocationManager locationManager;
    double lat;
    double log;
    MainActivity activity;

    @SuppressLint("MissingPermission")
    public Location(MainActivity activity) {
        this.activity = activity;


        locationManager = (LocationManager) activity.getSystemService(Context.LOCATION_SERVICE);

        //APRESENTOU BUG
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,2000,0,this);

    }


    @Override
    public void onLocationChanged(@NonNull android.location.Location location) {
        this.log = location.getLongitude();
        this.lat = location.getLatitude();

        if (log != 0.0 && lat != 0.0)
            activity.setUltimaLocalizacao(location);

        Log.e("TESTE", String.valueOf(log));
    }

    @Override
    public void onLocationChanged(@NonNull List<android.location.Location> locations) {
        LocationListener.super.onLocationChanged(locations);
    }

    @Override
    public void onFlushComplete(int requestCode) {
        LocationListener.super.onFlushComplete(requestCode);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        LocationListener.super.onStatusChanged(provider, status, extras);
    }

    @Override
    public void onProviderEnabled(@NonNull String provider) {
        LocationListener.super.onProviderEnabled(provider);
    }

    @Override
    public void onProviderDisabled(@NonNull String provider) {
        LocationListener.super.onProviderDisabled(provider);
    }

    public LocationManager getLocationManager() {
        return locationManager;
    }

    public void setLocationManager(LocationManager locationManager) {
        this.locationManager = locationManager;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLog() {
        return log;
    }

    public void setLog(double log) {
        this.log = log;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }
}
