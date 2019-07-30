package com.liompei.jandan.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.liompei.jandan.R;
import com.trello.rxlifecycle2.components.support.RxFragment;

/**
 * Created by Liompei
 * time : 2017/11/7 15:03
 * 1137694912@qq.com
 * remark:
 */

public abstract class BaseFragment extends RxFragment {

    private View parentView;
    private boolean isCreated;
    protected boolean isVisible;
    protected boolean isLazyed;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(getLayoutResId(), container, false);
        initView(savedInstanceState);
        initData();
        return parentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onEvent();
        isCreated=true;
        onVisible();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    protected void onVisible() {
        if (isVisible&&!isLazyed&&isCreated){
            isLazyed = true;
            lazyLoad();
        }
    }

    protected void lazyLoad() {
    }

    protected void onInvisible() {
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    protected BaseActivity getBaseActivity() {
        return (BaseActivity) getActivity();
    }

    public abstract
    @LayoutRes
    int getLayoutResId();

    protected abstract void initView(@Nullable Bundle savedInstanceState);

    protected abstract void initData();

    protected abstract void onEvent();

    protected <T extends View> T findViewById(int resId) {
        return parentView.findViewById(resId);
    }

    protected Toolbar getToolbar(CharSequence title, boolean showHomeAsUp) {
        Toolbar toolbar = parentView.findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        getBaseActivity().setSupportActionBar(toolbar);
        getBaseActivity().getSupportActionBar().setDisplayHomeAsUpEnabled(showHomeAsUp);
        return toolbar;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getBaseActivity().onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void toast(final String s) {
        getBaseActivity().toast(s);
    }
}
