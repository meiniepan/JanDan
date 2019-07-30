package com.liompei.jandan.presenter;

import com.liompei.jandan.base.BaseFragment;
import com.liompei.jandan.bean.NewsBean;
import com.liompei.jandan.contract.NewsContract;
import com.liompei.jandan.model.NewsModel;

/**
 * Created by Liompei
 * time : 2017/11/9 10:42
 * 1137694912@qq.com
 * remark:
 */

public class NewsPresenter implements NewsContract.Presenter {

    private NewsContract.Model mModel;
    private NewsContract.View mView;

    public NewsPresenter(BaseFragment baseFragment, NewsContract.View view) {
        mModel = new NewsModel(baseFragment, this);
        mView = view;
    }

    @Override
    public void doNews(int page) {
        mModel.netNews(page);
    }

    @Override
    public void newsNext(int page, NewsBean newsBean) {
        mView.nextNews(page,newsBean);
    }

    @Override
    public void compile() {
        mView.hideProgress();
    }
}
