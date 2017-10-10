package com.example.zhanggang.myzidingyi;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PixelFormat;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by zhanggang on 2017/10/10.
 */

public class MyView extends Drawable {

    private Paint paint;
    private Bitmap bitmap;
    private int radio;

    public MyView(Bitmap bitmap) {
        this.bitmap = bitmap;
        paint=new Paint(Paint.ANTI_ALIAS_FLAG);
        //着色器
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(bitmapShader);
        //拿到宽和高
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        //取最小值  取最大值的话 图片可能铺不满
        int min = Math.min(width, height);
        radio=min/2; //获得半径
    }

    @Override
    public void draw(@NonNull Canvas canvas) {
        canvas.drawCircle(radio,radio,radio,paint);
    }
    //透明度
    @Override
    public void setAlpha(@IntRange(from = 0, to = 255) int i) {
        paint.setAlpha(i);
    }
    //染缸
    @Override
    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }
    //保持透明度
    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }
    //实际宽
    @Override
    public int getIntrinsicWidth() {
        return radio*2;
    }
    //实际高
    @Override
    public int getIntrinsicHeight() {
        return radio*2;
    }
}
