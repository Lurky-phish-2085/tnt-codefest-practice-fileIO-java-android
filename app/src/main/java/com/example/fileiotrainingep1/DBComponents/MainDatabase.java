package com.example.fileiotrainingep1.DBComponents;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {CakeOrder.class}, version = 1)
public abstract class MainDatabase extends RoomDatabase {
    private static MainDatabase instance;
    public abstract CakeDao userDao();

    public static synchronized MainDatabase getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), MainDatabase.class, "testdb1378932475")
                    .fallbackToDestructiveMigrationOnDowngrade().build();
        }
        return instance;
    }
}
