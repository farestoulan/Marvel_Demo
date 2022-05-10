package Database;

import android.content.Context;

import ModelClasses.DataModelClass;

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
