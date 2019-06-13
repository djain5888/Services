package com.iniesta.services;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    MaterialSearchView searchView;
    RecyclerView offersRecyclerView;
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

        offersRecyclerView = view.findViewById(R.id.offersRecycler);
        OffersRecyclerAdapter recyclerAdapter = new OffersRecyclerAdapter(getContext(),imagesList);
        offersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        offersRecyclerView.setAdapter(recyclerAdapter);

        searchView = (MaterialSearchView) view.findViewById(R.id.search_view);
        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                //Do some magic
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                //Do some magic
                return false;
            }
        });

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {
                //Do some magic
            }

            @Override
            public void onSearchViewClosed() {
                //Do some magic
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.home_menu, menu);

        MenuItem item = menu.findItem(R.id.action_search);
        searchView.setMenuItem(item);

    }

    public void addImages(){
        imagesList.add(R.drawable.salonicon);
        imagesList.add(R.drawable.salonicon);
        imagesList.add(R.drawable.salonicon);
        imagesList.add(R.drawable.salonicon);
        imagesList.add(R.drawable.salonicon);
        imagesList.add(R.drawable.salonicon);
        imagesList.add(R.drawable.salonicon);
        imagesList.add(R.drawable.salonicon);
        imagesList.add(R.drawable.salonicon);
        imagesList.add(R.drawable.salonicon);
    }

}
