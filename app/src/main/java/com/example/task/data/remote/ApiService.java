package com.example.task.data.remote;


import com.example.task.data.remote.model.NewsBaseResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("staticResponse.json")
    Call<NewsBaseResponse> getNewsData();
}
