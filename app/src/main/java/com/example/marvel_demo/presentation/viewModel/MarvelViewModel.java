package com.example.marvel_demo.presentation.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.marvel_demo.data.modelClasses.DataModelClass;

import com.example.marvel_demo.data.repository.Repository;

public class MarvelViewModel extends ViewModel {

    private final Repository repository;
    private final MutableLiveData<DataModelClass> resultsLD = new MutableLiveData<>();

    public MarvelViewModel(Repository repository) {
        this.repository = repository;
    }

    public MutableLiveData<DataModelClass> getVolumesResponseLiveData() {
        return repository.getdata();
    }
}
