package com.example.marvel_demo.data.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import com.example.marvel_demo.data.modelClasses.ListModelClass;

public class Converter {
    @TypeConverter
    public static List<ListModelClass> fromString(String value) {
        Type listType = new TypeToken<List<ListModelClass>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(List<ListModelClass> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }
}


