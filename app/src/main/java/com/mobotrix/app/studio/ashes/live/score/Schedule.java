package com.mobotrix.app.studio.ashes.live.score;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Schedule extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        // data to populate the RecyclerView of basic courses
        ArrayList<String> Match_Number = new ArrayList<>();
        Match_Number.add("1st Test");
        Match_Number.add("2nd Test");
        Match_Number.add("3rd Test");
        Match_Number.add("4th Test");
        Match_Number.add("5th Test");

        ArrayList<String> Match_Date_Time = new ArrayList<>();
        Match_Date_Time.add("Dec 08, Wed - Dec 12, Sun\n 12:00 AM GMT / 10:00 AM LOCAL");
        Match_Date_Time.add("Dec 16, Thu - Dec 20, Mon\n 04:00 AM GMT / 02:30 PM LOCAL");
        Match_Date_Time.add("Dec 26, Sun - Dec 30, Thu\n 11:30 PM GMT (Dec 25) / 10:30 AM LOCAL");
        Match_Date_Time.add("Jan 05, Wed - Jan 09, Sun\n 11:30 PM GMT (Jan 04) / 10:30 AM LOCAL");
        Match_Date_Time.add("Jan 14, Fri - Jan 18, Tue\n 02:30 AM GMT / 10:30 AM LOCAL");

        ArrayList<String> Match_Location = new ArrayList<>();
        Match_Location.add("The Gabba, Brisbane");
        Match_Location.add("Adelaide Oval, Adelaide");
        Match_Location.add("Melbourne Cricket Ground, Melbourne");
        Match_Location.add("Sydney Cricket Ground, Sydney");
        Match_Location.add("Perth Stadium, Perth");

        // Basic courses
        // set up the RecyclerView for basic courses
        RecyclerView recyclerView2 = findViewById(R.id.recycler_view_schedule);
        Schedule_adapter adapter2 = new Schedule_adapter(this, Match_Number, Match_Date_Time, Match_Location);
        adapter2.setClickListener(new Schedule_adapter.ItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Basic Course

            }
            //Toast.makeText(this, "You clicked Basic" + adapter.getItem(position) /*+ " on item position " + position*/, Toast.LENGTH_SHORT).show();

        });
        recyclerView2.setAdapter(adapter2);

    }
}