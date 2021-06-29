package com.example.homework71.onboard;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.homework71.onboard.OnBoardingModel;
import com.example.homework71.onboard.OnBoardingitemFragment;

import java.util.List;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    List<OnBoardingModel>list;

    public ViewPagerAdapter(@NonNull FragmentManager fm, List<OnBoardingModel> list) {
        super(fm);
        this.list = list;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return OnBoardingitemFragment.newInstance(list.get(position).getTitle(),list.get(position).getDescription(),list.get(position).getImage());
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
