package com.padcmyanmar.padc9.restaurantapp.network.responses;

import com.google.gson.annotations.SerializedName;
import com.padcmyanmar.padc9.restaurantapp.data.vos.RestaurantVO;
import com.padcmyanmar.padc9.restaurantapp.until.RestaurantConstants;

import java.util.List;

public class GetRestaurantResponse {
    @SerializedName("code")
    private int code;

    @SerializedName("message")
    private String message;

    @SerializedName("data")
    private List<RestaurantVO> restaurantList;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<RestaurantVO> getRestaurantList() {
        return restaurantList;
    }

    public void setRestaurantList(List<RestaurantVO> restaurantList) {
        this.restaurantList = restaurantList;
    }

    /*public Boolean isResponseOK(){
        return code == RestaurantConstants.CODE_RESPONSE_OK && restaurantList != null;
    }*/
}
