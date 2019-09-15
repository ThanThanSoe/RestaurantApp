package com.padcmyanmar.padc9.restaurantapp.persistence.typeconverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.padcmyanmar.padc9.restaurantapp.data.vos.OpeningClosingTimesVO;

public class OpeningClosingTimesTypeConverter {
    @TypeConverter
    public static String eventOrganizerToJson(OpeningClosingTimesVO eventOrganizer){
        return new Gson().toJson(eventOrganizer);
    }

    @TypeConverter
    public static OpeningClosingTimesVO jsonToEventOrganizser(String eventOrganizerJson){
        return new Gson().fromJson(eventOrganizerJson, OpeningClosingTimesVO.class);
    }
}
