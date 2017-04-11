package org.wangchenlong.constraintlayout.list;

import android.content.Context;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.DrawableRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import org.wangchenlong.constraintlayout.R;
import org.wangchenlong.constraintlayout.databinding.ItemMemberBinding;
import org.wangchenlong.styles.Utils;

/**
 * 成员卡片的ViewHolder, 动态设置背景颜色
 * <p>
 * Created by wangchenlong on 17/4/11.
 */
public class MemberViewHolder extends RecyclerView.ViewHolder {

    private ItemMemberBinding mBinding;
    private Context mContext;

    public MemberViewHolder(ItemMemberBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
        mContext = itemView.getContext();
    }

    public void bind(Member member, View.OnClickListener listener) {
        mBinding.setMember(member);

        resetImageViewHeight(member.drawableRes);
        mBinding.memberIvLogo.setImageResource(member.drawableRes);

        mBinding.memberIvName.setText(member.name);

        mBinding.memberIvContainer.setBackgroundDrawable(getBkgColor(member));

        mBinding.memberIvContainer.setOnClickListener(listener);
    }

    /**
     * 动态设置背景颜色
     *
     * @param member 成员数据
     * @return 修改颜色后的背景
     */
    private GradientDrawable getBkgColor(Member member) {
        final GradientDrawable gd = (GradientDrawable) ContextCompat.getDrawable(
                mContext, R.drawable.bkg_member);
        gd.setColor(ContextCompat.getColor(mContext, member.colorRes));
        gd.mutate();
        return gd;
    }

    /**
     * 根据Drawable重置图片视图的高度
     *
     * @param res 图片资源
     */
    private void resetImageViewHeight(@DrawableRes int res) {
        ViewGroup.LayoutParams lp = mBinding.memberIvLogo.getLayoutParams();
        lp.height = getImageViewHeight(mContext, res);
        mBinding.memberIvLogo.setLayoutParams(lp);
    }

    /**
     * 获取图片布局的高度
     *
     * @param context 上下文
     * @param res     资源
     * @return 高度
     */
    private int getImageViewHeight(Context context, @DrawableRes int res) {
        float screenWidth = (float) Utils.getScreenWidth();
        int[] bitmapSize = Utils.getBitmapSize(context, res);
        return (int) ((screenWidth / 2.0f) / ((float) bitmapSize[0]) * ((float) bitmapSize[1]));
    }
}
