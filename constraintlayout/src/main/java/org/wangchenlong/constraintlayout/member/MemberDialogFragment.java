package org.wangchenlong.constraintlayout.member;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.wangchenlong.constraintlayout.databinding.FragmentMemberDialogBinding;
import org.wangchenlong.constraintlayout.list.Member;

/**
 * 成员的Dialog展示界面
 * <p>
 * Created by wangchenlong on 17/4/12.
 */
public class MemberDialogFragment extends BottomSheetDialogFragment {
    private static final String ARG_MEMBER = "arg_member";
    private Member mMember; // 成员数据
    private FragmentMemberDialogBinding mBinding;

    public static MemberDialogFragment newInstance(@NonNull Member member) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_MEMBER, member);

        final MemberDialogFragment memberFragment = new MemberDialogFragment();
        memberFragment.setArguments(args);

        return memberFragment;
    }

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        mBinding = FragmentMemberDialogBinding.inflate(inflater, container, false);
        return mBinding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mMember = getMember();
        mBinding.setMember(mMember);
    }

    /**
     * 获取传递数据
     *
     * @return 当前成员
     */
    private Member getMember() {
        return (Member) getArguments().getSerializable(ARG_MEMBER);
    }
}
