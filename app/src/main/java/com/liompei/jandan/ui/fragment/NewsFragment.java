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
import com.liompei.jandan.bean.NewsBean;
import com.liompei.jandan.contract.NewsContract;
import com.liompei.jandan.presenter.NewsPresenter;
import com.liompei.jandan.ui.adapter.NewsAdapter;

/**
 * Created by Liompei
 * time : 2017/11/9 10:25
 * 1137694912@qq.com
 * remark:新鲜事
 */

public class NewsFragment extends BaseFragment implements NewsContract.View, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;

    private NewsContract.Presenter mPresenter;
    private NewsAdapter mNewsAdapter;

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
        mPresenter = new NewsPresenter(this, this);
        mNewsAdapter = new NewsAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseActivity()));
        mRecyclerView.setAdapter(mNewsAdapter);
    }

    @Override
    protected void onEvent() {

    }

    @Override
    protected void lazyLoad() {
        mPresenter.doNews(mPage);
    }

    @Override
    public void onRefresh() {
        mPage = 1;
        mPresenter.doNews(mPage);
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
    public void nextNews(int page, NewsBean newsBean) {
        mNewsAdapter.newData(newsBean.getPosts());
    }

}
