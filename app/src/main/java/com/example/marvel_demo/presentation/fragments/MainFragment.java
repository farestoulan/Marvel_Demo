package com.example.marvel_demo.presentation.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import com.example.marvel_demo.presentation.adapter.Adapter;

import com.example.marvel_demo.R;
import com.example.marvel_demo.data.dataSource.LocalDataSource;
import com.example.marvel_demo.presentation.viewModel.MarvelViewModel;
import com.example.marvel_demo.presentation.viewModel.MyViewModelFactory;
import com.example.marvel_demo.data.dataSource.RemotDataSource;
import com.example.marvel_demo.data.repository.Repository;

import com.example.marvel_demo.data.modelClasses.ListModelClass;


public class MainFragment extends Fragment implements Adapter.ItemClickListener {
    ImageView imageView;
    List<ListModelClass> resultsList;
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    public MainFragment() {
        // Required empty public constructor
    }



    public static MainFragment newInstance(String param1, String param2) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView;
        MyViewModelFactory viewModelFactory;
        RemotDataSource remotDataSource = new RemotDataSource();
        LocalDataSource localDataSource = new LocalDataSource(getContext());
        recyclerView= view.findViewById(R.id.recyclerView);
        imageView=view.findViewById(R.id.imageView);
        Repository repository = new Repository(remotDataSource, localDataSource);
        viewModelFactory = new MyViewModelFactory(repository);
        MarvelViewModel viewModel = ViewModelProviders.of(MainFragment.this, viewModelFactory)
                .get(MarvelViewModel.class);
        viewModel.getVolumesResponseLiveData().observe(getViewLifecycleOwner(), results -> {
            Log.i("ahmed_response**", results.data.results.size()+ "");
            Adapter adapter = new Adapter(getContext(), results.data.results);
            resultsList = results.data.results;
            recyclerView.setAdapter(adapter);
            adapter.setClickListener(this);

        });

    }

    @Override
    public void onItemClick(View view, int position) {
        NavController navController = Navigation.findNavController(view);
        MainFragmentDirections.ActionMainFragmentToDescriptionFragment action =
                MainFragmentDirections.actionMainFragmentToDescriptionFragment("");
        action.setName(resultsList.get(position).getDescription());
        navController.navigate(action);


    }
}

