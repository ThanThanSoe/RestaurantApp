package com.padcmyanmar.padc9.restaurantapp.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.padcmyanmar.padc9.restaurantapp.data.model.RestaurantModelImpl;

public abstract class BaseActivity extends AppCompatActivity {
    protected RestaurantModelImpl restaurantModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        restaurantModel = RestaurantModelImpl.getObjInstance();
    }
    protected void showIndefiniteSnackBar(String message){
        final Snackbar snackbar = Snackbar.make(getWindow().getDecorView(),message,Snackbar.LENGTH_INDEFINITE);

    }
}
