package com.mobotrix.app.studio.ashes.live.score;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class EnglandSquad extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_england_squad);

        // data to populate the RecyclerView of basic courses
        ArrayList<Integer> Eng_Player_Image = new ArrayList<>();
        Eng_Player_Image.add(R.drawable.eoin_morgan);
        Eng_Player_Image.add(R.drawable.joe_root);
        Eng_Player_Image.add(R.drawable.jason_roy);
        Eng_Player_Image.add(R.drawable.liam_livingstone);
        Eng_Player_Image.add(R.drawable.dawid_malan);
        Eng_Player_Image.add(R.drawable.moeen_ali);
        Eng_Player_Image.add(R.drawable.ben_stokes);
        Eng_Player_Image.add(R.drawable.chris_woakes);
        Eng_Player_Image.add(R.drawable.tom_curran);
        Eng_Player_Image.add(R.drawable.sam_curran);
        Eng_Player_Image.add(R.drawable.jonny_bairstow);
        Eng_Player_Image.add(R.drawable.jos_buttler);
        Eng_Player_Image.add(R.drawable.adil_rashid);
        Eng_Player_Image.add(R.drawable.mark_wood);
        Eng_Player_Image.add(R.drawable.jofra_archer);
        Eng_Player_Image.add(R.drawable.chris_jordan);

        ArrayList<String> Eng_Player_Name = new ArrayList<>();
        Eng_Player_Name.add("Eoin Morgan");
        Eng_Player_Name.add("Joe Root");
        Eng_Player_Name.add("Jason Roy");
        Eng_Player_Name.add("Liam Livingstone");
        Eng_Player_Name.add("Dawid Malan");
        Eng_Player_Name.add("Moeen Ali");
        Eng_Player_Name.add("Ben Stokes");
        Eng_Player_Name.add("Chris Woakes");
        Eng_Player_Name.add("Tom Curran");
        Eng_Player_Name.add("Sam Curran");
        Eng_Player_Name.add("Jonny Bairstrow");
        Eng_Player_Name.add("Jos Buttler");
        Eng_Player_Name.add("Adil Rashid");
        Eng_Player_Name.add("Mark Wood");
        Eng_Player_Name.add("Jofra Archer");
        Eng_Player_Name.add("Chris Jordan");

        ArrayList<String> Eng_Player_Role = new ArrayList<>();
        Eng_Player_Role.add("Batsman");
        Eng_Player_Role.add("Batsman");
        Eng_Player_Role.add("Batsman");
        Eng_Player_Role.add("Batsman");
        Eng_Player_Role.add("Batsman");
        Eng_Player_Role.add("All Rounder");
        Eng_Player_Role.add("All Rounder");
        Eng_Player_Role.add("All Rounder");
        Eng_Player_Role.add("All Rounder");
        Eng_Player_Role.add("All Rounder");
        Eng_Player_Role.add("Wicket Keeper");
        Eng_Player_Role.add("Wicket Keeper");
        Eng_Player_Role.add("Bowler");
        Eng_Player_Role.add("Bowler");
        Eng_Player_Role.add("Bowler");
        Eng_Player_Role.add("Bowler");



        // Basic courses
        // set up the RecyclerView for basic courses
        RecyclerView recyclerView = findViewById(R.id.recycler_view_england);
        England_Players_adapter adapter = new England_Players_adapter(this, Eng_Player_Image, Eng_Player_Name, Eng_Player_Role);
        adapter.setClickListener(new England_Players_adapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Basic Course

                }
                //Toast.makeText(this, "You clicked Basic" + adapter.getItem(position) /*+ " on item position " + position*/, Toast.LENGTH_SHORT).show();

        });
        recyclerView.setAdapter(adapter);

    }
}