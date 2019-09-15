package com.padcmyanmar.padc9.restaurantapp.persistence.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.padcmyanmar.padc9.restaurantapp.data.vos.MenuVO;

import java.util.List;
@Dao
public interface MenuDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long[] insertMenu(List<MenuVO> menus);

   /*@Query("select * from menu")
    List<MenuVO> getAllMenuFromDB;*/
}
