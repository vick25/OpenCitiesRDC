package net.osfac.opencitiesrdc.db;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import net.osfac.opencitiesrdc.R;

import org.spatialite.database.SQLiteDatabase;

import java.io.IOException;


public class SpatiAtlasProvider extends ContentProvider {

    private static final UriMatcher sUriMatcher = buildUriMatcher();

    private static final String DB_FILENAME = "opencities.sqlite";
    private static final int SYSTEM_INFO = 1;
    private static final int SPATIAL_REF_SYS = 20;
    private static final int VECTOR_LAYERS = 21;
    private static final int VECTOR_LAYERS_STATS = 22;
    private static final int SPATIAL_INDEX = 400;
    private static final int VECTOR_LAYER = 500;

    private SpatialiteFileDbHelper mDbHelper;

    @Override
    public boolean onCreate() {
        // get access to the database helper
        final Context context = getContext();

        Uri dbUri = Uri.parse("android.resource://" + context.getPackageName() + "/" + R.raw.opencities);
        mDbHelper = new SpatialiteFileDbHelper(context, dbUri, DB_FILENAME);

        try {
            mDbHelper.createDataBase(false);
            //dbHelper.getWritableDatabase();
        } catch (IOException ioEx) {
            throw new Error("Unable to open database", ioEx);
        } catch (SQLException sqlEx) {
            throw sqlEx;
        }

        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s,
                        @Nullable String[] strings1, @Nullable String s1) {
        return null;
    }

    private static UriMatcher buildUriMatcher() {
        final UriMatcher matcher = new UriMatcher(UriMatcher.NO_MATCH);
//        final String authority = SpatiAtlasContract.CONTENT_AUTHORITY;
//
//        matcher.addURI(authority, "sysinfo", SYSTEM_INFO);
//
//        matcher.addURI(authority, "srs", SPATIAL_REF_SYS);
//        matcher.addURI(authority, "vectorlayers", VECTOR_LAYERS);
//
//        matcher.addURI(authority, "spatialindex", SPATIAL_INDEX);
//
//        matcher.addURI(authority, "geomtable/*", VECTOR_LAYER);

        return matcher;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        switch (sUriMatcher.match(uri)) {
            case VECTOR_LAYER:
//                return SpatiAtlasContract.GeometryTable.CONTENT_TYPE;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        ContentResolver cr = getContext().getContentResolver();
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        switch (sUriMatcher.match(uri)) {
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        int deleteCount = 0;

        return deleteCount;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        int updateCount = 0;

        return updateCount;
    }
}
