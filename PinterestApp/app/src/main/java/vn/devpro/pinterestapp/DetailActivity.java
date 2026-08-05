package vn.devpro.pinterestapp;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity
        extends AppCompatActivity {

    private ImageView imgFull;

    private ImageButton btnBack;

    @Override
    protected void onCreate(
            Bundle savedInstanceState
    ) {

        super.onCreate(
                savedInstanceState
        );

        setContentView(
                R.layout.activity_detail
        );

        imgFull =
                findViewById(
                        R.id.imgFull
                );

        btnBack =
                findViewById(
                        R.id.btnBack
                );

        int imageId =
                getIntent().getIntExtra(
                        "IMAGE_ID",
                        0
                );

        if (imageId != 0) {

            imgFull.setImageResource(
                    imageId
            );
        }

        btnBack.setOnClickListener(v -> {

            finish();
        });
    }
}