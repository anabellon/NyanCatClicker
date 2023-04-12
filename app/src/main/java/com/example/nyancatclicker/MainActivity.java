package com.example.nyancatclicker;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private ImageView secondImageView;
    private ImageView thirdImageView;
    private TextView textView;
    private int clickCount = 0;
    private int imageIndex = 0;
    private int[] imageIds = {R.drawable.image1, R.drawable.image2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        secondImageView = findViewById(R.id.secondImageView);
        thirdImageView = findViewById(R.id.thirdImageView);
        textView = findViewById(R.id.textView);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;
                imageIndex = (imageIndex + 1) % imageIds.length;
                imageView.setImageResource(imageIds[imageIndex]);
                textView.setText("Clicks: " + clickCount);

                if (clickCount >= 25) {
                    int color = generateRainbowColor();
                    getWindow().getDecorView().setBackgroundColor(color);
                }

                if (clickCount >= 50) {
                    // torna o balloonnyancat visível
                    secondImageView.setVisibility(View.VISIBLE);
                }

                if (clickCount >= 75) {
                    // torna o taconyancat visível
                    thirdImageView.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    // gerador de cor aleatória do arco-íris
    private int generateRainbowColor() {
        float[] hsv = new float[3];
        hsv[0] = (float) Math.random() * 360;
        hsv[1] = 1;
        hsv[2] = 1;
        return Color.HSVToColor(hsv);
    }
}