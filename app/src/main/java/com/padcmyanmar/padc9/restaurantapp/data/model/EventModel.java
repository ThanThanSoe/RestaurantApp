package com.padcmyanmar.padc9.restaurantapp.data.model;

import com.padcmyanmar.padc9.restaurantapp.data.vos.RestaurantVO;

import java.util.List;

public interface EventModel {
    void getEvent(GetEventFromDataLayerDelegate delegate);

    interface GetEventFromDataLayerDelegate{
        void onSuccess(List<RestaurantVO> event);
        void onFailure(String errorMessage);
    }
}
