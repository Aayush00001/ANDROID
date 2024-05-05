package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class Image_View_Activity extends AppCompatActivity {

    private ImageView mainImageView;
    private ImageView image1, image2, image3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        mainImageView = findViewById(R.id.mainImageView);
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);
    }

    public void onThumbnailClick(View view) {
        final int clickedImageResource;

        if (view.getId() == R.id.image1) {
            clickedImageResource = R.drawable.your1;
        } else if (view.getId() == R.id.image2) {
            clickedImageResource = R.drawable.yoru;
        } else if (view.getId() == R.id.image3) {
            clickedImageResource = R.drawable.jett;
        } else {
            clickedImageResource = 0;
        }

        // Set the clicked image in the mainImageView
        if (clickedImageResource != 0) {
            ((ImageView) mainImageView).setImageResource(clickedImageResource);
        }
    }
}
