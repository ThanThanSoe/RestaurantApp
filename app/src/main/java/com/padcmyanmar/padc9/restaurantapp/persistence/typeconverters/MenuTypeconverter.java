package com.padcmyanmar.padc9.restaurantapp.persistence.typeconverters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.padcmyanmar.padc9.restaurantapp.data.vos.MenuVO;

import java.lang.reflect.Type;
import java.util.List;

public class MenuTypeconverter {
    @TypeConverter
    public static String usersToJson(List<MenuVO> user){
        return new Gson().toJson(user);
    }

    @TypeConverter
    public static List<MenuVO> jsonToUsers(String userJson){
        Type userListType = new TypeToken<List<MenuVO>>(){}.getType();
        return new Gson().fromJson(userJson, userListType);
    }
}
