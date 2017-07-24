package com.example.tcgongonmac.tachakarn_midterm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;

public class screen3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen3);

        Intent intent = getIntent();
        String selectUni = intent.getExtras().getString("universityName");

        ImageView universityImage =(ImageView) findViewById(R.id.imageVote);
        universityImage.setImageResource(getResources().getIdentifier(selectUni, "drawable", getPackageName()));

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Intent intent = new Intent();
                intent.putExtra("star", (int) rating);
                setResult(RESULT_OK, intent);
                finish();

            }
        });

    }



}
