package com.example.ankit.flicker_photo.ui.search;

import com.example.ankit.flicker_photo.model.PhotoItem;

/**
 * Created by ankit on 11/04/18.
 */

public  interface SearchPresenter {
    void onSubmitSearch(String query);
    void onResume();
    void onPause();

    interface PhotoSearchPresenter extends SearchPresenter{
        void displayLastPhotoSearch();
        void getPhotosByTag(String tag , String groupId);
        void loadMorePhoto(String query , int page);
        void downloadPhoto(PhotoItem photoItem  , MVPViewer.PhotoAdapterView adapterView);
        void onPhotoItemClicked(String flickrFilePath);
    }
    interface GroupSearchPresenter extends SearchPresenter{
        void getGroupByTag(String tag);
        void loadMoreGroups(String tag , int page);

        void onGroupItemClick(String nsid,String groupName);
    }

}
