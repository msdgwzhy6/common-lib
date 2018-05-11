package com.simple.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.simple.common.utils.transforms.GlideCircleTransform;
import com.simple.common.utils.transforms.GlideRoundTransform;


/**
 * Created by simpepeng on 2017/8/1.
 */

public class ImageUtils {

    @SuppressWarnings("unchecked")
    public static void load(Context context, String url, ImageView imageView, int placeId,
                            int errorId, Transformation<Bitmap>... transformations) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .placeholder(placeId)
                .error(errorId)
                .dontAnimate()
                .bitmapTransform(transformations)
                .into(imageView);
    }

//    @SuppressWarnings("unchecked")
//    public static void load(Context context, String url, ImageView imageView, Transformation<Bitmap>... transformations) {
//        load(context, url, imageView, R.drawable.place_rect, R.drawable.place_rect, transformations);
//    }

//    public static void loadRect(Context context, String url, ImageView imageView) {
//        load(context, url, imageView, new CenterCrop(context));
//    }

//    public static void loadSquare(Context context, String url, ImageView imageView) {
//        load(context, url, imageView, R.drawable.place_max, R.drawable.place_max, new CenterCrop(context));
//    }

    public static void loadCricle(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transform(new GlideCircleTransform(context), new CenterCrop(context))
                .into(imageView);
    }

    public static void loadRoundRect(Context context, String url, ImageView imageView, int dp) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .transform(new GlideRoundTransform(context, dp), new CenterCrop(context))
                .into(imageView);
    }

//    public static void loadAvatar(Context context, String url, ImageView imageView) {
//        load(context, url, imageView, R.drawable.place_avatar, R.drawable.place_avatar,
//                new CenterCrop(context), new GlideRoundTransform(context));
//    }
//
//    public static void loadBorderAvatar(Context context, String url, ImageView imageView) {
//        load(context, url, imageView, R.drawable.place_avatar, R.drawable.place_avatar,
//                new CenterCrop(context), new GlideRoundTransform(context, 3, 2, Color.WHITE));
//    }
}
