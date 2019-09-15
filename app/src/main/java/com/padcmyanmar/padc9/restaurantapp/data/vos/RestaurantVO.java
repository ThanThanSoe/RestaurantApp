package com.padcmyanmar.padc9.restaurantapp.data.vos;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "restaurant", indices = {@Index(value = "id", unique = true)})
public class RestaurantVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "restaurant_id_pk")
    private int restaurantIdPK;

    @SerializedName("id")
    @ColumnInfo(name = "id")
    private int id;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    private String name;

    @SerializedName("image_url")
    @ColumnInfo(name = "image_url")
    private String imageUrl;

    @SerializedName("address")
    @ColumnInfo(name = "address")
    private String address;

    @SerializedName("description")
    @ColumnInfo(name = "description")
    private String description;

    @SerializedName("opening_closing_times")
    @Embedded(prefix ="opening_closing_times_")
    //@Ignore
    private OpeningClosingTimesVO openingClosingTimes;

    @SerializedName("rating")
    @ColumnInfo(name = "rating")
    private float rating;

    @SerializedName("restaurant_location")
    @Embedded(prefix ="restaurant_location_")
    //@Ignore
    private RestaurantLocationVO restaurantLocationVO;

    @SerializedName("menus")
    @Ignore
    private List<MenuVO> menuList;

    public int getRestaurantIdPK() {
        return restaurantIdPK;
    }

    public void setRestaurantIdPK(int restaurantIdPK) {
        this.restaurantIdPK = restaurantIdPK;
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

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OpeningClosingTimesVO getOpeningClosingTimes() {
        return openingClosingTimes;
    }

    public void setOpeningClosingTimes(OpeningClosingTimesVO openingClosingTimes) {
        this.openingClosingTimes = openingClosingTimes;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public RestaurantLocationVO getRestaurantLocationVO() {
        return restaurantLocationVO;
    }

    public void setRestaurantLocationVO(RestaurantLocationVO restaurantLocationVO) {
        this.restaurantLocationVO = restaurantLocationVO;
    }

    public List<MenuVO> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<MenuVO> menuList) {
        this.menuList = menuList;
    }
}
