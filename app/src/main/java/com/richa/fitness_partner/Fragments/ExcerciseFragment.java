package com.richa.fitness_partner.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.richa.fitness_partner.R;
import com.richa.fitness_partner.Adapter.CustomAdapter;
import com.richa.fitness_partner.Interface.OnexcerciseClick;

public class ExcerciseFragment extends Fragment implements OnexcerciseClick {

    private RecyclerView rvExcercise;
    CustomAdapter customAdapter;
    public static int pos;
    public ExcerciseFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.excersice_fragment, container, false);
        rvExcercise=rootView.findViewById(R.id.rvExcersice);
        rvExcercise.setLayoutManager(new GridLayoutManager(getActivity(),2));
        customAdapter=new CustomAdapter(getActivity());
        customAdapter.onclickexcersice(this);
        rvExcercise.setAdapter(customAdapter);
        return rootView;
    }

    @Override
    public void onclickexc(int position) {
        pos=position;
        Excercise_detais_fragment fragment1 = new Excercise_detais_fragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(android.R.id.content, fragment1);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}