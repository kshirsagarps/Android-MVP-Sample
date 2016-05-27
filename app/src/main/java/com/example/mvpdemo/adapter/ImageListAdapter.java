package com.example.mvpdemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.mvpdemo.R;
import com.example.mvpdemo.model.Result;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ImageListAdapter extends RecyclerView.Adapter<ImageListAdapter.ImageListViewHolder> {

    private ImageClickListener mImageClickListener;
    private List<Result> mImageList;

    public ImageListAdapter() {
        //mImageClickListener = imageClickListener;
    }

    @Override
    public ImageListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        //Inflate the list item.
        View itemView = inflater.inflate(R.layout.item_recyclerview, parent, false);
        ImageListViewHolder imageListViewHolder = new ImageListViewHolder(itemView);
        return imageListViewHolder;
    }

    @Override
    public void onBindViewHolder(ImageListViewHolder holder, int position) {
        int size = getItemCount();
        if (size > 0 && position < size ) {
            final ImageView imageView = holder.getImageView();
            final Result result = mImageList.get(position);
            Picasso.with(imageView.getContext()).load(result.getThumbnail()).into(imageView);
        }
    }


    @Override
    public int getItemCount() {
        return (mImageList == null) ? 0 : mImageList.size();
    }

    public void setData(List<Result> list) {
        mImageList = list;
        notifyDataSetChanged();
    }

    public void appendData(List<Result> list) {
        if (mImageList != null) {
            mImageList.addAll(list);
        }
    }

    static class ImageListViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;

        public ImageListViewHolder(View itemView) {
            super(itemView);
            mImageView = (ImageView)itemView.findViewById(R.id.thumbnail);
        }

        public ImageView getImageView() {
            return mImageView;
        }
    }

    public interface ImageClickListener {
        public void onImageClick(Result result);
    }
}
