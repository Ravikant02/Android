package com.example.inviter.invtandroid.core;

import android.util.Log;

/**
 * Created by Ravikant on 06/12/16.
 */
public class Loggers {

    private static String TAG = "INVITER";

    public static boolean ENABLE_LOGGERS = true;
    public static boolean ENABLE_VERBOSE = false;
    public static boolean ENABLE_DEBUG = false;
    public static boolean ENABLE_INFO = false;
    public static boolean ENABLE_ERRORS = true;

    public static void verbose(String msg)
    {
        if(ENABLE_LOGGERS && ENABLE_VERBOSE) {
            Log.v(TAG, msg);
        }
    }

    public static void debug(String msg)
    {
        if(ENABLE_LOGGERS && ENABLE_DEBUG) {
            Log.d(TAG, msg);
        }
    }

    public static void info(String msg)
    {
        if(ENABLE_LOGGERS && ENABLE_INFO) {
            Log.i(TAG, msg);
        }
    }

    public static void error(String msg)
    {
        if(ENABLE_LOGGERS && ENABLE_ERRORS) {
            Log.e(TAG, msg);
        }
    }
}
