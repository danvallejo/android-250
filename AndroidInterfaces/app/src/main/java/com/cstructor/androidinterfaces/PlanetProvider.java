package com.cstructor.androidinterfaces;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v4.widget.SimpleCursorAdapter;

public class PlanetProvider extends ContentProvider {
    public static final String AUTHORITY = "com.cstructor.androidinterfaces.provider.Planet";
    private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    private static final int PLANETS = 1;
    private static final int PLANETS_ID = 2;

    private static String[] planets = {"Earth", "Mars", "Jupiter", "Venus"};

    static {
        sUriMatcher.addURI(AUTHORITY, "planet", PLANETS);
        sUriMatcher.addURI(AUTHORITY, "planet/#", PLANETS_ID);
    }

    @Override
    public boolean onCreate() {
        return true;
    }

    @Nullable
    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        int match = sUriMatcher.match(uri);

        if (match == PLANETS) {
            MatrixCursor matrixCursor = new MatrixCursor(new String[]{"PlanetName"});

            for (String planetName : planets) {
                matrixCursor.addRow(new String[]{planetName});
            }

            return matrixCursor;
        } else {
            // a single planet #
            int planetNumber = 3;

            MatrixCursor matrixCursor = new MatrixCursor(new String[]{"PlanetName"});

            matrixCursor.addRow(new String[]{planets[planetNumber - 1]});

            return matrixCursor;
        }
    }

    @Nullable
    @Override
    public String getType(Uri uri) {
        int match = sUriMatcher.match(uri);
        switch (match) {
            case PLANETS:
                return "vnd.android.cursor.dir/planet";
            case PLANETS_ID:
                return "vnd.android.cursor.item/planet";
            default:
                return null;
        }
    }

    @Nullable
    @Override
    public Uri insert(Uri uri, ContentValues values) {
        Uri.Builder uriBuilder = new Uri.Builder();

        int newPlanetNumber = 1020202;

        uriBuilder.scheme("http");
        uriBuilder.authority(AUTHORITY);
        uriBuilder.appendPath("planet");
        uriBuilder.appendPath(Integer.toString(newPlanetNumber));

        // Return a uri to the item we just added.
        return uriBuilder.build();
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return -3;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection, String[] selectionArgs) {
        return -6;
    }
}

