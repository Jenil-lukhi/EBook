package com.example.ebooks;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.ebooks.Authors.First_Activity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class Home_Fragment extends Fragment implements NavigationView.OnNavigationItemSelectedListener{

    TextView seeall, seeall1;
    ImageView image1, image2,moreButton;
    SearchView searchView;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private InterstitialAd mInterstitialAd;
    private AdView mAdView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home_, container, false);

        mAdView = view.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd (adRequest);
        new Thread(
                () -> {

                    MobileAds.initialize(requireActivity(), initializationStatus -> {
                    });
                })
                .start();

        setAds();


        seeall = view.findViewById(R.id.see_all);
        seeall1 = view.findViewById(R.id.see_all2);
        image1 = view.findViewById(R.id.image01);
        image2 = view.findViewById(R.id.image02);
        searchView = view.findViewById(R.id.rectangle_1);

        drawerLayout = view.findViewById(R.id.drawer_layout4);
        NavigationView navigationView = view.findViewById(R.id.nav_view4);
        moreButton = view.findViewById(R.id.menu);

        navigationView.setNavigationItemSelectedListener(this);


        moreButton.setOnClickListener(v -> drawerLayout.openDrawer(Gravity.LEFT));


        seeall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd != null) {
                    mInterstitialAd.show(getActivity());

                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            startActivity(new Intent(getActivity(), Popular_books_Activity.class));
                            mInterstitialAd = null;
                            setAds();
                        }
                    });


                } else {
                    startActivity(new Intent(getActivity(), Popular_books_Activity.class));
                }


            }
        });




        seeall1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mInterstitialAd != null) {
                    mInterstitialAd.show(getActivity());

                    mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                        @Override
                        public void onAdDismissedFullScreenContent() {
                            super.onAdDismissedFullScreenContent();
                            startActivity(new Intent(getActivity(), First_Activity.class));
                            mInterstitialAd = null;
                            setAds();
                        }
                    });


                } else {
                    startActivity(new Intent(getActivity(), First_Activity.class));
                }


            }
        });

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/books/edition/Enzo_Ferrari/iVmnDwAAQBAJ?hl=en&gbpv=1&dq=enzo+ferrari:+the+man+and+the+machine+paperback&printsec=frontcover"));
                startActivity(intent);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.co.in/books/edition/Wings_of_Fire/c3qmIZtWUjAC?hl=en&gbpv=1&dq=wings+of+fire&printsec=frontcover"));
                startActivity(intent);
            }
        });


        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                performSearch(query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                return false;
            }
        });

        return view;
    }
    public void setAds(){

        AdRequest adRequest = new AdRequest.Builder().build();

        InterstitialAd.load(getActivity(),"ca-app-pub-3940256099942544/1033173712", adRequest,
                new InterstitialAdLoadCallback() {
                    @Override
                    public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                        // The mInterstitialAd reference will be null until
                        // an ad is loaded.
                        mInterstitialAd = interstitialAd;

                    }

                    @Override
                    public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                        // Handle the error
                        mInterstitialAd = null;
                    }
                });
    }


    private void performSearch(String query) {

        Intent intent = new Intent(getActivity(), SearchResultActivity.class);
        intent.putExtra("query", query);
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.nav_item1) {
            startActivity(new Intent(getActivity(), EditProfile_Activity.class));
        } else if (id == R.id.nav_item2) {
            startActivity(new Intent(getActivity(), Save_Activity.class));
        } else if (id == R.id.nav_item3) {
            startActivity(new Intent(getActivity(), Notifications_Activity.class));
        } else if (id == R.id.nav_item4) {
            startActivity(new Intent(getActivity(), Favorites_Activity.class));
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}
