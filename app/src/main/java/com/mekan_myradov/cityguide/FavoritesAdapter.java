package com.mekan_myradov.cityguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.MyViewHolder> {

    private Context context;
    private ArrayList venues, ratings;

    FavoritesAdapter(Context context, ArrayList venues, ArrayList ratings){
        this.context = context;
        this.venues = venues;
        this.ratings = ratings;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.favorites_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvVenueName.setText(String.valueOf(venues.get(position)));
        holder.tvVenueRating.setText(String.valueOf(ratings.get(position)));
    }

    @Override
    public int getItemCount() {
        return venues.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvVenueName, tvVenueRating;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvVenueName = itemView.findViewById(R.id.tvVenueName);
            tvVenueRating = itemView.findViewById(R.id.tvVenueRating);
        }
    }
}
