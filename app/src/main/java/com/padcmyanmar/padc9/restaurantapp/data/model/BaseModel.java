package com.padcmyanmar.padc9.restaurantapp.data.model;

import android.content.Context;

import com.padcmyanmar.padc9.restaurantapp.network.dataagents.RetrofitDataAgentImpl;
import com.padcmyanmar.padc9.restaurantapp.persistence.RestaurantDatabase;

public abstract class BaseModel {
    protected RetrofitDataAgentImpl mDataAgent;
    protected RestaurantDatabase mDatabase;

    BaseModel(Context context){
        this.mDataAgent = RetrofitDataAgentImpl.getObjInstance();
        mDatabase = RestaurantDatabase.getObjInstance(context);
    }
}
