package com.padcmyanmar.padc9.restaurantapp.data.model;

import android.content.Context;

import com.padcmyanmar.padc9.restaurantapp.data.vos.RestaurantVO;
import com.padcmyanmar.padc9.restaurantapp.network.dataagents.RestaurantDataAgent;
import com.padcmyanmar.padc9.restaurantapp.until.RestaurantConstants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantModelImpl extends BaseModel implements EventModel {
    private Map<Integer, RestaurantVO> restaurantDataRepository;
    private static RestaurantModelImpl objInstance;


    RestaurantModelImpl(Context context) {
        super(context);
        restaurantDataRepository = new HashMap<>();
    }

    public static void initializeEventModel (Context context){
        objInstance = new RestaurantModelImpl(context);
    }

    public static RestaurantModelImpl getObjInstance(){
        if (objInstance == null){
            throw new RuntimeException(RestaurantConstants.EM_RESTAURANT_MODEL_NOT_INITIAL);
        }
        return objInstance;
    }

    @Override
    public void getEvent(final GetEventFromDataLayerDelegate delegate) {
       if(mDatabase.areRestaurantsExistInDB()){
           List<RestaurantVO> restaruantFromDB = mDatabase.restaurantDao().getAllRestaurantFromDB();
           delegate.onSuccess(restaruantFromDB);
       }else {
           mDataAgent.getRestaurants(RestaurantConstants.DUMMY_ACCESS_TOKEN, new RestaurantDataAgent.GetRestaurantForNetworkDelegate() {
               @Override
               public void onSuccess(List<RestaurantVO> restaurant) {
                    mDatabase.restaurantDao().insertRestauarntAndMenu(restaurant, mDatabase.menuDao());
                    delegate.onSuccess(restaurant);
               }

               @Override
               public void onFailure(String errorMessage) {
                    delegate.onFailure(errorMessage);
               }
           });
       }
    }


    public List<RestaurantVO> filterResturant(String query) {
        List<RestaurantVO> restaurantVOList = mDatabase.restaurantDao().getAllRestaurantFromDB();
        List<RestaurantVO> result = new ArrayList<>();
        for (RestaurantVO restaurantVO : restaurantVOList){
            if (restaurantVO.getName().contains(query));
            result.add(restaurantVO);
        }
        return result;
    }

    public RestaurantVO findRestarantById(int restaurantId){
        RestaurantVO restaurantVO = mDatabase.restaurantDao().getRestaurantById(restaurantId);
        return restaurantVO;
    }
}
