package com.liompei.jandan.network.base;

import io.reactivex.disposables.Disposable;

/**
 * Created by Liompei
 * time : 2017/11/8 11:04
 * 1137694912@qq.com
 * remark:
 */

public abstract class HttpCallback<T> {

    public void onSubscribe(Disposable d) {

    }

    public abstract void onNext(T t);

    public void onError(Throwable e) {

    }

    public void onComplete() {

    }
}
