package com.richa.fitness_partner;

import static com.richa.fitness_partner.Fragments.StepcounterFragment.MY_PREFS_NAME;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.richa.fitness_partner.R;
import com.richa.fitness_partner.Adapter.DrawerItemCustomAdapter;
import com.richa.fitness_partner.Fragments.AboutUsFragment;
import com.richa.fitness_partner.Fragments.AchiverFragment;
import com.richa.fitness_partner.Fragments.CaloriesCalculatorFragment;
import com.richa.fitness_partner.Fragments.ContactUsFragment;
import com.richa.fitness_partner.Fragments.Diat_selection_fragment;
import com.richa.fitness_partner.Fragments.ExcerciseFragment;
import com.richa.fitness_partner.Fragments.GymFragment;
import com.richa.fitness_partner.Fragments.HomeFragment;
import com.richa.fitness_partner.Fragments.StepcounterFragment;
import com.richa.fitness_partner.Model.DataModel;

public class MainActivity extends AppCompatActivity {

    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    public static Toolbar toolbar;
    public static boolean isfrom_nav;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    ActionBarDrawerToggle mDrawerToggle;
    int pref_value;
    ConnectivityManager mgr;
    NetworkInfo netInfo;

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        netInfo = mgr.getActiveNetworkInfo();
        try {
            if (ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, 101);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (netInfo != null) {
            if (netInfo.isConnected()) {

            } else {
                Toast.makeText(MainActivity.this, "Please on your Internet", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "Please on your Internet", Toast.LENGTH_LONG).show();
        }

        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles = getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        setupToolbar();

        DataModel[] drawerItem = new DataModel[9];

        drawerItem[0] = new DataModel(R.drawable.home, "Home");
        drawerItem[1] = new DataModel(R.drawable.foot_step, "Stepcounter");
        drawerItem[2] = new DataModel(R.drawable.about_us, "About Us");
        drawerItem[3] = new DataModel(R.drawable.contact_us, "Contact Us");
        drawerItem[4] = new DataModel(R.drawable.excersice, "Excersice");
        drawerItem[5] = new DataModel(R.drawable.diatplan, "Diet Selection");
        drawerItem[6] = new DataModel(R.drawable.gym_nearme, "Near By Gym List");
        drawerItem[7] = new DataModel(R.drawable.calory_counter, "Calories Calculator");
        drawerItem[8] = new DataModel(R.drawable.achiever, "Achievement");
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();
        selectItem(0);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new HomeFragment();
                isfrom_nav = true;
                break;
            case 1:
                fragment = new StepcounterFragment();

                isfrom_nav = true;
                break;
            case 2:
                fragment = new AboutUsFragment();
                isfrom_nav = true;
                break;
            case 3:
                fragment = new ContactUsFragment();
                isfrom_nav = true;
                break;
            case 4:
                fragment = new ExcerciseFragment();
                isfrom_nav = true;
                break;
            case 5:
                fragment = new Diat_selection_fragment();
                isfrom_nav = true;
                break;
            case 6:
                fragment = new GymFragment();
                isfrom_nav = true;
                break;
            case 7:
                SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
                pref_value = prefs.getInt("step_counter", 0);
                Log.d("preferancevalue","preferancevalue"+pref_value);
                if (pref_value != 0) {
                    fragment = new CaloriesCalculatorFragment();
                    isfrom_nav = true;
                } else {
                    Toast.makeText(this, "Take a walk first to check the burnt calories", Toast.LENGTH_LONG).show();
                }

                break;
                case 8:
                    fragment = new AchiverFragment();
                    isfrom_nav = true;
                    break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);


            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    @SuppressLint("NewApi")
    void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    void setupDrawerToggle() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }

}