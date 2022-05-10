package ModelClasses;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;
@Entity(tableName = "Marvel")
public class DataModelClass {

    @PrimaryKey(autoGenerate = true)
    public int id;
    @SerializedName("data")
    public Results data;






}
