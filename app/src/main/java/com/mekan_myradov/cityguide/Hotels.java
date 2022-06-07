package com.mekan_myradov.cityguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Hotels extends AppCompatActivity {

    RecyclerView rvHotels;
    String titles[] = {"InterContinental Chengdu", "Hyatt Regency Houston"};
    String infos[] = {  "InterContinental Chengdu is located along Century City Boulevard. " +
                        "Offering free Wi-Fi and wired internet access, InterContinental Chengdu " +
                        "Global Center provides a water park, 2 swimming pools and a fitness center. " +
                        "Mingdu Park is a 15-minute walk away. On-site hot spring bath is also featured.",

                        "This Houston hotel features several on-site dining venues. " +
                        "Hyatt Regency Houston has guest rooms furnished with a flat-panel TV " +
                        "and an iPod docking station. A Single-cup coffee maker and boutique toiletries " +
                        "are provided in each room."
    };
    String costs[] = {"Price: $700 per Adult", "Price: $750 per Adult"};
    String hours[] = {"Open: 24 hours", "Open: 24 hours"};
    int images[] = {R.drawable.hotel01, R.drawable.hotel02};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels);

        rvHotels = findViewById(R.id.rvHotels);

        RVAdapter rvAdapter = new RVAdapter(this, titles, infos, costs, hours, images);

        rvHotels.setAdapter(rvAdapter);
        rvHotels.setLayoutManager(new LinearLayoutManager(this));
    }
}