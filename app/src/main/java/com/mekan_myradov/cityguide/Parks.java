package com.mekan_myradov.cityguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Parks extends AppCompatActivity {

    RecyclerView rvParks;
    String titles[] = {"Hyde Park", "Eleanor Tinsley Park"};
    String infos[] = {  "Hyde Park is a Grade I-listed major park in Central London. " +
                        "It is the largest of four Royal Parks that form a chain from the entrance of " +
                        "Kensington Palace through Kensington Gardens and Hyde Park, via Hyde Park Corner " +
                        "and Green Park past the main entrance to Buckingham Palace.",

                        "Eleanor Tinsley Park is a section of Buffalo Bayou Park in Houston, Texas. " +
                        "With downtown’s skyline as its back drop, Houston’s premier greenbelt winds from " +
                        "Shepherd Drive on the west to Bagby Street on the East End. Eleanor Tinsley Park, " +
                        "located within this greenway (Taft-Sabine), is the site of major Houston festivals and " +
                        "events, including the city’s Fourth of July Fireworks."
                     };
    String costs[] = {"Price: Free", "Price: Free"};
    String hours[] = {"Open: 5AM-12AM", "Open: 24 hours"};
    int images[] = {R.drawable.park01, R.drawable.park02};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parks);

        rvParks = findViewById(R.id.rvParks);

        RVAdapter rvAdapter = new RVAdapter(this, titles, infos, costs, hours, images);

        rvParks.setAdapter(rvAdapter);
        rvParks.setLayoutManager(new LinearLayoutManager(this));
    }
}