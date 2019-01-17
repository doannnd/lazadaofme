package com.example.doannd.lazadaofme.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doannd.lazadaofme.R;

public class HomeAndLifeFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;


    public HomeAndLifeFragment() {
        // Required empty public constructor
    }

    public static HomeAndLifeFragment newInstance(int position) {
        HomeAndLifeFragment fragment = new HomeAndLifeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_and_life, container, false);
    }
}
