package com.mobotrix.app.studio.ashes.live.score;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Stadiums extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stadiums);


        // data to populate the RecyclerView of basic courses
        ArrayList<Integer> Stadium_Image = new ArrayList<>();
        Stadium_Image.add(R.drawable.aaron_finch);
        Stadium_Image.add(R.drawable.steven_smith);
        Stadium_Image.add(R.drawable.david_warner);
        Stadium_Image.add(R.drawable.joe_burns);
        Stadium_Image.add(R.drawable.glenn_maxwell);
        Stadium_Image.add(R.drawable.marcus_stoinis);
        Stadium_Image.add(R.drawable.moises_henriques);



        ArrayList<String> Stadium_Name = new ArrayList<>();
        Stadium_Name.add("Schedule");
        Stadium_Name.add("Teams");
        Stadium_Name.add("Stadiums");
        Stadium_Name.add("Live Score");
        Stadium_Name.add("Result");
        Stadium_Name.add("Points Table");
        Stadium_Name.add("Moisesenriques");


        // Basic courses
        // set up the RecyclerView for basic courses
        RecyclerView recyclerView = findViewById(R.id.recycler_view_australia);
        Stadium_adapter adapter = new Stadium_adapter(this, Stadium_Image, Stadium_Name);
        adapter.setClickListener(new Stadium_adapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Basic Course

            }
            //Toast.makeText(this, "You clicked Basic" + adapter.getItem(position) /*+ " on item position " + position*/, Toast.LENGTH_SHORT).show();

        });
        recyclerView.setAdapter(adapter);

    }
}