package com.richa.fitness_partner.Fragments;

import static android.content.Context.MODE_PRIVATE;
import static com.richa.fitness_partner.Fragments.StepcounterFragment.MY_PREFS_NAME;
import static com.richa.fitness_partner.MainActivity.isfrom_nav;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.richa.fitness_partner.R;

public class HomeFragment extends Fragment {
    private ImageView ivStep;
    private ImageView ivTimer;
    private ImageView ivAboutus;
    private ImageView ivContactus;
    private ImageView ivDiat;
    private ImageView ivGym;
    private ImageView ivCalory;
    private ImageView ivAchiver;
    int pref_value;
    LinearLayout frame_container;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.home_fragment, container, false);
        ivStep = (ImageView) rootView.findViewById(R.id.ivStep);
        ivTimer = (ImageView) rootView.findViewById(R.id.ivTimer);
        ivAboutus = (ImageView) rootView.findViewById(R.id.ivAboutus);
        ivContactus = (ImageView) rootView.findViewById(R.id.ivContactus);
        ivDiat = (ImageView) rootView.findViewById(R.id.ivDiat);
        ivGym = (ImageView) rootView.findViewById(R.id.ivGym);
        ivCalory = (ImageView) rootView.findViewById(R.id.ivCalory);
        ivAchiver = (ImageView) rootView.findViewById(R.id.ivAchiver);
        frame_container = (LinearLayout) rootView.findViewById(R.id.frame_container);
        ivStep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isfrom_nav = false;
                StepcounterFragment fragment1 = new StepcounterFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(android.R.id.content, fragment1);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        ivAboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isfrom_nav = false;
                AboutUsFragment fragment1 = new AboutUsFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(android.R.id.content, fragment1);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        ivContactus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isfrom_nav = false;
                ContactUsFragment fragment1 = new ContactUsFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(android.R.id.content, fragment1);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        ivTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isfrom_nav = false;
                ExcerciseFragment fragment1 = new ExcerciseFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(android.R.id.content, fragment1);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        ivDiat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isfrom_nav = false;
                Diat_selection_fragment fragment1 = new Diat_selection_fragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(android.R.id.content, fragment1);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        ivGym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isfrom_nav = false;
                GymFragment fragment1 = new GymFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(android.R.id.content, fragment1);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        ivCalory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = getActivity().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
                pref_value = prefs.getInt("step_counter", 0);
                Log.d("preferancevalue","preferancevalue"+pref_value);
                if (pref_value != 0) {
                    isfrom_nav = false;
                    CaloriesCalculatorFragment fragment1 = new CaloriesCalculatorFragment();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    fragmentTransaction.replace(android.R.id.content, fragment1);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                } else {
                    Toast.makeText(getActivity(), "Take a walk first to check the burnt calories", Toast.LENGTH_LONG).show();
                }


            }
        });
        ivAchiver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isfrom_nav = false;
                AchiverFragment fragment1 = new AchiverFragment();
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