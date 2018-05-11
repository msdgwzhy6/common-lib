package com.simple.common.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtils {

    public static void show(Context context, CharSequence msg) {
        if (context == null) return;
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
