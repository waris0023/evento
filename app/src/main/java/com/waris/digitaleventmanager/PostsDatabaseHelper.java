package com.waris.digitaleventmanager;

import android.annotation.TargetApi;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.os.Build;
import android.util.Log;

/**
 * Created by lalli on 10/21/2015.
 */


public class PostsDatabaseHelper extends SQLiteOpenHelper {
    // Database Info

    private static  PostsDatabaseHelper sInstance;
    private static final String DATABASE_NAME = "eventdatabase";
    private static final int DATABASE_VERSION = 1;

    // Table Names
    private static final String TABLE_EVENTS = "events";
    private static final String TABLE_CATEGORY = "category";

    // Post Table Columns
    private static final String KEY_EVENTS_ID = "id";
    private static final String KEY_EVENTS_EVENT_NAME = "eventname";
    private static final String KEY_EVENTS_EVENT_IMAGE_PATH = "path";

    // User Table Columns
    private static final String KEY_CATEGORY_ID = "id";
    private static final String KEY_CATEGORY_CATEGORY_NAME = "categoryname";
    private static final String KEY_CATEGORY_CATEGORY_IMAGE_PATH = "path";

    private PostsDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Called when the database connection is being configured.
    // Configure database settings for things like foreign key support, write-ahead logging, etc.
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    // Called when the database is created for the FIRST time.
    // If a database already exists on disk with the same DATABASE_NAME, this method will NOT be called.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_EVENTS_TABLE = "CREATE TABLE " + TABLE_EVENTS +
                "(" +
                KEY_EVENTS_ID + " INTEGER PRIMARY KEY," + // Define a primary key
                KEY_EVENTS_EVENT_NAME + " TEXT " + TABLE_CATEGORY + "," + // Define a foreign key
                KEY_EVENTS_EVENT_IMAGE_PATH + " TEXT" +
                ")";

        String CREATE_CATEGORY_TABLE = "CREATE TABLE " + TABLE_CATEGORY +
                "(" +
                KEY_CATEGORY_ID + " INTEGER PRIMARY KEY," +
                KEY_CATEGORY_CATEGORY_NAME+ " TEXT," +
                KEY_CATEGORY_CATEGORY_IMAGE_PATH + " TEXT" +
                ")";

        db.execSQL(CREATE_EVENTS_TABLE);
        db.execSQL(CREATE_CATEGORY_TABLE);
    }

    // Called when the database needs to be upgraded.
    // This method will only be called if a database already exists on disk with the same DATABASE_NAME,
    // but the DATABASE_VERSION is different than the version of the database that exists on disk.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            // Simplest implementation is to drop all old tables and recreate them
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_EVENTS);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATEGORY);
            onCreate(db);
        }
    }

    public static synchronized PostsDatabaseHelper getsInstance(Context context)
    {
        if(sInstance==null)
        {
            sInstance=new PostsDatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    public void addEvent(Event event) {
        // Create and/or open the database for writing
        SQLiteDatabase db = getWritableDatabase();

        // It's a good idea to wrap our insert in a transaction. This helps with performance and ensures
        // consistency of the database.
        db.beginTransaction();
        try {
            // The user might already exist in the database (i.e. the same user created multiple posts).
           /// String userId = addorUpdateUser(event.event_name);

            ContentValues values = new ContentValues();
           // values.put(KEY_EVENTS_EVENT_NAME, userId);
            values.put(KEY_EVENTS_EVENT_IMAGE_PATH, event.evet_image_path);

            // Notice how we haven't specified the primary key. SQLite auto increments the primary key column.
            db.insertOrThrow(TABLE_EVENTS, null, values);
            db.setTransactionSuccessful();
        } catch (Exception e) {
          //  Log.d(TAG, "Error while trying to add post to database");
        } finally {
            db.endTransaction();
        }
    }

    // Insert or update a user in the database
    // Since SQLite doesn't support "upsert" we need to fall back on an attempt to UPDATE (in case the
    // user already exists) optionally followed by an INSERT (in case the user does not already exist).
    // Unfortunately, there is a bug with the insertOnConflict method
    // (https://code.google.com/p/android/issues/detail?id=13045) so we need to fall back to the more
    // verbose option of querying for the user's primary key if we did an update.
    public long addorUpdateUser(Category category) {
        // The database connection is cached so it's not expensive to call getWriteableDatabase() multiple times.
        SQLiteDatabase db = getWritableDatabase();
        long userId = -1;

        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put(KEY_CATEGORY_CATEGORY_NAME, category.category_name);
            values.put(KEY_CATEGORY_CATEGORY_IMAGE_PATH, category.category_image_path);

            // First try to update the user in case the user already exists in the database
            // This assumes userNames are unique
            int rows = db.update(TABLE_CATEGORY, values, KEY_CATEGORY_CATEGORY_NAME + "= ?", new String[]{category.category_name});

            // Check if update succeeded
            if (rows == 1) {
                // Get the primary key of the user we just updated
                String usersSelectQuery = String.format("SELECT %s FROM %s WHERE %s = ?",
                        KEY_CATEGORY_ID, TABLE_CATEGORY, KEY_CATEGORY_CATEGORY_NAME);
                Cursor cursor = db.rawQuery(usersSelectQuery, new String[]{String.valueOf(category.category_name)});
                try {
                    if (cursor.moveToFirst()) {
                        userId = cursor.getInt(0);
                        db.setTransactionSuccessful();
                    }
                } finally {
                    if (cursor != null && !cursor.isClosed()) {
                        cursor.close();
                    }
                }
            } else {
                // user with this userName did not already exist, so insert new user
                userId = db.insertOrThrow(TABLE_CATEGORY, null, values);
                db.setTransactionSuccessful();
            }
        } catch (Exception e) {
           // Log.d(Tag, "Error while trying to add or update user");
        } finally {
            db.endTransaction();
        }
        return userId;
    }

    public class Event {
        public String event_name;
        public String evet_image_path;
    }
    public class Category
    {
        public String category_name;
        public String category_image_path;
    }

}