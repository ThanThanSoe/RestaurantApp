package com.padcmyanmar.padc9.restaurantapp.network.dataagents;

import com.padcmyanmar.padc9.restaurantapp.network.RestaurantApi;
import com.padcmyanmar.padc9.restaurantapp.network.responses.GetRestaurantResponse;
import com.padcmyanmar.padc9.restaurantapp.until.RestaurantConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgentImpl implements RestaurantDataAgent {
    public static RetrofitDataAgentImpl objInstance;

    private RestaurantApi mRestaurantApi;

    public RetrofitDataAgentImpl(){
        final OkHttpClient mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RestaurantConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(mOkHttpClient)
                .build();
        mRestaurantApi = retrofit.create(RestaurantApi.class);
    }
    public static RetrofitDataAgentImpl getObjInstance(){
        if(objInstance == null){
            objInstance = new RetrofitDataAgentImpl();
        }return objInstance;
    }
    @Override
    public void getRestaurants(String accessToken, final GetRestaurantForNetworkDelegate delegate) {
        Call<GetRestaurantResponse> restaurantsCall = mRestaurantApi.getAllRestaurants();

        restaurantsCall.enqueue(new Callback<GetRestaurantResponse>() {
            @Override
            public void onResponse(Call<GetRestaurantResponse> call, Response<GetRestaurantResponse> response) {
                GetRestaurantResponse getRestaurantResponse = response.body();
                delegate.onSuccess(getRestaurantResponse.getRestaurantList());
            }

            @Override
            public void onFailure(Call<GetRestaurantResponse> call, Throwable t) {
                delegate.onFailure(t.getLocalizedMessage());
            }
        });
    }
}
