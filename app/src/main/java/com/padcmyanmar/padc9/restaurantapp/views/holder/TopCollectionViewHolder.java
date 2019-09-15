package com.padcmyanmar.padc9.restaurantapp.views.holder;

import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;

import androidx.annotation.BinderThread;
import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.padcmyanmar.padc9.restaurantapp.R;
import com.padcmyanmar.padc9.restaurantapp.data.vos.RestaurantVO;
import com.padcmyanmar.padc9.restaurantapp.delegates.RestaurantItemDelegate;

import org.mmtextview.components.MMTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TopCollectionViewHolder extends BaseViewHolder<RestaurantVO> {

    private RestaurantItemDelegate mRestaurantItemDelegate;

    @BindView(R.id.iv_restaurant)
    ImageView imageUrl;

    @BindView(R.id.name)
    MMTextView name;

    @BindView(R.id.rate)
    MMTextView rate;

    @BindView(R.id.rateingBar)
    RatingBar ratingBar;

    @BindView(R.id.description)
    MMTextView description;

    @BindView(R.id.address)
    MMTextView address;

    public TopCollectionViewHolder(@NonNull View itemView, RestaurantItemDelegate delegate) {
        super(itemView);
        mRestaurantItemDelegate = delegate;
        ButterKnife.bind(this,itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mRestaurantItemDelegate.onTapRestaurantItem(mData.getId());
            }
        });
    }

    @Override
    public void bindData(RestaurantVO data) {
        mData = data;
        Glide.with(itemView).load(data.getImageUrl()).into(imageUrl);
        name.setText(data.getName());
        rate.setText(String.valueOf(data.getRating()));
        description.setText(data.getDescription());
        address.setText(data.getAddress());
        ratingBar.setRating(Float.valueOf(data.getRating()));
    }
}
