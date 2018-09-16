package com.example.administrator.hangang;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    ImageFragment imageFragment;
    MainFragment mainFragment;

    Fragment searchFragment;
    DrawerLayout drawerLayout;
    ActionBar actionBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = new MainFragment();
        imageFragment = new ImageFragment();
       /* searchFragment = new SearchFragment();*/

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();


        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.imageFragment,imageFragment);
        fragmentTransaction.add(R.id.mainFragment, mainFragment);
        fragmentTransaction.commit();
        actionBar = getSupportActionBar();
        drawerLayout = (DrawerLayout) findViewById(R.id.draw_layout) ;
        actionBar.setHomeAsUpIndicator(R.mipmap.baseline_dehaze_white_18dp);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle("");


    }

    public void onFragmentChanged(int index){
        if(index==0){
            getSupportFragmentManager().beginTransaction().replace(R.id.mainFragment,searchFragment).commit();
        }else if(index==1){
            getSupportFragmentManager().beginTransaction().replace(R.id.mainFragment,mainFragment).commit();
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            if(!drawerLayout.isDrawerOpen(GravityCompat.START)){
                drawerLayout.openDrawer(GravityCompat.START);
            }else{
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
