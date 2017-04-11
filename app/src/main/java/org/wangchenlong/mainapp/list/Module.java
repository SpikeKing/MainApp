package org.wangchenlong.mainapp.list;

import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;

/**
 * 模块集合
 * <p>
 * Created by wangchenlong on 17/4/1.
 */
public class Module {
    private final String mModuleName; // 模块名称
    private final @DrawableRes int mModuleBkg; // 模块背景

    public Module(final @NonNull String moduleName, final int moduleBkg) {
        mModuleName = moduleName;
        mModuleBkg = moduleBkg;
    }

    public String getModuleName() {
        return mModuleName;
    }

    public @DrawableRes int getModuleBkg() {
        return mModuleBkg;
    }
}
