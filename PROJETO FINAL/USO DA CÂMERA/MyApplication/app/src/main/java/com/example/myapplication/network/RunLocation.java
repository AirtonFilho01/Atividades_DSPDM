package com.example.myapplication.network;

import android.app.Activity;

import com.example.myapplication.MainActivity;

public class RunLocation extends Thread{
    private MainActivity activity;
    private Location location;

    public RunLocation(MainActivity activity) {
        this.activity = activity;

    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public void run() {

        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                location = new Location(activity);
            }
        });



    }


}
