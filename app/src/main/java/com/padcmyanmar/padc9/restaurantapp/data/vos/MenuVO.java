package com.padcmyanmar.padc9.restaurantapp.data.vos;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "menu", foreignKeys = {@ForeignKey(entity = RestaurantVO.class, parentColumns = "id", childColumns = "restaurant_id")},indices = {@Index(value = "restaurant_id",unique = true)})
public class MenuVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "menu_id_pk")
    private int menuIdPK;

    @SerializedName("id")
    @ColumnInfo(name = "id")
    private int id;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    private String name;

    @SerializedName("price")
    @ColumnInfo(name = "price")
    private Long price;

    @ColumnInfo(name = "restaurant_id")
    private int restaurantId;

    public int getMenuIdPK() {
        return menuIdPK;
    }

    public void setMenuIdPK(int menuIdPK) {
        this.menuIdPK = menuIdPK;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }
}
