package com.simple.common.utils;

import com.orhanobut.logger.Logger;

public class LogUtils {

    public static final String TAG = "SIMPLE";

    public static void d(String msg) {
        Logger.d(msg);
    }

    public static void e(String msg) {
        Logger.e(msg);
    }
}
