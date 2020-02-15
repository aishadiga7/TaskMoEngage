package com.example.task.common;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.task.di.Injector;
import com.example.task.viewmodel.NewsHomeModel;

public class AppViewModelFacotry implements ViewModelProvider.Factory {


    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
       if (modelClass == NewsHomeModel.class) {
           return (T) new NewsHomeModel(Injector.getRepository());
       }
       return null;
    }
}
