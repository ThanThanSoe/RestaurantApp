package com.padcmyanmar.padc9.restaurantapp.persistence;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.padcmyanmar.padc9.restaurantapp.data.vos.MenuVO;
import com.padcmyanmar.padc9.restaurantapp.data.vos.RestaurantVO;
import com.padcmyanmar.padc9.restaurantapp.persistence.daos.MenuDao;
import com.padcmyanmar.padc9.restaurantapp.persistence.daos.RestaurantDao;
import com.padcmyanmar.padc9.restaurantapp.until.RestaurantConstants;

@Database(entities = {RestaurantVO.class, MenuVO.class},version = 2, exportSchema = false)
public abstract class RestaurantDatabase extends RoomDatabase {
    public abstract RestaurantDao restaurantDao();

    public abstract MenuDao menuDao();

    private static RestaurantDatabase objInstance;

    public static RestaurantDatabase getObjInstance(Context context){
        if (objInstance == null){
            objInstance = Room.databaseBuilder(context, RestaurantDatabase.class, RestaurantConstants.RESTAURANT_DB)
            .allowMainThreadQueries()
            .fallbackToDestructiveMigration()
            .build();
        }
        return objInstance;
    }

    public boolean areRestaurantsExistInDB(){
        return !restaurantDao().getAllRestaurantFromDB().isEmpty();
    }


}
