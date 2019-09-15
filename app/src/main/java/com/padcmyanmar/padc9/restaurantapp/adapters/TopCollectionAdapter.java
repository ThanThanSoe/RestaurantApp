package com.padcmyanmar.padc9.restaurantapp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.padcmyanmar.padc9.restaurantapp.R;
import com.padcmyanmar.padc9.restaurantapp.data.vos.RestaurantVO;
import com.padcmyanmar.padc9.restaurantapp.delegates.RestaurantItemDelegate;
import com.padcmyanmar.padc9.restaurantapp.views.holder.TopCollectionViewHolder;

public class TopCollectionAdapter  extends BaseRecyclerAdapter<TopCollectionViewHolder, RestaurantVO> {
    private RestaurantItemDelegate mRestaurantItemDelegate;

    public TopCollectionAdapter(RestaurantItemDelegate mRestaurantItemDelegate){
        this.mRestaurantItemDelegate = mRestaurantItemDelegate;
    }

    @NonNull
    @Override
    public TopCollectionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.top_collection_item_view,parent,false);

        return new TopCollectionViewHolder(itemView, mRestaurantItemDelegate);
    }
}
