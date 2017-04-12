package org.wangchenlong.styles;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.DrawableRes;
import android.widget.Toast;

import java.util.Collection;

/**
 * 全部工具方法
 * <p>
 * Created by wangchenlong on 17/4/10.
 */
@SuppressWarnings("unused")
public class Utils {
    /**
     * 判读容器是否为空
     *
     * @param collection 容器
     * @return 是否空容器
     */
    public static boolean isListEmpty(Collection collection) {
        return !(collection != null && !collection.isEmpty());
    }

    /**
     * 显示Toast
     *
     * @param msg 信息
     */
    public static void showToast(Context context, String msg) {
        Context appContext = context.getApplicationContext();
        Toast.makeText(appContext, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 获取屏幕宽度
     *
     * @return 屏幕宽度
     */
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕高度
     *
     * @return 屏幕高度
     */
    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    /**
     * 获取Bitmap的宽和高
     *
     * @param context 上下文
     * @param res     资源
     * @return 二维数组[宽, 高]
     */
    public static int[] getBitmapSize(Context context, @DrawableRes int res) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true; // 避免占用内存
        BitmapFactory.decodeResource(context.getResources(), res, options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        return new int[]{imageWidth, imageHeight};
    }

    /**
     * 根据资源和宽度, 获取图片
     *
     * @param context 上下文
     * @param res     资源
     * @param width   宽度
     * @return 图片
     */
    public static Bitmap getResizedWidthBitmap(Context context, @DrawableRes int res, int width) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), res, options);
        BitmapFactory.decodeResource(context.getResources(), res, options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        int dstHeight = width * (imageHeight / imageWidth);
        return Bitmap.createScaledBitmap(bitmap, width, dstHeight, false);
    }

    /**
     * 根据资源和高度, 获取图片
     *
     * @param context 上下文
     * @param res     资源
     * @param height  高度
     * @return 图片
     */
    public static Bitmap getResizedHeightBitmap(Context context, @DrawableRes int res, int height) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeResource(context.getResources(), res, options);
        BitmapFactory.decodeResource(context.getResources(), res, options);
        float imageHeight = options.outHeight;
        float imageWidth = options.outWidth;
        int dstWidth = (int) (height * (imageWidth / imageHeight));
        return Bitmap.createScaledBitmap(bitmap, dstWidth, height, false);
    }
}
