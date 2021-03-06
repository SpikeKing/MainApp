package org.wangchenlong.constraintlayout.list;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;

import org.wangchenlong.constraintlayout.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 需要显示的成员, 用于数据传递
 * <p>
 * Created by wangchenlong on 17/4/11.
 */
public final class Member implements Serializable {
    public final String name; // 名字
    public final @DrawableRes int drawableRes; // 图片
    public final @ColorRes int colorRes; // 颜色
    public final String duty; // 队内职务

    public Member(String name, @DrawableRes int drawableRes,
            @ColorRes int colorRes, String duty) {
        this.name = name;
        this.drawableRes = drawableRes;
        this.colorRes = colorRes;
        this.duty = duty;
    }

    public static List<Member> createFakeMembers() {
        Member ParkChoAh = new Member("朴草娥", R.drawable.park_cho_ah,
                R.color.hotpink, "主唱/吉他手");
        Member KimSeolHyun = new Member("金雪炫", R.drawable.kim_seol_hyun,
                R.color.orange, "副主唱/形象担当/领舞");
        Member ShinHyeJeong = new Member("申惠晶", R.drawable.shin_hye_jeong,
                R.color.deeppink, "第三主唱/门面担当");
        Member SeoYuNa = new Member("徐酉奈", R.drawable.seo_yu_na,
                R.color.orchid, "普通成员");

        ArrayList<Member> members = new ArrayList<>();
        members.add(ParkChoAh);
        members.add(KimSeolHyun);
        members.add(ShinHyeJeong);
        members.add(SeoYuNa);

        return members;
    }

    @Override public String toString() {
        return "姓名:" + name + " 担当:" + duty;
    }
}
