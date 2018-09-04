package com.simple.common.utils;

import android.text.TextUtils;

public class StorageUtils {

    /***
     * 获取文件类型
     *
     * @param paramString
     * @return
     */
    private static String getFileType(String paramString) {
        String str = "";

        if (TextUtils.isEmpty(paramString)) {
            return str;
        }
        int i = paramString.lastIndexOf('.');
        if (i <= -1) {
            return str;
        }

        str = paramString.substring(i + 1);
        return str;
    }

    /***
     * 根据链接获取文件名（带类型的），具有唯一性
     *
     * @param url
     * @return
     */
    public static String getFileName(String url) {
        String fileName = Md5Tool.hashKey(url) + "." + getFileType(url);
        return fileName;
    }

    public static String getFileNameForUrl(String url) {
        if (TextUtils.isEmpty(url)) return null;

        return url.substring(url.lastIndexOf("/") + 1);
    }
}
