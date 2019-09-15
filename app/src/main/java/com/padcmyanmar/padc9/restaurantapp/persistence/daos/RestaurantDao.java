package com.padcmyanmar.padc9.restaurantapp.persistence.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.padcmyanmar.padc9.restaurantapp.data.vos.MenuVO;
import com.padcmyanmar.padc9.restaurantapp.data.vos.RestaurantVO;

import java.util.ArrayList;
import java.util.List;

@Dao
public abstract class RestaurantDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public abstract long[] insertRestaurnt(List<RestaurantVO> restaurants);

    @Query("select * from restaurant")
    public abstract List<RestaurantVO> getAllRestaurantFromDB();

    @Query("select * from restaurant where id=:id")
    public abstract RestaurantVO getRestaurantById(int id);

    public void insertRestauarntAndMenu(List<RestaurantVO> restaurants, MenuDao menuDao){
        List<MenuVO> menuList = new ArrayList<>();

        for (RestaurantVO restaurantVo: restaurants) {
            for (MenuVO menu: restaurantVo.getMenuList()) {
                menu.setRestaurantId(restaurantVo.getId());
                menuList.add(menu);
            }
        }
        insertRestaurnt(restaurants);
        menuDao.insertMenu(menuList);
    }

}
