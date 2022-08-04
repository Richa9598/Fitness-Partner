package com.richa.fitness_partner.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.richa.fitness_partner.R;
import com.richa.fitness_partner.Adapter.Excercise_deails_adapter;

public class Excercise_detais_fragment extends Fragment {

    private RecyclerView rvExcercise;
    Excercise_deails_adapter customAdapter;
    public Excercise_detais_fragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.excersice_deails_fragment, container, false);
        rvExcercise=rootView.findViewById(R.id.rvExcersice);
        rvExcercise.setLayoutManager(new LinearLayoutManager(getActivity(),RecyclerView.VERTICAL,false));
        customAdapter=new Excercise_deails_adapter(getActivity(), ExcerciseFragment.pos);
        rvExcercise.setAdapter(customAdapter);
        return rootView;
    }

}