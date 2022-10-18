package com.example.marvel_demo.data.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.marvel_demo.data.modelClasses.DataModelClass;

@Dao
public interface DAOClass {

    @Insert
    void insertAllData(DataModelClass dataModelClass);

    @Query("select * from Marvel")
    DataModelClass getAllData();
}
