package com.example.hw5_.ui.slideshow;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hw5_.R;


public class Fragment1 extends Fragment {
    int index;

    public Fragment1(int index){
        this.index=index;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.slider, container, false);

        int[] imagelist=
                {R.drawable.a1,R.drawable.a2,R.drawable.a3,R.drawable.a4, R.drawable.a5,
                        R.drawable.a6,R.drawable.a7, R.drawable.a8,R.drawable.a9,
                        R.drawable.a10,R.drawable.a11, R.drawable.a12,R.drawable.a13,
                        R.drawable.a14,R.drawable.a15, R.drawable.a16,R.drawable.a17,
                        R.drawable.a18,R.drawable.a19, R.drawable.a20, R.drawable.a21,
                        R.drawable.a22, R.drawable.a23,R.drawable.a24,R.drawable.a25,
                        R.drawable.a26, R.drawable.a27,R.drawable.a28,R.drawable.a29,
                        R.drawable.a30};

        ImageView imageView = rootView.findViewById(R.id.imageView);
        imageView.setImageResource(imagelist[index]);

        return rootView;
    }
}