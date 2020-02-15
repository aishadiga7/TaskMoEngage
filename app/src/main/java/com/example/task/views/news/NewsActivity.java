package com.example.task.views.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.example.task.R;
import com.example.task.databinding.ActivityNewsBinding;
import com.example.task.di.Injector;
import com.example.task.utils.FragmentUtils;
import com.example.task.viewmodel.NewsHomeModel;

public class NewsActivity extends AppCompatActivity {
    private ActivityNewsBinding binding;
    private NewsHomeModel newsHomeModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_news);
        FragmentUtils.replaceFragment(new NewsListingFragment(), getSupportFragmentManager());
        newsHomeModel = ViewModelProviders.of(this, Injector.getAppViewModelFacotry()).get(NewsHomeModel.class);
        newsHomeModel.getNewsData();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding.unbind();
    }
}
