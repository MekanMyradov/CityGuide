package com.mekan_myradov.cityguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class HistoricalPlaces extends AppCompatActivity {

    RecyclerView rvHistoricalPlaces;
    String titles[] = {"The Port Arthur", "The Great Wall"};
    String infos[] = {  "The Port Arthur is the best-preserved convict settlement in Australia. " +
                        "The Site combines rich history and scenic beauty to tell the stories of the " +
                        "harsh discipline and determined industry of the settlement. It is a place to " +
                        "discover Australian history and connect with the origins of Australian culture.",

                        "The Great Wall is a series of fortifications that were built across the historical China. " +
                        "In 1368 AD, Mutianyu Great Wall was built by Xu Da who is the main general for Zhuyuanzhang in " +
                        "the Great Wall ruins of Northern Qi Dynasty. Linked to Gubeikou in the east and Juyongguan in " +
                        "the west,the section of the Great Wall is the military hub defensing of the capitalsince ancient " +
                        "times. There are several famous watchtowers such as Zhengguantai, Dajiaolou, Yingfeidaoyang,Jiankou " +
                        "and Beijingjie, which has profound historical and cultural values."
                    };
    String costs[] = {"Price: $204", "Price: $250"};
    String hours[] = {"Open: 9AM-7PM", "Open: 10AM-4PM"};
    int images[] = {R.drawable.hist01, R.drawable.hist02};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historical_places);

        rvHistoricalPlaces = findViewById(R.id.rvHistoricalPlaces);

        RVAdapter rvAdapter = new RVAdapter(this, titles, infos, costs, hours, images);

        rvHistoricalPlaces.setAdapter(rvAdapter);
        rvHistoricalPlaces.setLayoutManager(new LinearLayoutManager(this));
    }
}