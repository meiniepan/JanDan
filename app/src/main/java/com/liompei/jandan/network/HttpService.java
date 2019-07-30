package com.liompei.jandan.network;

import com.liompei.jandan.bean.NewsBean;
import com.liompei.jandan.bean.OtherBean;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Liompei
 * time : 2017/11/8 9:33
 * 1137694912@qq.com
 * remark:
 */

public interface HttpService {

    @GET("?oxwlxojflwblxbsapi=get_recent_posts&include=url,date,tags,author,title,excerpt,comment_count,comment_status,custom_fields&custom_fields=thumb_c,views&dev=1")
    Observable<NewsBean> news(@Query("page") int page);

    @GET("/")
    Observable<OtherBean> other(@Query("oxwlxojflwblxbsapi") String api, @Query("page") int page);

}
