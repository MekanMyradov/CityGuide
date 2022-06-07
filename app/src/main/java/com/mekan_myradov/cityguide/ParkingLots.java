package com.mekan_myradov.cityguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ParkingLots extends AppCompatActivity {

    RecyclerView rvParkingLots;
    String titles[] = {"Open Air Parking", "Central Parking"};
    String infos[] = {  "Open Air Paring station is the largest parking lot in Central London. " +
                        "Parking lots and garages are a common sight today. The most common are " +
                        "parking lots and spaces for automobiles. Motorcycles and bicycles often " +
                        "have designated parking in automobile parking lots as well.",

                        "Central Parking station is a section of Buffalo Bayou Park in Houston, Texas. " +
                        "RVs and mobile homes have their own parking lots separate from automobiles. " +
                        "Parking facilities are often built where offices, restaurants, malls, amusement " +
                        "parks, hotels, hospitals, and schools are situated."
                     };
    String costs[] = {"Price: $5 per Hour", "Price: $3 per Hour"};
    String hours[] = {"Open: 24 hours", "Open: 24 hours"};
    int images[] = {R.drawable.lots01, R.drawable.lots02};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking_lots);

        rvParkingLots = findViewById(R.id.rvParkingLots);

        RVAdapter rvAdapter = new RVAdapter(this, titles, infos, costs, hours, images);

        rvParkingLots.setAdapter(rvAdapter);
        rvParkingLots.setLayoutManager(new LinearLayoutManager(this));
    }
}