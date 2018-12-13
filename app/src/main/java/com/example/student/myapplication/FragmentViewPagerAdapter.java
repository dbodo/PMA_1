package com.example.student.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.student.myapplication.fragments.FirstFragment;

public class FragmentViewPagerAdapter extends FragmentPagerAdapter {
    public FragmentViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }


    @Override
    public Fragment getItem(int position) {
        if(position == 0){
            return FirstFragment.newInstance("","");
        }
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}
