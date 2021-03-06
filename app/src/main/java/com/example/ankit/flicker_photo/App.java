package com.example.ankit.flicker_photo;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.ankit.flicker_photo.db.AppDatabase;
import com.example.ankit.flicker_photo.helper.FileHelper;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;


/**
 * Created by ankit on 11/04/18.
 */

public class App  extends Application{
    private static App mAppController ;

    private RequestQueue mRequestQueue;
    private Gson mGson;
    private Picasso picasso;
    private Context context;
    private static AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        mAppController =this;
         picasso = new Picasso.Builder(this)
                   .loggingEnabled(true)
                 .indicatorsEnabled(true)
                     .build();
        FileHelper.cachesFiles = FileHelper.getCacheFiles();
        Log.d("App", "FileHelper.cachesFiles:" + FileHelper.cachesFiles);
        Picasso.setSingletonInstance(picasso);
        this.context = this;
        db = Room.databaseBuilder(this, AppDatabase.class, "cache-database")
                        // allow queries on the main thread.
                        // Don't do this on a real app! See PersistenceBasicSample for an example.
                        .build();


    }


    public static synchronized App getInstance() {
        return mAppController;
    }

    public Context getContext() {
        if (context == null)
            context = this;
        return context;
    }

    public Gson getGson() {
        if (mGson == null) {
            mGson = new Gson();
        }
        return this.mGson;
    }



    public <T> void addToRequestQueue(Request<T> req , String  tag) {
        req.setTag(tag);
        req.setShouldCache(false);
        getRequestQueue().add(req);

    }

    public void cancelPendingRequests(String tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }
    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        return mRequestQueue;
    }
    public static synchronized AppDatabase getAppDatabase() {
        return db;
    }

    public static void destroyInstance() {
        db = null;
    }

}
