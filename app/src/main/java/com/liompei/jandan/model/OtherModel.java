package com.liompei.jandan.model;

import com.liompei.jandan.base.BaseFragment;
import com.liompei.jandan.bean.OtherBean;
import com.liompei.jandan.contract.OtherContract;
import com.liompei.jandan.network.HttpRequest;
import com.liompei.jandan.network.base.HttpCallback;

/**
 * Created by Liompei
 * time : 2017/11/9 11:12
 * 1137694912@qq.com
 * remark:
 */

public class OtherModel implements OtherContract.Model {

    private BaseFragment mBaseFragment;
    private OtherContract.Presenter mPresenter;

    public OtherModel(BaseFragment baseFragment, OtherContract.Presenter presenter) {
        mBaseFragment = baseFragment;
        mPresenter = presenter;
    }


    @Override
    public void netOther(String api, final int page) {
        HttpRequest.getInstance().other(mBaseFragment, api,page, new HttpCallback<OtherBean>() {
            @Override
            public void onNext(OtherBean otherBean) {
                mPresenter.otherNext(page, otherBean);
            }

            @Override
            public void onComplete() {
                mPresenter.compile();
            }
        });
    }
}
