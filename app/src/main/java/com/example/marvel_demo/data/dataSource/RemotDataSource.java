package com.example.marvel_demo.data.dataSource;

import androidx.lifecycle.MutableLiveData;

import com.example.marvel_demo.data.modelClasses.ApiInterface;
import com.example.marvel_demo.data.modelClasses.DataModelClass;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RemotDataSource {

    private static final String BASE_URL = "https://gateway.marvel.com/";
    private  MutableLiveData<DataModelClass> volumesResponseLiveData;


    public Call<DataModelClass> remotData(Callback<DataModelClass> callback) {

        volumesResponseLiveData = new MutableLiveData<DataModelClass>();
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create()).build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<DataModelClass> call = apiInterface.getPhoto();
        call.enqueue(callback);
        return call;
    }

}
