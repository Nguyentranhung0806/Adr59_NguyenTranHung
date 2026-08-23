package vn.devpro.b10_retrofit.api;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

import vn.devpro.b10_retrofit.model.Post;

public interface ApiService {

    @GET("posts")
    Call<List<Post>> getPosts();
}