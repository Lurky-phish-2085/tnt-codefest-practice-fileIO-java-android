package com.example.fileiotrainingep1.DBComponents;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class MainViewModel extends AndroidViewModel implements BasicOperations{
    private MainRepository mainRepository;
    private LiveData<List<CakeOrder>> allUsers;

    public MainViewModel(@NonNull Application application) {
        super(application);
        mainRepository = new MainRepository(application);
        allUsers = mainRepository.getAllOrders();
    }

    @Override
    public void insert(CakeOrder cakeOrder) {
        mainRepository.insert(cakeOrder);
    }

    @Override
    public void update(CakeOrder cakeOrder) {
        mainRepository.update(cakeOrder);
    }

    @Override
    public void delete(CakeOrder cakeOrder) {
        mainRepository.delete(cakeOrder);
    }

    @Override
    public LiveData<List<CakeOrder>> getAllOrders() {
        return allUsers;
    }
}
