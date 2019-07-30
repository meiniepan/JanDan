package com.liompei.jandan.presenter;

import com.liompei.jandan.base.BaseFragment;
import com.liompei.jandan.bean.OtherBean;
import com.liompei.jandan.contract.OtherContract;
import com.liompei.jandan.model.OtherModel;

/**
 * Created by Liompei
 * time : 2017/11/9 11:12
 * 1137694912@qq.com
 * remark:
 */

public class OtherPresenter implements OtherContract.Presenter {

    private OtherContract.Model mModel;
    private OtherContract.View mView;

    public OtherPresenter(BaseFragment baseFragment, OtherContract.View view) {
        mModel = new OtherModel(baseFragment, this);
        mView = view;
    }

    @Override
    public void doOther(String api, int page) {
        mModel.netOther(api,page);
    }

    @Override
    public void otherNext(int page, OtherBean otherBean) {
        mView.nextOther(page, otherBean);
    }

    @Override
    public void compile() {
        mView.hideProgress();
    }
}
