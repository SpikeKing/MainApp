package org.wangchenlong.styles;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.support.annotation.DrawableRes;
import android.util.DisplayMetrics;
import android.widget.Toast;

import java.util.Collection;

/**
 * 全部工具方法
 * <p>
 * Created by wangchenlong on 17/4/10.
 */
public class Utils {
    /**
     * 判读容器是否为空
     *
     * @param collection 容器
     * @return 是否空容器
     */
    public static boolean isListEmpty(Collection collection) {
        if (collection != null && !collection.isEmpty()) {
            return false;
        }
        return true;
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

    public static int[] getBitmapSize(Context context, @DrawableRes int res) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), res, options);
        int imageHeight = options.outHeight;
        int imageWidth = options.outWidth;
        return new int[]{imageWidth, imageHeight};
    }
}
