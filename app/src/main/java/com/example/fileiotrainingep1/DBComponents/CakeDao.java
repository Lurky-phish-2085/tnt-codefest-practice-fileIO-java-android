package com.example.fileiotrainingep1.DBComponents;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface CakeDao {
    @Insert
    void insert(CakeOrder cakeOrder);
    @Update
    void update(CakeOrder cakeOrder);
    @Delete
    void delete(CakeOrder cakeOrder);
    @Query("SELECT * FROM cake_table")
    LiveData<List<CakeOrder>> getAllOrders();
}
