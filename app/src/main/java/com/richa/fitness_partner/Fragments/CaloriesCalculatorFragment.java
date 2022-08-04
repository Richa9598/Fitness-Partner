package com.richa.fitness_partner.Fragments;

import static android.content.Context.MODE_PRIVATE;
import static com.richa.fitness_partner.Fragments.StepcounterFragment.MY_PREFS_NAME;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.richa.fitness_partner.R;

import java.text.DecimalFormat;
import java.text.NumberFormat;


public class CaloriesCalculatorFragment extends Fragment {
    EditText tvHeight, tvWeight;
    TextView tvFootstep;
    TextView tvMessage;
    Button btnCal;

  /*  static double weight = 80.90; // kg

    static double height = 153.0; // cm*/

  //  static double stepsCount = 4793;

//Don't edit below this


    final static double walkingFactor = 0.57;

    static double CaloriesBurnedPerMile;

    static double strip;
    int pref_value;
    String height,weight;

    static double stepCountMile; // step/mile
    public SharedPreferences.Editor editor;
    static double conversationFactor;

    static double CaloriesBurned;
    public static final String MY_PREFS_NAMEachieve = "MyPrefsFileachieve";
    static NumberFormat formatter = new DecimalFormat("#0.00");
    SharedPreferences prefsachieve;
    static double distance;

    public CaloriesCalculatorFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.calories_calculator_fragment, container, false);
        tvHeight = rootView.findViewById(R.id.tvHeight);
        tvWeight = rootView.findViewById(R.id.tvWeight);

        btnCal = rootView.findViewById(R.id.btnCal);
        tvFootstep = rootView.findViewById(R.id.tvFootstep);
        tvMessage = rootView.findViewById(R.id.tvMessage);
        SharedPreferences prefsach= getActivity().getSharedPreferences(MY_PREFS_NAMEachieve, MODE_PRIVATE);
        height = prefsach.getString("height", "");
        weight = prefsach.getString("weight", "");
        if(weight.length()!=0&&height.length()!=0){
            tvWeight.setText(weight);
            tvHeight.setText(height);
        }

                SharedPreferences prefs = getActivity().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        pref_value = prefs.getInt("step_counter", 0);
        tvFootstep.setText(String.valueOf(pref_value));
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(tvHeight.getText().toString().length()!=0&&tvWeight.getText().toString().length()!=0&&tvFootstep.getText().toString().length()!=0){
                    editor = getActivity().getSharedPreferences(MY_PREFS_NAMEachieve, MODE_PRIVATE).edit();
                    editor.putString("height", tvHeight.getText().toString());
                    editor.putString("weight", tvWeight.getText().toString());
                    editor.commit();

                    CaloriesBurnedPerMile = walkingFactor * (Double.valueOf(tvWeight.getText().toString() )* 2.2);

                    strip = Double.valueOf(tvHeight.getText().toString())* 0.415;

                    stepCountMile = 160934.4 / strip;

                    conversationFactor = CaloriesBurnedPerMile / stepCountMile;

                    CaloriesBurned = Double.valueOf(tvFootstep.getText().toString() ) * conversationFactor;

                    System.out.println("Calories burned: "
                            + formatter.format(CaloriesBurned) + " cal");




                    distance = (Double.valueOf(tvFootstep.getText().toString() ) * strip) / 100000;

                    System.out.println("Distance: " + formatter.format(distance)
                            + " km");
                    tvMessage.setText("Calories burned: "
                            + formatter.format(CaloriesBurned) + " cal"+"\n"+
                            "Distance: " + formatter.format(distance)
                            + " km");

                }
                else{
                    Toast.makeText(getContext(), "Height , Weight and Foot steps can't be empty!!", Toast.LENGTH_SHORT).show();
                }
            }
        });



        return rootView;
    }


}