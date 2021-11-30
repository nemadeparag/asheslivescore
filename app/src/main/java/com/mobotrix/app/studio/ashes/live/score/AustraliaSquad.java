package com.mobotrix.app.studio.ashes.live.score;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class AustraliaSquad extends AppCompatActivity {
    private AdView mAdView;
    RecyclerView mrecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_australia_squad);

        mrecyclerview = findViewById(R.id.recycler_view_australia);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        AdView adView = new AdView(this);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId("c-app-pub-3940256099942544/6300978111");
            // TODO: Add adView to your view hierarchy.

        adView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                mrecyclerview.setPadding(0,0 , 0,adView.getHeight());
                // recyclerView.setClipToPadding(false);
            }
        });

        // data to populate the RecyclerView of basic courses
        ArrayList<Integer> AUS_Player_Image = new ArrayList<>();
        AUS_Player_Image.add(R.drawable.aaron_finch);
        AUS_Player_Image.add(R.drawable.steven_smith);
        AUS_Player_Image.add(R.drawable.david_warner);
        AUS_Player_Image.add(R.drawable.glenn_maxwell);
        AUS_Player_Image.add(R.drawable.marcus_stoinis);
        AUS_Player_Image.add(R.drawable.moises_henriques);
        AUS_Player_Image.add(R.drawable.marnus_labuschagne);
        AUS_Player_Image.add(R.drawable.ashton_agar);
        AUS_Player_Image.add(R.drawable.alex_carey);
        AUS_Player_Image.add(R.drawable.matthew_wade);
        AUS_Player_Image.add(R.drawable.tim_paine);
        AUS_Player_Image.add(R.drawable.pat_cummins);
        AUS_Player_Image.add(R.drawable.nathan_lyon);
        AUS_Player_Image.add(R.drawable.mitchell_starc);
        AUS_Player_Image.add(R.drawable.adam_zampa);
        AUS_Player_Image.add(R.drawable.josh_hazlewood);
        AUS_Player_Image.add(R.drawable.andrew_tye);
        AUS_Player_Image.add(R.drawable.james_pattinson);


        ArrayList<String> AUS_Player_Name = new ArrayList<>();
        AUS_Player_Name.add("Aaron Finch");
        AUS_Player_Name.add("Steven Smith");
        AUS_Player_Name.add("David Warner");
        AUS_Player_Name.add("Glenn Maxwell");
        AUS_Player_Name.add("Marcus Stoinis");
        AUS_Player_Name.add("Moises Henriques");
        AUS_Player_Name.add("Marnus Labuschgne");
        AUS_Player_Name.add("Ashton Agar");
        AUS_Player_Name.add("Alex Carry");
        AUS_Player_Name.add("Matthew Wade");
        AUS_Player_Name.add("Tim Paine");
        AUS_Player_Name.add("Pat Cummins");
        AUS_Player_Name.add("Nathan Lyon");
        AUS_Player_Name.add("Mitchell Starc");
        AUS_Player_Name.add("Adam Zampa");
        AUS_Player_Name.add("Josh Hazlewood");
        AUS_Player_Name.add("Andrew Tye");
        AUS_Player_Name.add("James Pattinson");


        ArrayList<String> AUS_Player_Role = new ArrayList<>();
        AUS_Player_Role.add("Batsman");
        AUS_Player_Role.add("Batsman");
        AUS_Player_Role.add("Batsman");
        AUS_Player_Role.add("All Rounder");
        AUS_Player_Role.add("All Rounder");
        AUS_Player_Role.add("All Rounder");
        AUS_Player_Role.add("All Rounder");
        AUS_Player_Role.add("All Rounder");
        AUS_Player_Role.add("Wicket Keeper");
        AUS_Player_Role.add("Wicket Keeper");
        AUS_Player_Role.add("Wicket Keeper");
        AUS_Player_Role.add("Bowler");
        AUS_Player_Role.add("Bowler");
        AUS_Player_Role.add("Bowler");
        AUS_Player_Role.add("Bowler");
        AUS_Player_Role.add("Bowler");
        AUS_Player_Role.add("Bowler");
        AUS_Player_Role.add("Bowler");

        // Basic courses
        // set up the RecyclerView for basic courses
        RecyclerView recyclerView = findViewById(R.id.recycler_view_australia);
        Australia_Players_adapter adapter = new Australia_Players_adapter(this, AUS_Player_Image, AUS_Player_Name, AUS_Player_Role);
        adapter.setClickListener(new Australia_Players_adapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Basic Course

            }
            //Toast.makeText(this, "You clicked Basic" + adapter.getItem(position) /*+ " on item position " + position*/, Toast.LENGTH_SHORT).show();

        });
        recyclerView.setAdapter(adapter);

    }
}