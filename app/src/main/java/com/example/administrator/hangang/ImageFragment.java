package com.example.administrator.hangang;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;




public class ImageFragment extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (container != null) {
            container = null;
        }
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_image, container, false);

//        Button button = (Button)rootView.findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v) {
//                MainActivity activity = (MainActivity)getActivity();
//                activity.onFragmentChanged(0);
//            }
//        });
    return rootView;
    }
}
