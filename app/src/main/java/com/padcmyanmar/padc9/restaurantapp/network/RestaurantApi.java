package com.padcmyanmar.padc9.restaurantapp.network;

import com.padcmyanmar.padc9.restaurantapp.network.responses.GetRestaurantResponse;
import com.padcmyanmar.padc9.restaurantapp.until.RestaurantConstants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestaurantApi {
    @GET(RestaurantConstants.GET_RESTAURANTS)
    Call<GetRestaurantResponse> getAllRestaurants();
}
