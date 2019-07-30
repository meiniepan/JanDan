package com.liompei.jandan.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.liompei.jandan.R;
import com.liompei.jandan.base.BaseFragment;
import com.liompei.jandan.bean.OtherBean;
import com.liompei.jandan.contract.OtherContract;
import com.liompei.jandan.network.base.HttpConfig;
import com.liompei.jandan.presenter.OtherPresenter;
import com.liompei.jandan.ui.adapter.JokesAdapter;

/**
 * Created by Liompei
 * time : 2017/11/9 10:34
 * 1137694912@qq.com
 * remark:段子
 */

public class JokesFragment extends BaseFragment implements OtherContract.View, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;

    private OtherContract.Presenter mPresenter;
    private JokesAdapter mJokesAdapter;

    private int mPage;

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
        mPage = 1;
        mRefreshLayout.setOnRefreshListener(this);
        mPresenter = new OtherPresenter(this, this);
        mJokesAdapter = new JokesAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseActivity()));
        mRecyclerView.setAdapter(mJokesAdapter);
    }

    @Override
    protected void onEvent() {

    }

    @Override
    protected void lazyLoad() {
        mPresenter.doOther(HttpConfig.API_JOKES, mPage);
    }

    @Override
    public void onRefresh() {
        mPage = 1;
        mPresenter.doOther(HttpConfig.API_JOKES, mPage);
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
        if (mRefreshLayout.isRefreshing()) {
            mRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void nextOther(int page, OtherBean otherBean) {
        mJokesAdapter.newData(otherBean.getComments());
    }


}
