package com.liompei.jandan.presenter;

import com.liompei.jandan.base.BaseFragment;
import com.liompei.jandan.contract.MainContract;
import com.liompei.jandan.model.MainModel;

/**
 * Created by Liompei
 * time : 2017/11/7 13:29
 * 1137694912@qq.com
 * remark:
 */

public class MainPresenter implements MainContract.Presenter {

    private MainContract.Model mModel;
    private MainContract.View mView;

    public MainPresenter(BaseFragment baseFragment, MainContract.View view) {
        mModel = new MainModel(baseFragment, this);
        mView = view;
    }



}
