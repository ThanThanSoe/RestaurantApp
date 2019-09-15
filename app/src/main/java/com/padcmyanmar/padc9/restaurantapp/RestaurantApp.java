package com.padcmyanmar.padc9.restaurantapp;

import android.app.Application;

import com.padcmyanmar.padc9.restaurantapp.data.model.RestaurantModelImpl;

public class RestaurantApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RestaurantModelImpl.initializeEventModel(getApplicationContext());
    }
}
