package ModelClasses;

import androidx.annotation.NonNull;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "Marvel")
public class DataModelClass {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @Embedded
    public Results data;






}
