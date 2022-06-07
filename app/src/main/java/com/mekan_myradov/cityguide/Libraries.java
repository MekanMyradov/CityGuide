package com.mekan_myradov.cityguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Libraries extends AppCompatActivity {

    RecyclerView rvLibraries;
    String titles[] = {"Cambridge Library", "The Pepys Library"};
    String infos[] = {  "Cambridge University Library is the main research library of the University of Cambridge. " +
                        "It is the largest of the over 100 libraries within the University. The Library is a major " +
                        "scholarly resource for the members of the University of Cambridge and external researchers. " +
                        "It is often referred to within the University as the UL. Thirty three faculty and departmental " +
                        "libraries are associated with the University Library for the purpose of central governance and " +
                        "administration, forming \"Cambridge University Libraries\".",

                        "The library is housed in their original bookcases, or book presses. " +
                        "The Pepys Library of Magdalene College, Cambridge, is the personal library " +
                        "collected by Samuel Pepys which he bequeathed to the college following his death in 1703. " +
                        "Samuel Pepys was a lifelong bibliophile and carefully nurtured his large collection of books, " +
                        "manuscripts, and prints. At his death, there were more than 3,000 volumes, including the diary, " +
                        "all carefully catalogued and indexed; they form one of the most important surviving 17th-century private libraries."
                     };
    String costs[] = {"Price: Free", "Price: Free"};
    String hours[] = {"Open: 9AM-9PM", "Open: 9AM-7PM"};
    int images[] = {R.drawable.lib01, R.drawable.lib02};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_libraries);

        rvLibraries = findViewById(R.id.rvLibraries);

        RVAdapter rvAdapter = new RVAdapter(this, titles, infos, costs, hours, images);

        rvLibraries.setAdapter(rvAdapter);
        rvLibraries.setLayoutManager(new LinearLayoutManager(this));
    }
}