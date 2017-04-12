package org.wangchenlong.constraintlayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import org.wangchenlong.constraintlayout.list.Member;
import org.wangchenlong.constraintlayout.list.MemberAdapter;
import org.wangchenlong.constraintlayout.member.MemberDialogFragment;
import org.wangchenlong.styles.Utils;

import java.util.ArrayList;
import java.util.List;

/**
 * ConstraintLayout的使用方式
 * <p>
 * Created by wangchenlong on 17/4/11.
 */
public class ConstraintLayoutActivity extends AppCompatActivity {
    private RecyclerView mRvList;
    private List<Member> mMembers;
    private List<View.OnClickListener> mListeners;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);

        initData();
        initViews();
    }

    private void initData() {
        mMembers = Member.createFakeMembers();
        mListeners = new ArrayList<>();
        for (int i = 0; i < mMembers.size(); ++i) {
            final Member member = mMembers.get(i);
            View.OnClickListener listener = new View.OnClickListener() {
                @Override public void onClick(View v) {
                    Utils.showToast(ConstraintLayoutActivity.this, member.toString());
                    MemberDialogFragment.newInstance(member)
                            .show(getSupportFragmentManager(), null);
                }
            };
            mListeners.add(listener);
        }
    }

    /**
     * 初始化视图
     */
    private void initViews() {
        mRvList = (RecyclerView) findViewById(R.id.cst_rv_list);
        mRvList.setAdapter(new MemberAdapter(Member.createFakeMembers(), mListeners));
    }
}
