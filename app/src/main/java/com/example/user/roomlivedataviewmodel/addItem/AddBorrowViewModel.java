package com.example.user.roomlivedataviewmodel.addItem;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.example.user.roomlivedataviewmodel.AppDatabase;
import com.example.user.roomlivedataviewmodel.BorrowModel;

public class AddBorrowViewModel extends AndroidViewModel {

    private AppDatabase appDatabase;


    public AddBorrowViewModel(@NonNull Application application) {
        super(application);

        appDatabase = AppDatabase.getDatabase(this.getApplication());
    }

    public void addBorrow(final BorrowModel borrowModel){

        new addAssyncTask(appDatabase).execute(borrowModel);

    }


    private static class addAssyncTask extends AsyncTask<BorrowModel, Void, Void> {
        private AppDatabase db;

        addAssyncTask(AppDatabase db) {
            this.db = db;
        }

        @Override
        protected Void doInBackground(BorrowModel... borrowModels) {
            db.itemAndPersonModel().addBorrow(borrowModels[0]);
            return null;
        }
    }





}
