package com.padcmyanmar.padc9.restaurantapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.padcmyanmar.padc9.restaurantapp.R;
import com.padcmyanmar.padc9.restaurantapp.adapters.TopCollectionAdapter;
import com.padcmyanmar.padc9.restaurantapp.data.model.EventModel;
import com.padcmyanmar.padc9.restaurantapp.data.vos.RestaurantVO;
import com.padcmyanmar.padc9.restaurantapp.delegates.RestaurantItemDelegate;
import com.padcmyanmar.padc9.restaurantapp.delegates.TopCollectionItemViewDelegate;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements RestaurantItemDelegate, TopCollectionItemViewDelegate {

    @BindView(R.id.rv_top_collection)
    RecyclerView recyclerView;

    TopCollectionAdapter adapter;

   /* @BindView(R.id.et_location)
    EditText etLocation;

    @BindView(R.id.ic_search)
    ImageView icSearch;*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        adapter = new TopCollectionAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(adapter);

        restaurantModel.getEvent(new EventModel.GetEventFromDataLayerDelegate() {
            @Override
            public void onSuccess(List<RestaurantVO> event) {
                adapter.setNewData(event);
            }

            @Override
            public void onFailure(String errorMessage) {
                showIndefiniteSnackBar(errorMessage);
            }
        });

        final EditText etLocation = findViewById(R.id.et_location);
        ImageView icSearch= findViewById(R.id.ic_search);
        icSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String searchWord = etLocation.getText().toString();
                onSearchFilter(searchWord);
            }
        });

    }

    @Override
    public void onTapRestaurantItem(int restaurantId) {
        Intent intent = DetailActivity.newIntent(getApplicationContext(), restaurantId);
        startActivity(intent);
    }

    @Override
    public void onSearchFilter(String searchWord) {
        List<RestaurantVO> resultList = restaurantModel.filterResturant(searchWord);
        adapter.setNewData(resultList);
    }
}
