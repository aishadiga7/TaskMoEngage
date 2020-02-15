package com.example.task.views.news;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.task.R;
import com.example.task.common.Constants;
import com.example.task.databinding.FragmentNewsListingBinding;
import com.example.task.di.Injector;
import com.example.task.listeners.NewsItemClickListener;
import com.example.task.viewmodel.NewsHomeModel;
import com.example.task.views.adapter.NewsListAdapter;
import com.example.task.views.uimodel.NewsUIModel;

import java.util.List;


public class NewsListingFragment extends Fragment implements NewsItemClickListener {
    private FragmentNewsListingBinding binding;
    private NewsHomeModel newsHomeModel;


    public NewsListingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding =  DataBindingUtil.inflate(inflater, R.layout.fragment_news_listing, container, false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        newsHomeModel = ViewModelProviders.of(getActivity(), Injector.getAppViewModelFacotry()).get(NewsHomeModel.class);
        newsHomeModel.getNewsLiveData().observe(this, new Observer<List<NewsUIModel>>() {
            @Override
            public void onChanged(List<NewsUIModel> newsUIModels) {
                if (newsUIModels!=null && !newsUIModels.isEmpty()) {
                    binding.progressBar.setVisibility(View.GONE);
                    binding.rvNews.setVisibility(View.VISIBLE);
                    binding.tvNoData.setVisibility(View.GONE);
                    initNewsRecyclerView(newsUIModels);
                } else {
                    binding.progressBar.setVisibility(View.GONE);
                    binding.rvNews.setVisibility(View.GONE);
                    binding.tvNoData.setVisibility(View.VISIBLE);
                }
            }
        });
    }


    private void initNewsRecyclerView(List<NewsUIModel> newsUIModels) {
        if (binding.rvNews != null) {
            binding.rvNews.setLayoutManager(new LinearLayoutManager(this.getContext()));
            NewsListAdapter adapter = new NewsListAdapter(this);
            adapter.setList(newsUIModels);
            binding.rvNews.setAdapter(adapter);
            binding.rvNews.setItemAnimator(new DefaultItemAnimator());
        }
    }

    @Override
    public void onNewsItemClicked(String browseUrl) {
        if (browseUrl != null) {
            Intent intent = new Intent(getActivity(), WebviewActivity.class);
            intent.putExtra(Constants.BUNDLE_KEY, browseUrl);
            startActivity(intent);
        }
    }
}
