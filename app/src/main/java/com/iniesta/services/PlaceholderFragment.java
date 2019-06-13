package com.iniesta.services;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class PlaceholderFragment extends Fragment {
    public String name;
   // private static final String ARG_SECTION_NUMBER = "section_number";

    public PlaceholderFragment() {

    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            name = getArguments().get("name").toString();
            Toast.makeText(getContext(), "in on crete"+name, Toast.LENGTH_SHORT).show();
//           newInstance(name);

        }catch (NullPointerException e){
            e.getMessage();
            Toast.makeText(getContext(),name,Toast.LENGTH_LONG).show();

        }
    }


//    public static PlaceholderFragment newInstance(String n1) {
//        String sectionNumber=n1;
//        PlaceholderFragment fragment = new PlaceholderFragment();
//        Bundle args = new Bundle();
//        int s=Integer.parseInt(sectionNumber);
//        args.putInt(ARG_SECTION_NUMBER, s);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_resource, container, false);
        //Toast.makeText(getContext(), "toast creted", Toast.LENGTH_SHORT).show();
        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
        if(name.equals("1"))
        textView.setText("section 1");
        else
            textView.setText("section 2");
        return rootView;
    }
}