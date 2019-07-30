package com.liompei.jandan.model;

import com.liompei.jandan.base.BaseFragment;
import com.liompei.jandan.bean.NewsBean;
import com.liompei.jandan.contract.NewsContract;
import com.liompei.jandan.network.HttpRequest;
import com.liompei.jandan.network.base.HttpCallback;

/**
 * Created by Liompei
 * time : 2017/11/9 10:42
 * 1137694912@qq.com
 * remark:
 */

public class NewsModel implements NewsContract.Model {

    private BaseFragment mBaseFragment;
    private NewsContract.Presenter mPresenter;

    public NewsModel(BaseFragment baseFragment, NewsContract.Presenter presenter) {
        mBaseFragment = baseFragment;
        mPresenter = presenter;
    }

    @Override
    public void netNews(final int page) {
        HttpRequest.getInstance().news(mBaseFragment, page, new HttpCallback<NewsBean>() {
            @Override
            public void onNext(NewsBean newsBean) {
                mPresenter.newsNext(page, newsBean);
            }

            @Override
            public void onComplete() {
                mPresenter.compile();
            }
        });
    }
}
