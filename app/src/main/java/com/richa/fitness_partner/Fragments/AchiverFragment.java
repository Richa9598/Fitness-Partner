package com.richa.fitness_partner.Fragments;

import static android.content.Context.MODE_PRIVATE;
import static com.richa.fitness_partner.Fragments.StepcounterFragment.MY_PREFS_NAME;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.richa.fitness_partner.R;


public class AchiverFragment extends Fragment {
    int pref_value, pref_valuenew;
    public SharedPreferences.Editor editor;
    LinearLayout llAchiever;
    TextView tvSorry;
    public static final String MY_PREFS_NAME2 = "MyPrefsFile2";

    public AchiverFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.achiever_fragment, container, false);
        llAchiever = rootView.findViewById(R.id.llAchiever);
        tvSorry = rootView.findViewById(R.id.tvSorry);
        editor = getActivity().getSharedPreferences(MY_PREFS_NAME2, MODE_PRIVATE).edit();
        SharedPreferences prefs = getActivity().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        pref_value = prefs.getInt("step_counter", 0);
        pref_valuenew = prefs.getInt("step_counternew", 0);

        Log.d("prefvaluenew", "prefvaluenew" + pref_value);
        Log.d("prefvaluenew", "prefvaluenewnew" + pref_valuenew);
        editor.putInt("step_counterolder", pref_value);
        editor.commit();

        if(pref_value!=0&&pref_valuenew!=0){
            if (pref_value >= pref_valuenew) {
                llAchiever.setVisibility(View.VISIBLE);
                tvSorry.setVisibility(View.GONE);
            } else {
                llAchiever.setVisibility(View.GONE);
                tvSorry.setVisibility(View.VISIBLE);
            }
        }

        return rootView;
    }

}