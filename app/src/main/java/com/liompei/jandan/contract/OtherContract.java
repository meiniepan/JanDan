package com.liompei.jandan.contract;

import com.liompei.jandan.bean.OtherBean;

/**
 * Created by Liompei
 * time : 2017/11/9 11:12
 * 1137694912@qq.com
 * remark:
 */

public interface OtherContract {
    interface Model {
        void netOther(String api,int page);
    }

    interface View {
        void showProgress();

        void hideProgress();

        void nextOther(int page,OtherBean otherBean);
    }

    interface Presenter {
        void doOther(String api,int page);

        void otherNext(int page,OtherBean otherBean);

        void compile();
    }
}
