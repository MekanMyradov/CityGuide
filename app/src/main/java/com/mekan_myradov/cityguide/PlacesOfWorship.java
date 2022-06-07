package com.mekan_myradov.cityguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class PlacesOfWorship extends AppCompatActivity {

    RecyclerView rvPlacesOfWorship;
    String titles[] = {"Matthias Church", "Hagia Sophia Mosque"};
    String infos[] = {  "The church is used over the centuries as a coronation church for the Hungarian kings. " +
                        "The Church of the Assumption of the Buda Castle, more commonly known as the Matthias Church, " +
                        "more rarely the Coronation Church of Buda, is a Roman Catholic church located in the Holy Trinity " +
                        "Square, Budapest, Hungary, in front of the Fisherman's Bastion at the heart of Buda's Castle District.",

                        "This architectural marvel displays 30 million gold tiles throughout its interior, and a wide. " +
                        "Hagia Sophia, officially known as the Hagia Sophia Grand Mosque and formerly as the Church of " +
                        "Holy Wisdom, is a Late Antique place of worship in Istanbul, designed by the Greek geometers " +
                        "Isidore of Miletus and Anthemius of Tralles."
                     };
    String costs[] = {"", ""};
    String hours[] = {"Open: 1PM-5PM", "Open: 9AM-5PM"};
    int images[] = {R.drawable.worship01, R.drawable.worship02};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places_of_worship);

        rvPlacesOfWorship = findViewById(R.id.rvPlacesOfWorship);

        RVAdapter rvAdapter = new RVAdapter(this, titles, infos, costs, hours, images);

        rvPlacesOfWorship.setAdapter(rvAdapter);
        rvPlacesOfWorship.setLayoutManager(new LinearLayoutManager(this));
    }
}