package com.example.task.data.remote.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NewsBaseResponse implements Serializable {
    @SerializedName("status")
    private String status;
    @SerializedName("articles")
    private List<NewsArticle> newsArticles;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<NewsArticle> getNewsArticles() {
        return newsArticles;
    }

    public void setNewsArticles(List<NewsArticle> newsArticles) {
        this.newsArticles = newsArticles;
    }


}
