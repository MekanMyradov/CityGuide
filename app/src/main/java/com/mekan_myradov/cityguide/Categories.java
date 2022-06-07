package com.mekan_myradov.cityguide;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Categories extends AppCompatActivity {

    Button btnFavorites, btnParks, btnLibraries, btnHistoricalPlaces, btnHotels, btnShops, btnPlacesOfWorship, btnParkingLots, btnLogOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        btnFavorites = (Button) findViewById(R.id.btnFavorites);
        btnParks = (Button) findViewById(R.id.btnParks);
        btnLibraries = (Button) findViewById(R.id.btnLibrary);
        btnHistoricalPlaces = (Button) findViewById(R.id.btnHistoricalPlaces);
        btnHotels = (Button) findViewById(R.id.btnHotels);
        btnShops = (Button) findViewById(R.id.btnShops);
        btnPlacesOfWorship = (Button) findViewById(R.id.btnPlacesOfWorship);
        btnParkingLots = (Button) findViewById(R.id.btnParkingLots);
        btnLogOut = (Button) findViewById(R.id.btnLogOut);

        btnFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Favorites.class);
                startActivity(intent);
            }
        });

        btnParks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Parks.class);
                startActivity(intent);
            }
        });

        btnLibraries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Libraries.class);
                startActivity(intent);
            }
        });

        btnHistoricalPlaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), HistoricalPlaces.class);
                startActivity(intent);
            }
        });

        btnHotels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Hotels.class);
                startActivity(intent);
            }
        });

        btnShops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Shops.class);
                startActivity(intent);
            }
        });

        btnPlacesOfWorship.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PlacesOfWorship.class);
                startActivity(intent);
            }
        });

        btnParkingLots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ParkingLots.class);
                startActivity(intent);
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LogIn.class);
                startActivity(intent);
            }
        });
    }
}