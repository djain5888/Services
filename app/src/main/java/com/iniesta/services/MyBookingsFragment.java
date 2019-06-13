package com.iniesta.services;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MyBookingsFragment extends Fragment {
    private ViewPager view_pager;
    private TabLayout tab_layout;
    PlaceholderFragment f1;
    PlaceholderFragment f2;
    SectionsPagerAdapter adapter;
    View view;



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Toast.makeText(getContext(), "hello", Toast.LENGTH_SHORT).show();
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mybookings,container,false);
        view_pager = view.findViewById(R.id.view_pager1);
        tab_layout = view.findViewById(R.id.tab_layout);
        tab_layout.setupWithViewPager(view_pager);
        Toast.makeText(getContext(), "toAST", Toast.LENGTH_LONG).show();
        adapter = new SectionsPagerAdapter(getChildFragmentManager());
        f1=new PlaceholderFragment();
        f2=new PlaceholderFragment();
        Bundle bundle1 = new Bundle();
        bundle1.putString("name", "1");
        f1.setArguments(bundle1);
        Bundle bundle2 = new Bundle();
        bundle2.putString("name", "2");
        f2.setArguments(bundle2);
        adapter.addFragment(f1, "ITEM ONE");
        adapter.addFragment(f2, "ITEM TWO");
        view_pager.setAdapter(adapter);

        return view;

    }






}






 class SectionsPagerAdapter extends FragmentPagerAdapter {

    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();

    public SectionsPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}



