package com.mekan_myradov.cityguide;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.RVViewHolder> {

    Context context;
    String titles[], infos[], costs[], hours[];
    int images[];

    public RVAdapter(Context ct, String s1[], String s2[], String s3[], String s4[], int img[]){
        context = ct;
        titles = s1;
        infos = s2;
        costs = s3;
        hours = s4;
        images = img;
    }

    @NonNull
    @Override
    public RVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.row, parent, false);

        return new RVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RVViewHolder holder, int position) {
        holder.txtTitle.setText(titles[position]);
        holder.etInfo.setText(infos[position]);
        holder.txtCost.setText(costs[position]);
        holder.txtHours.setText(hours[position]);
        holder.imageView.setImageResource(images[position]);

        // for each item
        holder.mainlayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Item.class);
                intent.putExtra("title", titles[position]);
                intent.putExtra("info", infos[position]);
                intent.putExtra("cost", costs[position]);
                intent.putExtra("hour", hours[position]);
                intent.putExtra("image", images[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }

    public class RVViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle, txtCost, txtHours;
        EditText etInfo;
        ImageView imageView;
        ConstraintLayout mainlayout;

        public RVViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle);
            etInfo = itemView.findViewById(R.id.etInfo);
            txtCost = itemView.findViewById(R.id.txtCost);
            txtHours = itemView.findViewById(R.id.txtHours);
            imageView = itemView.findViewById(R.id.imageView);
            mainlayout = itemView.findViewById(R.id.mainLayout);
        }
    }
}
