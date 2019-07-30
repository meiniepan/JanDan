package com.liompei.jandan.network.base;

import com.liompei.zxlog.Zx;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by Liompei
 * time : 2017/11/8 11:11
 * 1137694912@qq.com
 * remark:
 */

public class MyObserver<T> implements Observer<T> {

    private HttpCallback<T> mHttpCallback;

    public MyObserver(HttpCallback<T> httpCallback) {
        mHttpCallback = httpCallback;
    }

    @Override
    public void onSubscribe(Disposable d) {
        mHttpCallback.onSubscribe(d);
    }

    @Override
    public void onNext(T t) {
        mHttpCallback.onNext(t);
    }

    @Override
    public void onError(Throwable e) {
        Zx.d(e.getMessage());
        mHttpCallback.onError(e);
        mHttpCallback.onComplete();
    }

    @Override
    public void onComplete() {
        mHttpCallback.onComplete();
    }
}
