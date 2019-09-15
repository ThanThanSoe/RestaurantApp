package com.padcmyanmar.padc9.restaurantapp.data.vos;

import androidx.room.ColumnInfo;

import com.google.gson.annotations.SerializedName;

public class RestaurantLocationVO {

    @SerializedName("latitude")
    @ColumnInfo(name = "latitude")
    private float latitude;

    @SerializedName("longitude")
    @ColumnInfo(name = "longitude")
    private float longitude;

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
