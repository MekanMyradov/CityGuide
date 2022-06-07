package com.mekan_myradov.cityguide;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ReviewsAdapter extends RecyclerView.Adapter<ReviewsAdapter.MyViewHolder>{

    private Context context;
    private ArrayList arrAuthor, arrReviewDate, arrReview;

    ReviewsAdapter(Context context, ArrayList arrAuthor, ArrayList arrReviewDate, ArrayList arrReview){
        this.context = context;
        this.arrAuthor = arrAuthor;
        this.arrReviewDate = arrReviewDate;
        this.arrReview = arrReview;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.review_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvAuthor.setText(String.valueOf(arrAuthor.get(position)));
        holder.tvDate.setText(String.valueOf(arrReviewDate.get(position)));
        holder.tvComment.setText(String.valueOf(arrReview.get(position)));
    }

    @Override
    public int getItemCount() {
        return arrAuthor.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvAuthor, tvDate, tvComment;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            tvDate = itemView.findViewById(R.id.tvDate);
            tvComment = itemView.findViewById(R.id.tvComment);
        }
    }
}
