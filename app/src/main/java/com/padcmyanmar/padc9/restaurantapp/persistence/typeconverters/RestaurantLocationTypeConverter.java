package com.padcmyanmar.padc9.restaurantapp.persistence.typeconverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.padcmyanmar.padc9.restaurantapp.data.vos.RestaurantLocationVO;

public class RestaurantLocationTypeConverter {
    @TypeConverter
    public static String eventOrganizerToJson(RestaurantLocationVO eventOrganizer){
        return new Gson().toJson(eventOrganizer);
    }

    @TypeConverter
    public static RestaurantLocationVO jsonToEventOrganizser(String eventOrganizerJson){
        return new Gson().fromJson(eventOrganizerJson, RestaurantLocationVO.class);
    }
}
