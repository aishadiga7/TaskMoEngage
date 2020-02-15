package com.example.task.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.task.data.Callback;
import com.example.task.data.Repository;
import com.example.task.views.uimodel.NewsUIModel;

import java.util.List;

public class NewsHomeModel extends ViewModel {

    private Repository repository;
    private MutableLiveData<List<NewsUIModel>> newsData = new MutableLiveData<>();

    public NewsHomeModel(Repository repository) {
        this.repository = repository;
    }

    public LiveData<List<NewsUIModel>> getNewsLiveData() {
        return newsData;
    }


    public void getNewsData() {
        repository.getNewsData(new Callback<List<NewsUIModel>>() {
            @Override
            public void onSuccess(List<NewsUIModel> result) {
                if (result!= null) {
                    newsData.setValue(result);
                }
            }

            @Override
            public void onError(Throwable error) {
                newsData.setValue(null);
            }
        });
    }


}
