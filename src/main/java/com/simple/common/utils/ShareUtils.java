package com.simple.common.utils;

import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;

import java.io.File;

public class ShareUtils {

    public static void shareFile(Context context, String path) {
        if (context == null || TextUtils.isEmpty(path)) return;
        shareFile(context, new File(path), null);
    }

    public static void shareFile(Context context, String path, String description) {
        if (context == null || TextUtils.isEmpty(path)) return;
        shareFile(context, new File(path), description);
    }

    public static void shareFile(Context context, File file, String description) {
        if (context == null || file == null || !file.exists()) return;
        Intent share = new Intent(Intent.ACTION_SEND);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Uri contentUri = FileProvider.getUriForFile(context, context.getPackageName() + ".fileProvider", file);
            share.putExtra(Intent.EXTRA_STREAM, contentUri);
        } else {
            share.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
        }
        share.setType(getMimeType(file.getAbsolutePath()));//此处可发送多种文件
        share.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        share.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        context.startActivity(Intent.createChooser(share, TextUtils.isEmpty(description) ? "分享文件" : description));
    }

    // 根据文件后缀名获得对应的MIME类型。
    private static String getMimeType(String filePath) {
        MediaMetadataRetriever mmr = new MediaMetadataRetriever();
        String mime = "*/*";
        if (filePath != null) {
            try {
                mmr.setDataSource(filePath);
                mime = mmr.extractMetadata(MediaMetadataRetriever.METADATA_KEY_MIMETYPE);
            } catch (IllegalStateException e) {
                return mime;
            } catch (IllegalArgumentException e) {
                return mime;
            } catch (RuntimeException e) {
                return mime;
            }
        }
        return mime;
    }
}
