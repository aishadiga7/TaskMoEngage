package com.example.task.views.news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.task.R;
import com.example.task.common.Constants;
import com.example.task.databinding.ActivityWebviewBinding;

public class WebviewActivity extends AppCompatActivity {
    private ActivityWebviewBinding binding;
    private String browseUrl;


    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_webview);
        extractIntentData();
        loadUrl();
    }

    private void loadUrl() {
        binding.webview.loadUrl(browseUrl);
    }

    private void extractIntentData() {
        if (getIntent() != null) {
            browseUrl = getIntent().getStringExtra(Constants.BUNDLE_KEY);
        }
    }
}
