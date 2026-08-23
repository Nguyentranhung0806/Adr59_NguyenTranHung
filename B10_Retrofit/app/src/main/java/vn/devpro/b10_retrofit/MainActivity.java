package vn.devpro.b10_retrofit;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import vn.devpro.b10_retrofit.adapter.PostAdapter;
import vn.devpro.b10_retrofit.api.RetrofitClient;
import vn.devpro.b10_retrofit.model.Post;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(
                new LinearLayoutManager(this)
        );

        loadPosts();
    }

    private void loadPosts() {

        RetrofitClient.getApiService()
                .getPosts()
                .enqueue(new Callback<List<Post>>() {

                    @Override
                    public void onResponse(
                            Call<List<Post>> call,
                            Response<List<Post>> response) {

                        if (response.isSuccessful()
                                && response.body() != null) {

                            List<Post> posts = response.body();

                            Toast.makeText(
                                    MainActivity.this,
                                    "Đã lấy được " + posts.size() + " bài",
                                    Toast.LENGTH_SHORT
                            ).show();

                            PostAdapter adapter =
                                    new PostAdapter(posts);

                            recyclerView.setAdapter(adapter);

                        } else {

                            Toast.makeText(
                                    MainActivity.this,
                                    "API lỗi: " + response.code(),
                                    Toast.LENGTH_LONG
                            ).show();
                        }
                    }

                    @Override
                    public void onFailure(
                            Call<List<Post>> call,
                            Throwable t) {

                        Toast.makeText(
                                MainActivity.this,
                                "Lỗi: " + t.getMessage(),
                                Toast.LENGTH_LONG
                        ).show();
                    }
                });
    }
}