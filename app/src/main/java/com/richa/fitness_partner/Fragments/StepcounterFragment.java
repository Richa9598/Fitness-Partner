package com.richa.fitness_partner.Fragments;

import static android.content.Context.MODE_PRIVATE;
import static android.content.Context.SENSOR_SERVICE;
import static com.richa.fitness_partner.Fragments.AchiverFragment.MY_PREFS_NAME2;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.richa.fitness_partner.R;
import com.richa.fitness_partner.Interface.StepListener;
import com.richa.fitness_partner.Model.StepDetector;

public class StepcounterFragment extends Fragment implements StepListener {

    private TextView TvSteps;
    private ImageView BtnStart;
    private ImageView BtnStop;
    private StepDetector simpleStepDetector;
    public SensorManager sensorManager;
    private Sensor accel;
    public SharedPreferences.Editor editor;

    private static final String TEXT_NUM_STEPS = "Number of Steps: ";
    private int numSteps;
    public static final String MY_PREFS_NAME = "MyPrefsFile";

    public StepcounterFragment() {
    }

    @SuppressLint("CommitPrefEdits")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.stepcounter_fragment, container, false);
        editor = getActivity().getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE).edit();
        sensorManager = (SensorManager) getActivity().getSystemService(SENSOR_SERVICE);
        accel = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        simpleStepDetector = new StepDetector();

        simpleStepDetector.registerListener(this);
        SensorEventListener sensorEventListener=new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
                    simpleStepDetector.updateAccel(
                            event.timestamp, event.values[0], event.values[1], event.values[2]);
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };
        TvSteps = (TextView) rootView.findViewById(R.id.tv_steps);
        BtnStart = (ImageView) rootView.findViewById(R.id.btn_start);
        BtnStop = (ImageView)rootView. findViewById(R.id.btn_stop);
        BtnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {


                numSteps = 0;
                sensorManager.registerListener(sensorEventListener, accel, SensorManager.SENSOR_DELAY_FASTEST);

            }
        });


        BtnStop.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                sensorManager.unregisterListener(sensorEventListener);

            }
        });




        return rootView;
    }



    @Override
    public void step(long timeNs) {
        numSteps++;
        TvSteps.setText(TEXT_NUM_STEPS + numSteps);
        editor.putInt("step_counter", numSteps);
        SharedPreferences prefs = getActivity().getSharedPreferences(MY_PREFS_NAME2, MODE_PRIVATE);
        Log.d("preferancevalue","preferancevalueolder"+prefs.getInt("step_counterolder",0));
        if(prefs.getInt("step_counterolder", 0)<numSteps){
            editor.putInt("step_counternew", numSteps);
            Log.d("preferancevalue","preferancevalue"+numSteps);
        }
        editor.commit();
    }

}