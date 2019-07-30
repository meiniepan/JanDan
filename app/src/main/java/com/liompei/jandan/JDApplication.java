package com.liompei.jandan;

import android.app.Activity;
import android.app.Application;

import com.liompei.zxlog.Zx;
import com.squareup.leakcanary.LeakCanary;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liompei
 * time : 2017/11/7 11:16
 * 1137694912@qq.com
 * remark:
 */

public class JDApplication extends Application {

    //***全局***
    public static JDApplication instance;

    public static JDApplication getInstance() {
        return instance;
    }

    private List<Activity> activityList = new ArrayList<>();

    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public void deleteActivity(Activity activity) {
        activityList.remove(activity);
    }

    public void finishAllActivity() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        activityList.clear();
    }

    // 退出
    public void exit() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        activityList.clear();
        System.exit(0);
    }
    //***end***

    @Override
    public void onCreate() {
        super.onCreate();
//        if (LeakCanary.isInAnalyzerProcess(this)) {
//            // This process is dedicated to LeakCanary for heap analysis.
//            // You should not init your app in this process.
//            //此过程专用于LeakCanary进行堆分析
//            //在这个过程中你不应该启动你的应用程序
//            Zx.i("此过程专用于LeakCanary进行堆分析,在这个过程中你不应该启动你的应用程序");
//            return;
//        }
//        LeakCanary.install(this);
        instance = this;
    }

}
