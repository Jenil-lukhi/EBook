package com.example.ebooks;

import android.app.Person;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class pagerAdapter extends FragmentPagerAdapter {

    private final int totalTabs;

    public pagerAdapter(@NonNull FragmentManager fm, int totalTabs) {
        super(fm);
        this.totalTabs = totalTabs;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        if (position == 0)
            return new Home_Fragment();

        if (position == 1)
            return new Book_Fragment();

        return new Person_Fragment();

    }

    @Override
    public int getCount() {
        return totalTabs;
    }
}
