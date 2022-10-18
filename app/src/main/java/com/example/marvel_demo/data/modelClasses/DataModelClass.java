package com.example.marvel_demo.data.modelClasses;

import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Marvel")
public class DataModelClass {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @Embedded
    public Results data;






}
