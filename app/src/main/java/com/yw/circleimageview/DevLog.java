package com.yw.circleimageview;

import android.util.Log;

/**
 * create by yangwei
 * on 2020/7/1 15:50
 */
public class DevLog {
    private static final String TAG = "circle_image_view";

    public static void log(String log) {
        Log.e(TAG, log);
    }

    public static void log(int log) {
        Log.e(TAG, log + "");
    }
}
