package org.wangchenlong.mainapp;

import android.databinding.BindingAdapter;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

/**
 * DataBinding的扩展, 支持动态加载图片资源
 */
public final class DataBinder {
    private DataBinder() {
        //NO-OP
    }

    @BindingAdapter("imageResource")
    public static void setImageResource(ImageView imageView, @DrawableRes int res) {
        imageView.setImageResource(res);
    }
}