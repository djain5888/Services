package com.iniesta.services;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PlaceholderFragment extends Fragment {

    public String name;

    public PlaceholderFragment() {

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            name = getArguments().get("name").toString();
        }catch (NullPointerException e){
            e.getMessage();
            Toast.makeText(getContext(),name,Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_resource, container, false);
        ImageView imageView = rootView.findViewById(R.id.noprojectsimg);
        Button bookButton = rootView.findViewById(R.id.bookButton);
        bookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Button Clicked",Toast.LENGTH_SHORT).show();
//                getFragmentManager().beginTransaction().replace(R.id.fragments_container,new HomeFragment()).commit();
            }
        });
        return rootView;
    }
}