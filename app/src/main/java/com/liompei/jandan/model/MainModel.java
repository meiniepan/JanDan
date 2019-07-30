package com.liompei.jandan.model;

import com.liompei.jandan.base.BaseFragment;
import com.liompei.jandan.contract.MainContract;

/**
 * Created by Liompei
 * time : 2017/11/7 13:29
 * 1137694912@qq.com
 * remark:
 */

public class MainModel implements MainContract.Model {

    private BaseFragment mBaseFragment;
    private MainContract.Presenter mPresenter;

    public MainModel(BaseFragment baseFragment, MainContract.Presenter presenter) {
        mBaseFragment = baseFragment;
        mPresenter = presenter;
    }

}
