package com.richa.fitness_partner.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.richa.fitness_partner.R;

public class Diat_selection_fragment extends Fragment {
    private LinearLayout llVeg;
    private LinearLayout llNonveg;
    public static int type_diat;
    public Diat_selection_fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.diat_selection_fragment, container, false);
        llVeg = (LinearLayout) rootView.findViewById(R.id.llVeg);
        llNonveg = (LinearLayout) rootView.findViewById(R.id.llNonveg);

        llVeg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_diat=1;
                DiatchartFragment fragment1 = new DiatchartFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(android.R.id.content, fragment1);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        llNonveg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                type_diat=2;
                DiatchartFragment fragment1 = new DiatchartFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(android.R.id.content, fragment1);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return rootView;
    }

}