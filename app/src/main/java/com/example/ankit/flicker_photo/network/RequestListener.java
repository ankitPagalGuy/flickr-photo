package com.example.ankit.flicker_photo.network;

import android.graphics.Bitmap;

import com.example.ankit.flicker_photo.model.GroupSearch;
import com.example.ankit.flicker_photo.model.PhotoSearch;

/**
 * Created by ankit on 11/04/18.
 */
/*
*
*
* */
public interface RequestListener {
     interface photoSearchListener {
        void onSearchResult(PhotoSearch photoSearch);
        void onError(String error);
    }
    interface groupSearchListener {
        void onSearchResult(GroupSearch photoSearch);
        void onError(String error);
    }
    interface  imageDownloadListener{
        void onBitmapLoaded(Bitmap bitmap);
        void onBitmapFailed();
    }
}
