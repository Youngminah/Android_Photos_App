package com.example.hw5_.ui.slideshow;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.example.hw5_.MainActivity;
import com.example.hw5_.R;

import java.util.ArrayList;

public class SlideshowFragment extends Fragment{

    Adapter adapter;
    ViewPager2 viewPager;
    EditText editText;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        editText = (EditText) root.findViewById(R.id.editText);
        editText.setText("1");
        viewPager=  root.findViewById(R.id.viewPager);
        viewPager.setOffscreenPageLimit(30);

        adapter= new Adapter(this);
        for(int i=0; i<30 ;i++) {
            adapter.addItem(new Fragment1(i));
        }
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(0);

        editText.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return false;
            }
        });

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {
                editText.setSelection(s.toString().length());
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!(s.toString()).equals("")) {
                    int index = Integer.parseInt(s.toString());
                    if(!(index<=30 && 0<index) ){
                        editText.setText(null);
                        Toast.makeText(getContext(),"Please enter a digit number between 1~30",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        viewPager.setCurrentItem(index-1);
                    }
                }
            }
        });
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback()  {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                editText.setText(Integer.toString(viewPager.getCurrentItem()+1));
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);

            }
        });
        return root;
    }

}

class Adapter extends FragmentStateAdapter {

    ArrayList<Fragment> items = new ArrayList<Fragment>();

    public Adapter(@NonNull Fragment fragment) {
        super(fragment);
    }


    public void addItem(Fragment item){
        items.add(item);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return items.get(position);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}

