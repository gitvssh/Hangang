package com.example.administrator.hangang;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    Fragment mainFragment;
    Fragment searchFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainFragment = new MainFragment();
        searchFragment = new SearchFragment();

        android.support.v4.app.FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        fragmentTransaction.add(R.id.mainFragment, mainFragment);
        fragmentTransaction.commit();


    }

    public void onFragmentChanged(int index){
        if(index==0){
            getSupportFragmentManager().beginTransaction().replace(R.id.mainFragment,searchFragment).commit();
        }else if(index==1){
            getSupportFragmentManager().beginTransaction().replace(R.id.mainFragment,mainFragment).commit();
        }
    }
}
