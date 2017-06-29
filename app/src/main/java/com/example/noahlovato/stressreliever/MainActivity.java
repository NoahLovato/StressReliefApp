package com.example.noahlovato.stressreliever;

import android.os.PersistableBundle;
import android.support.v4.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.crashlytics.android.Crashlytics;
import com.example.noahlovato.stressreliever.fragments.HomeFragment;
import com.example.noahlovato.stressreliever.fragments.KittensFragment;
import com.example.noahlovato.stressreliever.fragments.MusicFragment;
import com.example.noahlovato.stressreliever.fragments.PuppiesFragment;
import com.example.noahlovato.stressreliever.fragments.SettingsFragment;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    int fragmentId = 0;

    DrawerLayout drawerLayout;
    ActionBarDrawerToggle drawerToggle;
    NavigationView navigationView;
    Fragment fragment;
    FragmentTransaction ft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        if(savedInstanceState != null) {
            fragmentId = savedInstanceState.getInt("PreviousFragment");
            Log.d(TAG, "fragmentId is: " + fragmentId);
        }

        //Sets up listener for hamburger icon to open drawer
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(
                this,drawerLayout,R.string.open_drawer,R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

        //Goes to HomeFragment by default
        //Does the fragment transaction to display the fragment

            if(fragmentId == 0) {
                Log.d(TAG, "Creating HomeFragment");
                fragment = new HomeFragment();
            }
            else if(fragmentId == 1) {
                Log.d(TAG, "Creating KittensFragment");
                fragment = new KittensFragment();
            }
            else if(fragmentId == 2) {
                Log.d(TAG, "Creating MusicFragment");
                fragment = new MusicFragment();
            }
            else if(fragmentId == 3) {
                Log.d(TAG, "Creating SettingsFragment");
                fragment = new SettingsFragment();
            }

        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout,fragment);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();

        navigationView = (NavigationView)findViewById(R.id.navi_view);

        //Listener for menu item clicks in navigation drawer
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                        drawerLayout.closeDrawers();
                        String selectedMenu = item.getTitle().toString();
                        Log.d(TAG, selectedMenu + " selected.");

                        //Shows fragment corresponding to menu click
                        if(selectedMenu.equalsIgnoreCase("Home")) {
                            fragment = new HomeFragment();
                            fragmentId = 0;
                        }
                        else if(selectedMenu.equalsIgnoreCase("Cute Animals")) {
                            fragment = new KittensFragment();
                            fragmentId = 1;
                        }
                        else if (selectedMenu.equalsIgnoreCase("Music")) {
                            fragment = new MusicFragment();
                            fragmentId = 2;
                        }
                        else if(selectedMenu.equalsIgnoreCase("Settings")) {
                            fragment = new SettingsFragment();
                            fragmentId = 3;
                        }

                        //Does the fragment transaction to display the fragment
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.frame_layout,fragment);
                        ft.addToBackStack(null);
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        ft.commit();

                        return true;
                    }
                });

        //Creates button on action bar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

    }

    //For handling hamburger icon clicks
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(drawerToggle.onOptionsItemSelected(item)) return true;
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("PreviousFragment", fragmentId);
    }

}
