package com.liompei.jandan.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by Liompei
 * time : 2017/11/9 14:41
 * 1137694912@qq.com
 * remark:
 */

public class SquareFrameLayout extends FrameLayout {
    public SquareFrameLayout(@NonNull Context context) {
        super(context);
    }

    public SquareFrameLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //保证高度与宽度相等的正方形
        super.onMeasure(widthMeasureSpec, widthMeasureSpec);
    }
}
