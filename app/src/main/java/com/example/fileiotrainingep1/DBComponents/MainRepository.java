package com.example.fileiotrainingep1.DBComponents;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class MainRepository implements BasicOperations {
    private CakeDao cakeDao;
    private LiveData<List<CakeOrder>> allUsers;

    public MainRepository(Application application) {
        MainDatabase db = MainDatabase.getInstance(application);
        cakeDao = db.userDao();
    }

    @Override
    public void insert(CakeOrder cakeOrder) {
        new AsyncRepoTask(cakeDao, cakeOrder, 1).execute();
    }

    @Override
    public void update(CakeOrder cakeOrder) {
        new AsyncRepoTask(cakeDao, cakeOrder, 3).execute();
    }

    @Override
    public void delete(CakeOrder cakeOrder) {
        new AsyncRepoTask(cakeDao, cakeOrder, 2).execute();
    }

    @Override
    public LiveData<List<CakeOrder>> getAllOrders() {
        return allUsers;
    }


    private static class AsyncRepoTask extends AsyncTask<Void, Void, Void>{
        private CakeDao cakeDao;
        private CakeOrder cakeOrder;
        private int mode;

        public AsyncRepoTask(CakeDao cakeDao, CakeOrder cakeOrder, int mode) {
            this.cakeDao = cakeDao;
            this.cakeOrder = cakeOrder;
            this.mode = mode;
        }


        @Override
        protected Void doInBackground(Void... voids) {
            switch(mode){
                case 1:
                    cakeDao.insert(cakeOrder);
                    break;
                case 2:
                    cakeDao.delete(cakeOrder);
                    break;
                case 3:
                    cakeDao.update(cakeOrder);
                    break;
            }
            return null;
        }
    }
}
