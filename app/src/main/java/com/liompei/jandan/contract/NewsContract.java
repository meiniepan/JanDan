package com.liompei.jandan.contract;

import com.liompei.jandan.bean.NewsBean;

/**
 * Created by Liompei
 * time : 2017/11/9 10:42
 * 1137694912@qq.com
 * remark:
 */

public interface NewsContract extends MainContract {
    interface Model {
        void netNews(int page);
    }

    interface View {
        void showProgress();

        void hideProgress();

        void nextNews(int page,NewsBean newsBean);
    }

    interface Presenter {
        void doNews(int page);

        void newsNext(int page,NewsBean newsBean);

        void compile();
    }
}
