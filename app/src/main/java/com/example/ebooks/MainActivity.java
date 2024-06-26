package com.example.ebooks;

import android.graphics.PorterDuff;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.gms.ads.AdView;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        if (tabLayout != null) {

            tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.home));
            tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.vector));
            tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.menuicon));

            PagerAdapter adapter = new pagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
            viewPager.setAdapter(adapter);

            viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
            tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {
                    viewPager.setCurrentItem(tab.getPosition());
                    int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.brown);
                    tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {
                    int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.white);
                    tab.getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });


            int tabIconColor = ContextCompat.getColor(MainActivity.this, R.color.brown);
            if (tabLayout.getTabAt(tabLayout.getSelectedTabPosition()) != null &&
                    Objects.requireNonNull(tabLayout.getTabAt(tabLayout.getSelectedTabPosition())).getIcon() != null) {
                Objects.requireNonNull(tabLayout.getTabAt(tabLayout.getSelectedTabPosition())).getIcon().setColorFilter(tabIconColor, PorterDuff.Mode.SRC_IN);
            }
        }
    }
}
