package com.mekan_myradov.cityguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class Shops extends AppCompatActivity {

    RecyclerView rvShops;
    String titles[] = {"Borough Market", "Harrods"};
    String infos[] = {  "An amazing food market dating back to the 13th century. " +
                        "A market that originally adjoined the end of London Bridge was first mentioned in 1276, " +
                        "although the market itself claims to have existed since 1014 \"and probably much earlier\" " +
                        "and was subsequently moved south of St Margaret's church on the High Street. The City of London " +
                        "received a royal charter from Edward VI in 1550 to control all markets in Southwark, which was " +
                        "confirmed by Charles II in 1671. However, the market caused such traffic congestion that, in 1754, " +
                        "it was abolished by an Act of Parliament.",

                        "The store was opened in 1849 as an expansion of humble East End grocery. " +
                        "Harrods remains at the height of British luxury retail, attracting millions " +
                        "of loyal customers from across the globe with its unrivalled product selection, " +
                        "world-class service, innovative retail theatre and historic setting."
                     };
    String costs[] = {"", ""};
    String hours[] = {"Open: 10AM-3PM", "Open: 11AM-6PM"};
    int images[] = {R.drawable.shop01, R.drawable.shop02};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shops);

        rvShops = findViewById(R.id.rvShops);

        RVAdapter rvAdapter = new RVAdapter(this, titles, infos, costs, hours, images);

        rvShops.setAdapter(rvAdapter);
        rvShops.setLayoutManager(new LinearLayoutManager(this));
    }
}