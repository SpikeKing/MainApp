package org.wangchenlong.constraintlayout.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.wangchenlong.constraintlayout.databinding.ItemMemberBinding;

import java.util.List;

/**
 * 成员卡片的适配器
 * <p>
 * Created by wangchenlong on 17/4/11.
 */
public class MemberAdapter extends RecyclerView.Adapter<MemberViewHolder> {
    private final List<Member> mMembers;
    private final List<View.OnClickListener> mListeners;

    public MemberAdapter(final @NonNull List<Member> members,
                         final @NonNull List<View.OnClickListener> listeners) {
        mMembers = members;
        mListeners = listeners;
    }

    @Override public MemberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemMemberBinding binding = ItemMemberBinding.inflate(
                LayoutInflater.from(parent.getContext()), parent, false);
        return new MemberViewHolder(binding);
    }

    @Override public void onBindViewHolder(MemberViewHolder holder, int position) {
        holder.bind(mMembers.get(position), mListeners.get(position));
    }

    @Override public int getItemCount() {
        return mMembers.size();
    }
}
