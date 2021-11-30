package com.mobotrix.app.studio.ashes.live.score;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.slider.Slider;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private AdView mAdView;
    RecyclerView mrecyclerview;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int i2 = Color.parseColor("#304266");
        //Toaster.txtlayouttoast2(this,"fdfdfd This is Working","#FF0000",i );







        mrecyclerview = findViewById(R.id.recycler_view_mainactivity);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        mAdView = findViewById(R.id.adView_mainactivity);
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
        ArrayList<Integer> Main_Image = new ArrayList<>();
        Main_Image.add(R.drawable.aaron_finch);
        Main_Image.add(R.drawable.steven_smith);
        Main_Image.add(R.drawable.david_warner);
        Main_Image.add(R.drawable.joe_burns);
        Main_Image.add(R.drawable.glenn_maxwell);
        Main_Image.add(R.drawable.marcus_stoinis);
        Main_Image.add(R.drawable.moises_henriques);



        ArrayList<String> Main_Name = new ArrayList<>();
        Main_Name.add("Schedule");
        Main_Name.add("Teams");
        Main_Name.add("Stadiums");
        Main_Name.add("Live Score");
        Main_Name.add("Result");
        Main_Name.add("Points Table");
        Main_Name.add("Moisesenriques");



        // Basic courses
        // set up the RecyclerView for basic courses
        RecyclerView recyclerView = findViewById(R.id.recycler_view_mainactivity);
        Main_adapter adapters = new Main_adapter(this, Main_Image, Main_Name);
        adapters.setClickListener(new Main_adapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String s = adapters.getItem(position);
                String s2 ="s";
                //Basic Course
                //Toast.makeText(this,  s2, Toast.LENGTH_SHORT).show();

                Toast.makeText(getApplicationContext(),"Hello Javatpoint"  +s ,Toast.LENGTH_SHORT).show();

                switch(position) {
                    case 0:
                        i = new Intent(MainActivity.this, AustraliaSquad.class);
                        startActivity(i);
                        break;
                    case 1:
                        i = new Intent(MainActivity.this, EnglandSquad.class);
                        startActivity(i);
                        break;

                    case 2:
                        i = new Intent(MainActivity.this, MatchResult.class);
                        startActivity(i);
                        break;

                    case 3:
                        i = new Intent(MainActivity.this, Schedule.class);
                        startActivity(i);
                        break;

                    case 4:
                        i = new Intent(MainActivity.this, Stadiums.class);
                        startActivity(i);
                        break;

                    case 5:
                        i = new Intent(MainActivity.this, LiveScore.class);
                        startActivity(i);
                        break;
                    default:
                        break;

            }
            }
            //Toast.makeText(this, "You clicked Basic" + adapter.getItem(position) /*+ " on item position " + position*/, Toast.LENGTH_SHORT).show();

        });
        recyclerView.setAdapter(adapters);


    }
}