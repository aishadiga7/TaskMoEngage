package com.example.task.views.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.task.R;
import com.example.task.databinding.ItemViewBinding;
import com.example.task.listeners.NewsItemClickListener;
import com.example.task.views.uimodel.NewsUIModel;

import java.util.ArrayList;
import java.util.List;

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder> {
    private List<NewsUIModel> list = new ArrayList<>();
    private NewsItemClickListener newsItemClickListener;

    public NewsListAdapter(NewsItemClickListener newsItemClickListener) {
        this.newsItemClickListener = newsItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemViewBinding binding = DataBindingUtil.inflate(inflater, R.layout.item_view, parent, false);
        return new ViewHolder(binding);
    }

    public void setList(List<NewsUIModel> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
        holder.bind(list.get(position), newsItemClickListener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        private ItemViewBinding itemViewBinding;

        public ViewHolder(@NonNull ItemViewBinding itemView) {
            super(itemView.getRoot());
            itemViewBinding = itemView;
        }

        public void bind(NewsUIModel list) {
            Glide.with(itemViewBinding.getRoot()).load(list.getImageUrl()).into(itemViewBinding.ivThumbImage);
            itemViewBinding.tvAuthor.setText(list.getAuthor());
            itemViewBinding.tvTvTitle.setText(list.getTitle());
        }

        public void bind(final NewsUIModel news, final NewsItemClickListener newsItemClickListener) {
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (newsItemClickListener != null) {
                        newsItemClickListener.onNewsItemClicked(news.getBrowseUrl());
                    }
                }
            });
        }

    }

}
