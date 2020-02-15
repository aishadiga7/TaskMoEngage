package com.example.task.data;


import com.example.task.views.uimodel.NewsUIModel;

import java.util.ArrayList;
import java.util.List;

/*
This interface contains methods to interact with the inner layer
 */
public interface Repository {

    void getNewsData(Callback<List<NewsUIModel>> callback);
}
