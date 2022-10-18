package com.example.marvel_demo.data.repository;


import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.marvel_demo.data.dataSource.LocalDataSource;
import com.example.marvel_demo.data.dataSource.RemotDataSource;
import com.example.marvel_demo.data.modelClasses.DataModelClass;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {
    private final RemotDataSource remoteData;
    private final LocalDataSource localData;


    public Repository(RemotDataSource remoteData, LocalDataSource localData) {
        this.remoteData = remoteData;
        this.localData = localData;

    }

    public MutableLiveData<DataModelClass> getdata() {
        MutableLiveData<DataModelClass> res = new MutableLiveData<>();
        if (remoteData.remotData(new Callback<DataModelClass>() {
            @Override
            public void onResponse(@NonNull Call<DataModelClass> call, @NonNull Response<DataModelClass> response) {
                if (response.body() != null) {
                    localData.insertLocalData(response.body());
                    res.postValue(response.body());
                }
            }

            @Override
            public void onFailure(@NonNull Call<DataModelClass> call, @NonNull Throwable t) {
                res.postValue(null);

            }
        }) != null) {
        } else {
            res.postValue(localData.getLocalData());
        }
//        if (localData.getLocalData() != null) {
//            res.postValue(localData.getLocalData());
//        }
//
//        else {
//                remoteData.remotData(new Callback<DataModelClass>() {
//                    @Override
//                    public void onResponse(Call<DataModelClass> call, Response<DataModelClass> response) {
//                        Log.i("results_fares****", response.body().data.results.get(2).getThumbnail().getPath());
//                        if (response.body() != null) {
//                            localData.insertLocalData(response.body());
//                            res.postValue(response.body());
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<DataModelClass> call, Throwable t) {
//                        Log.i("results_error****", t.getMessage());
//                        res.postValue(null);
//                    }
//                });
//
//            }


        return res;


    }
}
