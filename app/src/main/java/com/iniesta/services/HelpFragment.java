package com.iniesta.services;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class HelpFragment extends Fragment {
    private CardView c1;
    private CardView c2;
    private CardView c3,c4;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((AppCompatActivity)getActivity()).getSupportActionBar().show();

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        //getActivity().getActionBar().show();

        View view = inflater.inflate(R.layout.fragment_help,container,false);

       c1=view.findViewById(R.id.card1);
       c2=view.findViewById(R.id.card2);
       c3=view.findViewById(R.id.card3);
       c4=view.findViewById(R.id.card4);


       c1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(getContext(), "card 1 clicked ", Toast.LENGTH_SHORT).show();
           }
       });
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "card 2 clicked ", Toast.LENGTH_SHORT).show();
            }
        });
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "card 3 clicked ", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getContext(),AboutUsActivity.class);
                startActivity(intent);
            }
        });
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "card4 Clicked", Toast.LENGTH_SHORT).show();
            }
        });



        return view;
    }

}
