package com.example.administrator.hangang;

import android.content.Context;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;


public class MainFragment extends Fragment {
    ImageButton button1;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(container!=null){
            container = null;
        }
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_main,container,true);

//        Button button = (Button)rootView.findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                MainActivity activity = (MainActivity)getActivity();
//                activity.onFragmentChanged(0);
//            }
//        });
        button1 = (ImageButton)rootView.findViewById(R.id.MainButton1);
        System.out.print(2);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                System.out.print(3);
                MainActivity activity = (MainActivity)getActivity();
                activity.onFragmentChanged(0);
            }
        });
        return rootView;
    }
}