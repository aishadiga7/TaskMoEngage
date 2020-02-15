package com.example.task.views.navigation;

import android.app.Activity;
import android.content.Intent;

import com.example.task.views.news.NewsActivity;

public class Router implements Navigator {

    Activity activity;

    public Router(Activity activity) {
        this.activity = activity;
    }


    @Override
    public void launchHome() {
        activity.startActivity(new Intent(activity, NewsActivity.class));
    }
}
