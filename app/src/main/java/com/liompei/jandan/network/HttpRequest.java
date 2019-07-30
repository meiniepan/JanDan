package com.liompei.jandan.network;

import com.liompei.jandan.base.BaseFragment;
import com.liompei.jandan.bean.NewsBean;
import com.liompei.jandan.bean.OtherBean;
import com.liompei.jandan.network.base.HttpCallback;
import com.liompei.jandan.network.base.HttpConfig;
import com.liompei.jandan.network.base.MyObserver;
import com.liompei.zxlog.Zx;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.FragmentEvent;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Liompei
 * time : 2017/11/8 9:55
 * 1137694912@qq.com
 * remark:
 */

public class HttpRequest {

    private Retrofit mRetrofit;
    private OkHttpClient mOkHttpClient;
    private HttpService mHttpService;

    private static HttpRequest instance;

    public static HttpRequest getInstance() {
        if (instance == null) {
            synchronized (HttpRequest.class) {
                instance = new HttpRequest();
            }
        }
        return instance;
    }

    HttpLoggingInterceptor mLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            Zx.wtf(message);
        }
    });

    private HttpRequest() {
        mLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //手动创建一个OkHttpClient并设置超时时间
        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(HttpConfig.HTTP_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(mLoggingInterceptor)
                .build();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(HttpConfig.BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mHttpService = mRetrofit.create(HttpService.class);
    }

    //新鲜事
    public void news(BaseFragment baseFragment, int page, HttpCallback<NewsBean> httpCallback) {
        Observable newsBeanObservable = mHttpService.news(page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(new Predicate<NewsBean>() {
                    @Override
                    public boolean test(NewsBean newsBean) throws Exception {
                        if ("ok".equals(newsBean.getStatus())) {
                            return true;
                        }
                        return false;
                    }
                })
                .compose(RxLifecycle.bindUntilEvent(baseFragment.lifecycle(), FragmentEvent.DESTROY));
        newsBeanObservable.subscribe(new MyObserver<NewsBean>(httpCallback));
    }


    //无聊图 妹子图 段子
    public void other(BaseFragment baseFragment, String api, int page, HttpCallback<OtherBean> httpCallback) {
        Observable newsBeanObservable = mHttpService.other(api, page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .filter(new Predicate<OtherBean>() {
                    @Override
                    public boolean test(OtherBean otherBean) throws Exception {
                        if ("ok".equals(otherBean.getStatus())) {
                            return true;
                        }
                        return false;
                    }
                })
                .compose(RxLifecycle.bindUntilEvent(baseFragment.lifecycle(), FragmentEvent.DESTROY));
        newsBeanObservable.subscribe(new MyObserver<OtherBean>(httpCallback));
    }

}
