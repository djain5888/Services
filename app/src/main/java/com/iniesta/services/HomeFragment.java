package com.iniesta.services;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements
        AdapterView.OnItemSelectedListener  {

    private String[] places = { "Noida", "Delhi", "Ghaziabad", "Faridabad", "Gurgaon","Other"};
    private ArrayList<Integer> imagesList = new ArrayList<>();

    RecyclerView offersRecyclerView;
    CardView searchView,doctor,carpenter,makeup,electrician,appliance,fitness;
    CardView down1,down2,down3,down4,down5,down6;
    Intent result;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().hide();
        setHasOptionsMenu(true);
        addImages();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,container,false);

        //Getting the instance of Spinner and applying OnItemSelectedListener on it
        Spinner spin = view.findViewById(R.id.spinner);
        spin.setOnItemSelectedListener(this);

        searchView = view.findViewById(R.id.search);
        searchView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),SearchActivity.class);
                startActivity(intent);
            }
        });
        doctor = view.findViewById(R.id.doctor);
        carpenter = view.findViewById(R.id.carpenter);
        makeup = view.findViewById(R.id.makeup);
        electrician = view.findViewById(R.id.electrician);
        appliance = view.findViewById(R.id.appliances);
        fitness = view.findViewById(R.id.fitness);

        down1 = view.findViewById(R.id.Display_card1);
        down2 = view.findViewById(R.id.Display_card2);
        down3 = view.findViewById(R.id.Display_card3);
        down4 = view.findViewById(R.id.Display_card4);
        down5 = view.findViewById(R.id.Display_card5);
        down6 = view.findViewById(R.id.Display_card6);

        result = new Intent(this.getActivity(),Result.class);

        down1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.putExtra("value","homeAppliances");
                startActivity(result);
            }
        });
        down2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.putExtra("value","dietician");
                startActivity(result);
            }
        });
        down3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.putExtra("value","salon");
                startActivity(result);
            }
        });
        down4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.putExtra("value","tutor");
                startActivity(result);
            }
        });
        down5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.putExtra("value","taxes");
                startActivity(result);
            }
        });
        down6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.putExtra("value","restaurants");
                startActivity(result);
            }
        });


        offersRecyclerView = view.findViewById(R.id.offersRecycler);
        OffersRecyclerAdapter.RecyclerViewClickListener listener = new OffersRecyclerAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position) {

                switch(position){
                    case 0:
                        result.putExtra("value","beauty&spa");
                        startActivity(result);
                        break;
                    case 1:
                        result.putExtra("value","health&Fitness");
                        startActivity(result);
                        break;
                    case 2:
                        result.putExtra("value","packers&movers");
                        startActivity(result);
                        break;
                    case 3:
                        result.putExtra("value","carpenter");
                        startActivity(result);
                        break;
                    case 4:
                        result.putExtra("value","acRepair");
                        startActivity(result);
                        break;
                    case 5:
                        result.putExtra("value","dietician");
                        startActivity(result);
                        break;
                    case 6:
                        result.putExtra("value","doctor");
                        startActivity(result);
                        break;
                    case 7:
                        result.putExtra("value","restaurants");
                        startActivity(result);
                        break;
                    case 8:
                        result.putExtra("value","tutor");
                        startActivity(result);
                        break;
                    case 9:
                        result.putExtra("value","taxes");
                        startActivity(result);
                        break;
                    case 10:
                        result.putExtra("value","salon");
                        startActivity(result);
                        break;
                    case 11:
                        result.putExtra("value","homeAppliances");
                        startActivity(result);
                        break;
                }

            }
        };

        OffersRecyclerAdapter recyclerAdapter = new OffersRecyclerAdapter(getContext(),imagesList,listener);
        offersRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        offersRecyclerView.setAdapter(recyclerAdapter);
        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.putExtra("value","doctor");
                startActivity(result);
            }

        });
        makeup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.putExtra("value","beauty&spa");
                startActivity(result);
            }

        });
        electrician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.putExtra("value","packers&movers");
                startActivity(result);
            }

        });
        appliance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.putExtra("value","acRepair");
                startActivity(result);
            }

        });
        fitness.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.putExtra("value","health&Fitness");
                startActivity(result);
            }

        });
        carpenter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                result.putExtra("value","carpenter");
                startActivity(result);
            }

        });

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this.getActivity(),android.R.layout.simple_spinner_item,places);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        spin.setAdapter(aa);

        return view;
    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        ((TextView) arg1).setTextColor(Color.WHITE);
        Toast.makeText(getContext(),places[position] , Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

    public void addImages(){
        imagesList.add(R.drawable.beatyaspa);
        imagesList.add(R.drawable.fitness);
        imagesList.add(R.drawable.packers);
        imagesList.add(R.drawable.carpenter);
        imagesList.add(R.drawable.ac);
        imagesList.add(R.drawable.dietician);
        imagesList.add(R.drawable.doctorconsultant);
        imagesList.add(R.drawable.restaurants);
        imagesList.add(R.drawable.tutor);
        imagesList.add(R.drawable.taxes);
        imagesList.add(R.drawable.salonat);
        imagesList.add(R.drawable.homeapp);
    }
}
