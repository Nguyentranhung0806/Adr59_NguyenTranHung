package vn.devpro.pinterestapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity
        extends AppCompatActivity {

    private RecyclerView rvImages;

    private int[] imageList = {

            R.drawable.image_1,

            R.drawable.image_2,

            R.drawable.image_3,

            R.drawable.image_4,

            R.drawable.image_5,

            R.drawable.image_6,

            R.drawable.image_7,

            R.drawable.image_8,

            R.drawable.image_9,

            R.drawable.image_10
    };

    @Override
    protected void onCreate(
            Bundle savedInstanceState
    ) {

        super.onCreate(savedInstanceState);

        setContentView(
                R.layout.activity_main
        );

        rvImages =
                findViewById(
                        R.id.rvImages
                );

        GridLayoutManager layoutManager =
                new GridLayoutManager(
                        this,
                        2
                );

        rvImages.setLayoutManager(
                layoutManager
        );

        ImageAdapter adapter =
                new ImageAdapter(
                        this,
                        imageList
                );

        rvImages.setAdapter(
                adapter
        );
    }
}