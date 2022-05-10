package Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import ModelClasses.DataModelClass;

@Dao
public interface DAOClass {

    @Insert
    void insertAllData(DataModelClass dataModelClass);

    @Query("select * from Marvel")
    DataModelClass getAllData();
}
