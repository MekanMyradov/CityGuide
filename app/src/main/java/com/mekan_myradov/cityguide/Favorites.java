package com.mekan_myradov.cityguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class Favorites extends AppCompatActivity {

    RecyclerView rvFavorites;
    DBHelper db;
    ArrayList<String> venues, ratings;
    FavoritesAdapter favoritesAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        rvFavorites = findViewById(R.id.rvFavorites);
        db = new DBHelper(Favorites.this);
        venues = new ArrayList<>();
        ratings = new ArrayList<>();

        readFavorites();

        favoritesAdapter = new FavoritesAdapter(Favorites.this, venues, ratings);
        rvFavorites.setAdapter(favoritesAdapter);
        rvFavorites.setLayoutManager(new LinearLayoutManager(Favorites.this));
    }

    void readFavorites(){
        Cursor cursor = db.retrieveFavorites();
        if(cursor.getCount() == 0){
            Toast.makeText(this, "No venues to display", Toast.LENGTH_SHORT).show();
        }
        else{
            while (cursor.moveToNext()){
                venues.add(cursor.getString(0));
                double random = 4.1 + Math.random() * (5.0 - 4.1);
                // ratings.add(Double.toString(random));
                ratings.add(new DecimalFormat("##.##").format(random));
            }
        }
    }
}