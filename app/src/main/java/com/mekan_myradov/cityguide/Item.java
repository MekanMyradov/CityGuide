package com.mekan_myradov.cityguide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Item extends AppCompatActivity {

    ImageView imgItem;
    TextView txtTitleItem, txtHoursItem, txtCostItem;
    EditText etInfoItem, etReview, etRating;
    String title, info, cost, hour;
    int image;
    Button btnSent;
    DBHelper db;
    ReviewsAdapter reviewsAdapter;
    RecyclerView rvReviews;

    ArrayList<String> arrAuthor, arrReviewDate, arrReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        imgItem = findViewById(R.id.imgItem);
        txtTitleItem = findViewById(R.id.txtTitleItem);
        txtHoursItem = findViewById(R.id.txtHoursItem);
        txtCostItem = findViewById(R.id.txtCostItem);
        etInfoItem = findViewById(R.id.etInfoItem);

        etReview = findViewById(R.id.etReview);
        etRating = findViewById(R.id.etRating);
        btnSent = findViewById(R.id.btnSent);

        rvReviews = findViewById(R.id.rvReviews);

        db = new DBHelper(this);

        arrAuthor = new ArrayList<>();
        arrReviewDate = new ArrayList<>();
        arrReview = new ArrayList<>();

        getData();
        setData();

        readReviews();

        reviewsAdapter = new ReviewsAdapter(Item.this, arrAuthor, arrReviewDate, arrReview);
        rvReviews.setAdapter(reviewsAdapter);
        rvReviews.setLayoutManager(new LinearLayoutManager(Item.this));

        btnSent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String review, rating;
                review = etReview.getText().toString();
                rating = etRating.getText().toString();

                if(review.equals("") || rating.equals("")){
                    Toast.makeText(Item.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else{

                    String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

                    Boolean insert = db.insertReview(new Integer(rating), title, User.userName, currentDate, review);

                    if(insert == true){
                        Toast.makeText(Item.this, "Review saved successfully", Toast.LENGTH_SHORT).show();
                        finish();
                        startActivity(getIntent());
                    }
                    else{
                        Toast.makeText(Item.this, "Review could not be saved", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    void readReviews(){
        Cursor cursor = db.readReviews(title);
        if(cursor.getCount() == 0){
            Toast.makeText(Item.this, "There is no review for this venue", Toast.LENGTH_SHORT).show();
        }
        else{
            while(cursor.moveToNext()){
                arrAuthor.add(cursor.getString(3));
                arrReviewDate.add(cursor.getString(4));
                arrReview.add(cursor.getString(5));
            }
        }
    }

    private void getData(){
        if(getIntent().hasExtra("title") && getIntent().hasExtra("info") && getIntent().hasExtra("cost") && getIntent().hasExtra("hour") && getIntent().hasExtra("image")){
            title = getIntent().getStringExtra("title");
            info = getIntent().getStringExtra("info");
            cost = getIntent().getStringExtra("cost");
            hour = getIntent().getStringExtra("hour");
            image = getIntent().getIntExtra("image", 1);
        }
        else{
            Toast.makeText(this, "No data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        imgItem.setImageResource(image);
        txtTitleItem.setText(title);
        txtHoursItem.setText(hour);
        txtCostItem.setText(cost);
        etInfoItem.setText(info);
    }
}