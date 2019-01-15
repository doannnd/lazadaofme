package com.example.doannd.lazadaofme.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.doannd.lazadaofme.R;

public class SportAndTourismFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private String mParam1;


    public SportAndTourismFragment() {
        // Required empty public constructor
    }

    public static SportAndTourismFragment newInstance(int position) {
        SportAndTourismFragment fragment = new SportAndTourismFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sport_and_tourism, container, false);
    }
}
