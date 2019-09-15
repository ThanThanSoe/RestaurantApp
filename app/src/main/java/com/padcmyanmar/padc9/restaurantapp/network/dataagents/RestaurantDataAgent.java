package com.padcmyanmar.padc9.restaurantapp.network.dataagents;

import com.padcmyanmar.padc9.restaurantapp.data.vos.RestaurantVO;

import java.util.List;

public interface RestaurantDataAgent {
    void getRestaurants(String accessToken, GetRestaurantForNetworkDelegate delegate);
    interface GetRestaurantForNetworkDelegate{
        void onSuccess(List<RestaurantVO> restaurant);
        void onFailure(String errorMessage);
    }
}
