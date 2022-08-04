package com.richa.fitness_partner.Fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.richa.fitness_partner.R;
import com.richa.fitness_partner.Global.GpsTracker;


public class GymFragment extends Fragment {
    public GpsTracker gpsTracker;
    LinearLayout llGym;
    public GymFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.gym_fragment, container, false);
        llGym=rootView.findViewById(R.id.llGym);
        llGym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLocation();

            }
        });


        return rootView;
    }
    public void getLocation(){
        gpsTracker = new GpsTracker(getContext());
        if(gpsTracker.canGetLocation()){
            double latitude = gpsTracker.getLatitude();
            double longitude = gpsTracker.getLongitude();
            Log.d("latnewnwe","latnewnwe"+String.valueOf(latitude));
            Log.d("latnewnwe","latnewnwelong"+String.valueOf(longitude));

                   /* String labelLocation = " Gym near me";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:<" + latitude  + ">,<" + longitude + ">?q=<" + latitude
                    + ">,<" + longitude + ">(" + "Gym near me" + ")"));
            getContext().startActivity(intent);*/

         /*   String uri = "http://maps.google.com/maps?q=loc:" + latitude + "," + longitude + " (" + "gym near me" + ")";
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
            getContext().startActivity(intent);*/
            String latlaung=String.valueOf(latitude)+","+String.valueOf(longitude);
            Uri gmmIntentUri = Uri.parse("geo:"+latlaung+"?z=10&q=gym near me");
         //   Uri gmmIntentUri = Uri.parse("geo:37.7749,-122.4194?z=10&q=restaurants");
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            mapIntent.setPackage("com.google.android.apps.maps");
            startActivity(mapIntent);


        }else{
            gpsTracker.showSettingsAlert();
        }
    }
}