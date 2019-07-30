package com.liompei.jandan.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.widget.ProgressBar;

import com.liompei.jandan.R;
import com.liompei.jandan.base.BaseFragment;
import com.liompei.jandan.contract.MainContract;
import com.liompei.jandan.presenter.MainPresenter;

/**
 * Created by Liompei
 * time : 2017/11/7 15:07
 * 1137694912@qq.com
 * remark:
 */

public class AutoFragment extends BaseFragment implements MainContract.View, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private MainContract.Presenter mPresenter;


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_auto;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        mProgressBar = findViewById(R.id.progressBar);
        mRefreshLayout = findViewById(R.id.swipe);
        mRecyclerView = findViewById(R.id.recycler);
    }

    @Override
    protected void initData() {
        mRefreshLayout.setOnRefreshListener(this);
        mPresenter = new MainPresenter(this, this);
    }


    @Override
    protected void onEvent() {
    }

    @Override
    protected void lazyLoad() {
    }


    @Override
    public void onRefresh() {
    }



}
