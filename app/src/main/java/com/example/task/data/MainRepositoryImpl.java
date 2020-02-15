package com.example.task.data;

import com.example.task.data.remote.ApiService;
import com.example.task.data.remote.model.NewsArticle;
import com.example.task.data.remote.model.NewsBaseResponse;
import com.example.task.views.uimodel.NewsUIModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/*
This class will iomplement the repository interface and doers the actual logic of it
 */
public class MainRepositoryImpl implements Repository {
    private ApiService apiService;


    public MainRepositoryImpl(ApiService apiService) {
        this.apiService = apiService;
    }

    @Override
    public void getNewsData(com.example.task.data.Callback<List<NewsUIModel>> callback) {
        apiService.getNewsData().enqueue(new Callback<NewsBaseResponse>() {
            @Override
            public void onResponse(Call<NewsBaseResponse> call, Response<NewsBaseResponse> response) {
                if (response != null && response.isSuccessful()) {
                    List<NewsUIModel> newsList = getNewsList(response.body().getNewsArticles());
                    callback.onSuccess(newsList);
                }
            }

            @Override
            public void onFailure(Call<NewsBaseResponse> call, Throwable throwable) {
                callback.onError(throwable);
            }
        });
    }

    private List<NewsUIModel> getNewsList(List<NewsArticle> newsArticles) {
        List<NewsUIModel> newsList = new ArrayList<>();
        NewsUIModel newsUIModel;
        for (NewsArticle newsArticle: newsArticles) {
            newsUIModel = new NewsUIModel();
            newsUIModel.setAuthor(newsArticle.getAuthor());
            newsUIModel.setTitle(newsArticle.getTitle());
            newsUIModel.setImageUrl(newsArticle.getUrlToImage());
            newsUIModel.setBrowseUrl(newsArticle.getUrl());
            newsList.add(newsUIModel);
        }
        return newsList;
    }
}
