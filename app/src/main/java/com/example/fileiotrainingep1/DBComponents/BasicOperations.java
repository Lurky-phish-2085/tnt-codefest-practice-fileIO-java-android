package com.example.fileiotrainingep1.DBComponents;

import androidx.lifecycle.LiveData;

import java.util.List;

public interface BasicOperations {
    void insert(CakeOrder cakeOrder);
    void update(CakeOrder cakeOrder);
    void delete(CakeOrder cakeOrder);
    LiveData<List<CakeOrder>> getAllOrders();
}
