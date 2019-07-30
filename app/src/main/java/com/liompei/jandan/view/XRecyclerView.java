package com.liompei.jandan.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.liompei.jandan.util.GlideApp;

/**
 * Created by Liompei
 * time : 2017/11/9 17:00
 * 1137694912@qq.com
 * remark:
 */

public class XRecyclerView extends RecyclerView {
    public XRecyclerView(Context context) {
        this(context, null);
    }

    public XRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public XRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        addOnScrollListener(new ImageScrollListener());
    }

    class ImageScrollListener extends OnScrollListener {
        @Override
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            super.onScrolled(recyclerView, dx, dy);
        }

        @Override
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            super.onScrollStateChanged(recyclerView, newState);
            switch (newState) {
                case SCROLL_STATE_IDLE:  //初始状态,没有滑动
                    //停止滚动，加载图片
                    try {
                        if (getContext() != null) {
                            GlideApp.with(getContext()).resumeRequests();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case SCROLL_STATE_DRAGGING:  //正在被拖动
                    //屏幕滚动，手指停留在屏幕上，停止加载
                    try {
                        if (getContext() != null) {
                            GlideApp.with(getContext()).pauseRequests();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
                case SCROLL_STATE_SETTLING:  //正在进行最后的惯性滑动
                    //滑动状态下停止加载图片
                    try {
                        if (getContext() != null) {
                            GlideApp.with(getContext()).pauseRequests();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
    }

}
