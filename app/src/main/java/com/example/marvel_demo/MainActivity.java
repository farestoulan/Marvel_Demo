package com.example.marvel_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import Adapter.Adapter;
import Database.LocalDataSource;
import Database.MarvelViewModel;
import Database.MyViewModelFactory;
import Database.RemotDataSource;
import Database.Repository;

public class MainActivity extends AppCompatActivity  {



    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        RecyclerView recyclerView;
//        MyViewModelFactory viewModelFactory;
//        RemotDataSource remotDataSource = new RemotDataSource();
//        LocalDataSource localDataSource = new LocalDataSource(getApplicationContext());
//        recyclerView = findViewById(R.id.recyclerView);
//        Repository repository = new Repository(remotDataSource, localDataSource);
//        viewModelFactory = new MyViewModelFactory(repository);
//        MarvelViewModel viewModel = ViewModelProviders.of(this, viewModelFactory)
//                .get(MarvelViewModel.class);
//        viewModel.getVolumesResponseLiveData().observe(this, results -> {
//            Log.i("ahmed_response**", results.data.results.size()+ "");
//            Adapter adaptry = new Adapter(MainActivity.this, results.data.results);
//            recyclerView.setAdapter(adaptry);
//        });
    }
}