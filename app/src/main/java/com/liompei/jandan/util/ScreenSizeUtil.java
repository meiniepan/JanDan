package com.liompei.jandan.util;

import android.app.Activity;

/**
 * Created by Liompei
 * time : 2017/11/9 16:16
 * 1137694912@qq.com
 * remark:获取当前屏幕的宽高
 */

public class ScreenSizeUtil {
    public static int getScreenWidth(Activity activity) {
        return activity.getWindowManager().getDefaultDisplay().getWidth();
    }

    public static int getScreenHeight(Activity activity) {
        return activity.getWindowManager().getDefaultDisplay().getHeight();
    }
}
