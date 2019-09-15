package com.padcmyanmar.padc9.restaurantapp.adapters;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.padcmyanmar.padc9.restaurantapp.views.holder.BaseViewHolder;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseRecyclerAdapter<T extends BaseViewHolder<w>,w>extends RecyclerView.Adapter<T> {
    private List<w> mData;

    public BaseRecyclerAdapter(){
        this.mData = new ArrayList<>();
    }
    @Override
    public void onBindViewHolder(@NonNull T holder, int position) {
        holder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void setNewData(List<w> data){
        mData = data;
        notifyDataSetChanged();
    }
}
