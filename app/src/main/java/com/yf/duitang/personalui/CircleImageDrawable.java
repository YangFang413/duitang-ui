package com.yf.duitang.personalui;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/**
 * Created by Administrator on 2016/9/15.
 */
public class CircleImageDrawable extends Drawable {

    private Bitmap mBitmap;
    private int mWidth;
    private Paint mPaint;

    public CircleImageDrawable(Bitmap bitmap){
        mBitmap = bitmap;
        // BitmapShader带有位图的渲染器
        BitmapShader bitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setShader(bitmapShader);

        mWidth = Math.min(mBitmap.getWidth(), mBitmap.getHeight());
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawCircle(mWidth/2, mWidth/2, mWidth/2, mPaint);
    }

    @Override
    public int getIntrinsicHeight() {
        return mWidth;
    }

    @Override
    public int getIntrinsicWidth() {
        return mWidth;
    }

    // 设置透明度
    @Override
    public void setAlpha(int i) {
            mPaint.setAlpha(i);
    }

    // 设置颜色的滤镜
    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        mPaint.setColorFilter(colorFilter);
    }

    @Override
    public int getOpacity() {
        // PixelFormat指定图像中每个像素的颜色数据的格式
        return PixelFormat.TRANSLUCENT;
    }
}
