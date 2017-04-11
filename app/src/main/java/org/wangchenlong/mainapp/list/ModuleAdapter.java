package org.wangchenlong.mainapp.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.wangchenlong.mainapp.databinding.ItemModuleBinding;

import java.util.List;

/**
 * 模块适配器
 * <p>
 * Created by wangchenlong on 17/4/10.
 */
public class ModuleAdapter extends RecyclerView.Adapter<ModuleViewHolder> {
    private List<Module> mModules;
    private List<View.OnClickListener> mListeners;

    public ModuleAdapter(final @NonNull List<Module> modules,
                         final @NonNull List<View.OnClickListener> listeners) {
        mModules = modules;
        mListeners = listeners;
    }

    @Override
    public ModuleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final ItemModuleBinding productBinding = ItemModuleBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new ModuleViewHolder(productBinding);
    }

    @Override
    public void onBindViewHolder(ModuleViewHolder holder, int position) {
        holder.bind(mModules.get(position), mListeners.get(position));
    }

    @Override
    public int getItemCount() {
        return mModules.size();
    }
}
