package com.example.ankit.flicker_photo.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.ankit.flicker_photo.model.GroupItem;
import com.example.ankit.flicker_photo.model.PhotoItem;



@Database(entities = {GroupItem.class , PhotoItem.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract MyDao myDao();
}
