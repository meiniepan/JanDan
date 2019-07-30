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
import com.liompei.jandan.listener.OnItemChildClickListener;
import com.liompei.jandan.network.base.HttpConfig;
import com.liompei.jandan.presenter.OtherPresenter;
import com.liompei.jandan.ui.adapter.PictureAdapter;

/**
 * Created by Liompei
 * time : 2017/11/9 10:26
 * 1137694912@qq.com
 * remark:无聊图
 */

public class PicFragment extends BaseFragment implements OtherContract.View, SwipeRefreshLayout.OnRefreshListener {

    private SwipeRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;

    private OtherContract.Presenter mPresenter;
    private PictureAdapter mPicAdapter;

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
        mPicAdapter = new PictureAdapter();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getBaseActivity()));
        mPicAdapter.bindToRecyclerView(mRecyclerView);
        mPicAdapter.setOnItemChildClickListener(new OnItemChildClickListener() {
            @Override
            public void onItemChildClick(View view, int position) {
                switch (view.getId()) {
                    case R.id.m_max_view:
                        if (mPicAdapter.getDataList().get(position).getPics().get(0).endsWith(".gif")) {
//                            GlideUtil.loadPictureGif(myOnlyHolder.mMyMaxImageView.getContext(), picUrl, myOnlyHolder.mMyMaxImageView);
                        } else {

                        }

                        break;
                }
            }
        });
    }

    @Override
    protected void onEvent() {

    }

    @Override
    protected void lazyLoad() {
        mPresenter.doOther(HttpConfig.API_PIC, mPage);
    }

    @Override
    public void onRefresh() {
        mPage = 1;
        mPresenter.doOther(HttpConfig.API_PIC, mPage);
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
        mPicAdapter.newData(otherBean.getComments());
    }


}
