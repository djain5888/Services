package com.iniesta.services;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView offersRecyclerView;
    CardView searchView;
    private ArrayList<Integer> imagesList = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        addImages();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        searchView = view.findViewById(R.id.search);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SearchActivity.class);
                startActivity(intent);
            }
        });

        offersRecyclerView = view.findViewById(R.id.offersRecycler);
        OffersRecyclerAdapter recyclerAdapter = new OffersRecyclerAdapter(getContext(),imagesList);
        offersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        offersRecyclerView.setAdapter(recyclerAdapter);

        return view;
    }

    public void addImages(){
        imagesList.add(R.drawable.beatyaspa);
        imagesList.add(R.drawable.fitness);
        imagesList.add(R.drawable.packers);
        imagesList.add(R.drawable.restaurants);
        imagesList.add(R.drawable.ac);
        imagesList.add(R.drawable.dietician);
        imagesList.add(R.drawable.doctorconsultant);
        imagesList.add(R.drawable.tutotu);
        imagesList.add(R.drawable.taxes);
        imagesList.add(R.drawable.salonat);
    }

}
