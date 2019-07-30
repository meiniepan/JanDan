package com.liompei.jandan.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.liompei.jandan.R;
import com.liompei.zxlog.Zx;

/**
 * Created by Liompei
 * time : 2017/11/9 9:13
 * 1137694912@qq.com
 * remark:
 */

public class GlideUtil {

    public static void load(Context context, @Nullable Object url, final ImageView imageView) {
        GlideApp.with(context)
                .load(url)
                .placeholder(R.drawable.icon_default_picture)
                .into(imageView);
    }

    public static void loadPicture(Context context, @Nullable Object url, final ImageView imageView) {
        GlideApp.with(context)
                .asBitmap()
                .load(url)
                .placeholder(R.drawable.icon_default_picture)
                .into(new SimpleTarget<Bitmap>() {
                    @Override
                    public void onResourceReady(Bitmap resource, Transition<? super Bitmap> transition) {
                        imageView.setImageBitmap(resource);
                        imageView.requestLayout();
                        Zx.d("原图 宽 " + resource.getWidth() + ",高" + resource.getHeight() + "图片宽" + imageView.getWidth());
                        int height = (int) getBitmapHeight(resource, imageView.getWidth());
                        Zx.i("计算后 宽" + imageView.getWidth() + ",高" + height);
                        if (height == 0) {
                            imageView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 700));
                        } else {
                            imageView.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height));
                        }
                    }
                });
    }

    public static void loadPictureGif(Context context, @Nullable Object url, final ImageView imageView) {
        GlideApp.with(context)
                .asGif()
                //.dontAnimate()
                .load(url)
                .into(imageView);
    }

    //拿到图片缩放后的高度
    private static float getBitmapHeight(Bitmap bitmap, int width) {
        float bitmapWidth = bitmap.getWidth();
        float bitmapHeight = bitmap.getHeight();

        if (bitmapWidth > 0 && bitmapHeight > 0) {
            //拿到宽度的缩放值
            float scaleWidth = width / bitmapWidth;
            //拿到高度根据宽度缩放后的高度
            return bitmapHeight * scaleWidth;
        }
        return 0;
    }

}
