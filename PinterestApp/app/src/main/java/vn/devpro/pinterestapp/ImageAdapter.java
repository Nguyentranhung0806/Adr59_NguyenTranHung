package vn.devpro.pinterestapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ImageAdapter
        extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private Context context;

    private int[] imageList;

    public ImageAdapter(
            Context context,
            int[] imageList
    ) {
        this.context = context;

        this.imageList = imageList;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(
            @NonNull ViewGroup parent,
            int viewType
    ) {

        View view =
                LayoutInflater.from(context)
                        .inflate(
                                R.layout.item_image,
                                parent,
                                false
                        );

        return new ImageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(
            @NonNull ImageViewHolder holder,
            int position
    ) {

        int imageId = imageList[position];

        holder.imgPinterest
                .setImageResource(imageId);

        holder.itemView
                .setOnClickListener(v -> {

                    Intent intent =
                            new Intent(
                                    context,
                                    DetailActivity.class
                            );

                    intent.putExtra(
                            "IMAGE_ID",
                            imageId
                    );

                    context.startActivity(intent);
                });
    }

    @Override
    public int getItemCount() {

        return imageList.length;
    }

    public static class ImageViewHolder
            extends RecyclerView.ViewHolder {

        ImageView imgPinterest;

        public ImageViewHolder(
                @NonNull View itemView
        ) {

            super(itemView);

            imgPinterest =
                    itemView.findViewById(
                            R.id.imgPinterest
                    );
        }
    }
}