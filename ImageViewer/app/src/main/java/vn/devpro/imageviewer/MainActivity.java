package vn.devpro.imageviewer;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imgPhoto;
    Button btnBack, btnNext;


    int[] images = {
            R.drawable.image_1,
            R.drawable.image_2,
            R.drawable.image_3
    };


    int currentImage = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imgPhoto = findViewById(R.id.imgPhoto);
        btnBack = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);


        showImage();


        btnNext.setOnClickListener(v -> {

            if (currentImage < images.length - 1) {

                currentImage++;

                showImage();
            }
        });


        btnBack.setOnClickListener(v -> {

            if (currentImage > 0) {

                currentImage--;

                showImage();
            }
        });
    }


    private void showImage() {


        imgPhoto.setImageResource(
                images[currentImage]
        );


        if (currentImage == 0) {

            btnBack.setVisibility(
                    View.INVISIBLE
            );

        } else {

            btnBack.setVisibility(
                    View.VISIBLE
            );
        }


        if (currentImage
                == images.length - 1) {

            btnNext.setVisibility(
                    View.INVISIBLE
            );

        } else {

            btnNext.setVisibility(
                    View.VISIBLE
            );
        }
    }
}