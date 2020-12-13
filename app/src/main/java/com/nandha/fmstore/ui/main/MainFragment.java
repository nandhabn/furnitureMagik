package com.nandha.fmstore.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nandha.fmstore.Furniture;
import com.nandha.fmstore.R;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {

    private MainViewModel mViewModel;
    RecyclerView mRecyclerView;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment, container, false);
        mRecyclerView = view.findViewById(R.id.furnitureListView);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        mViewModel.loadFurniture();

        mViewModel.getFurniture().observe(getViewLifecycleOwner(), new Observer<List<Furniture>>() {
            @Override
            public void onChanged(List<Furniture> furnitures) {
                FurnitureMap map = new FurnitureMap(furnitures);

                mRecyclerView.setAdapter(map);
            }
        });

        return view;
    }
}