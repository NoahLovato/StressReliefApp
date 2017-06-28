package com.example.noahlovato.stressreliever;

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

        //Sets up listener for hamburger icon to open drawer
        drawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(
                this,drawerLayout,R.string.open_drawer,R.string.app_name);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();

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
                        }
                        else if(selectedMenu.equalsIgnoreCase("Cute Animals")) {
                            fragment = new KittensFragment();
                        }
                        else if (selectedMenu.equalsIgnoreCase("Music")) {
                            fragment = new MusicFragment();
                        }
                        else if(selectedMenu.equalsIgnoreCase("Settings")) {
                            fragment = new SettingsFragment();
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

    public void showFragment(int id, Fragment frag)
    {
        ft.replace(id,frag);
        ft.addToBackStack(null);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.commit();
    }
}
