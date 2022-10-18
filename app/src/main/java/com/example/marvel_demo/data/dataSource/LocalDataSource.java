package com.example.marvel_demo.data.dataSource;

import android.content.Context;

import com.example.marvel_demo.data.modelClasses.DataModelClass;

import com.example.marvel_demo.data.database.DAOClass;
import com.example.marvel_demo.data.database.DatabaseClass;

public class LocalDataSource {

    DAOClass dao;
    DatabaseClass database;

    public LocalDataSource(Context context) {
        database = DatabaseClass.getDatabase(context);
        dao = database.getDao();
    }

    public DataModelClass getLocalData() {
        return dao.getAllData();
    }

    public void insertLocalData(DataModelClass dataModelClass) {
        dao.insertAllData(dataModelClass);
    }
}
