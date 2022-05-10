package Database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import ModelClasses.ListModelClass;
import ModelClasses.Results;

public class Converter {

    @TypeConverter
    public String fromResultList(Results results) {
        if (results == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken() {}.getType();
        String json = gson.toJson(results, type);
        return json;

    }


    @TypeConverter
    public Results toResultList(String resultString) {
        if (resultString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken() {}.getType();
        Results toResultList = gson.fromJson(resultString, type);
        return toResultList;
    }
}
