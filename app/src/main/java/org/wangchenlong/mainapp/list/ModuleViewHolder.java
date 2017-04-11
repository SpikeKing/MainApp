package org.wangchenlong.mainapp.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.wangchenlong.mainapp.databinding.ItemModuleBinding;

/**
 * RecyclerView的ViewHolder, 绑定模块和数据
 * <p>
 * Created by wangchenlong on 17/4/1.
 */
class ModuleViewHolder extends RecyclerView.ViewHolder {
    private final ItemModuleBinding mBinding;

    ModuleViewHolder(final @NonNull ItemModuleBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    void bind(final @NonNull Module module, final View.OnClickListener listener) {
        mBinding.setModule(module);
        mBinding.getRoot().setOnClickListener(listener); // 设置点击事件
    }
}
