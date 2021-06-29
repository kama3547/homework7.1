package com.example.homework71.onboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.homework71.R;

import java.util.ArrayList;
import java.util.List;

public class OnBoardingActivity extends AppCompatActivity {

    private ViewPagerAdapter viewPagerAdapter;
    private ViewPager viewPager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding);
        viewPager = findViewById(R.id.viewpager);
        List<OnBoardingModel> list = new ArrayList<>();
        list.add(new OnBoardingModel("title1","description 1",R.drawable.ic_illustration));
        list.add(new OnBoardingModel("title2","description 2",R.drawable.ic_illustration));
        list.add(new OnBoardingModel("title3","description 3",R.drawable.ic_illustration));
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(),list);

    }
    }
