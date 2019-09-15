package com.padcmyanmar.padc9.restaurantapp.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.padcmyanmar.padc9.restaurantapp.R;
import com.padcmyanmar.padc9.restaurantapp.data.vos.RestaurantVO;

import org.mmtextview.components.MMTextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends BaseActivity{

    public static final String EXTERNAL_RESTAURANT_ID = "restaurantExtra";

    public static Intent newIntent(Context context, int eventExtra){
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(EXTERNAL_RESTAURANT_ID, eventExtra);
        return intent;
    }
    @BindView(R.id.vp_details_images)
    ImageView imageUrl;

    @BindView(R.id.name)
    MMTextView name;

    @BindView(R.id.description)
    MMTextView description;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        int restaurantId =getIntent().getIntExtra(EXTERNAL_RESTAURANT_ID, 0);
        final RestaurantVO restaurantVO = restaurantModel.findRestarantById(restaurantId);
        restaurantVO.getRestaurantLocationVO();
        bindData(restaurantVO);


    }

    private void bindData(RestaurantVO data){
        Glide.with(imageUrl.getContext()).load(data.getImageUrl()).into(imageUrl);
        name.setText(data.getName());
        description.setText(data.getDescription());
    }
}
