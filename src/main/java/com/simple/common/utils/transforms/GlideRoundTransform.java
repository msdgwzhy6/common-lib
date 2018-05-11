package com.simple.common.utils.transforms;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.simple.common.utils.DensityUtils;


/**
 * 圆角
 */
public class GlideRoundTransform extends BitmapTransformation {

    private float radius = 0f;

    //    private int mBorderWidth;
//    private int mBorderColor;
    private Paint mBorderPaint;

    public GlideRoundTransform(Context context) {
        this(context, 3);
    }

    public GlideRoundTransform(Context context, int dp) {
        super(context);
        this.radius = DensityUtils.dp2px(context, dp);
    }

    public GlideRoundTransform(Context context, int dp, float borderWidth, int borderColor) {
        super(context);
        mBorderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBorderPaint.setDither(true);
        this.radius = DensityUtils.dp2px(context, dp);
//        this.mBorderWidth = borderWidth;
//        this.mBorderColor = borderColor;
        mBorderPaint.setColor(borderColor);
        mBorderPaint.setStyle(Paint.Style.STROKE);
        mBorderPaint.setStrokeWidth(Resources.getSystem().getDisplayMetrics().density * borderWidth);
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap toTransform, int outWidth, int outHeight) {
        return roundCrop(pool, toTransform);
    }

    private Bitmap roundCrop(BitmapPool pool, Bitmap source) {
        if (source == null) return null;

        Bitmap result = pool.get(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        if (result == null) {
            result = Bitmap.createBitmap(source.getWidth(), source.getHeight(), Bitmap.Config.ARGB_8888);
        }

        Canvas canvas = new Canvas(result);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(source, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        RectF rectF = new RectF(0f, 0f, source.getWidth(), source.getHeight());
        canvas.drawRoundRect(rectF, radius, radius, paint);
        if (mBorderPaint != null) {
            canvas.drawRoundRect(rectF, radius, radius, mBorderPaint);
        }
        return result;
    }

    @Override
    public String getId() {
        return getClass().getName() + Math.round(radius);
    }
}