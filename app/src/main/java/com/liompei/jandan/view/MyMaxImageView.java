package com.liompei.jandan.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.liompei.zxlog.Zx;

/**
 * Created by Liompei
 * time : 2017/11/9 15:58
 * 1137694912@qq.com
 * remark:宽度最大，高度自适应的imageView
 * 若高度超过屏幕，将被压缩为屏幕的1/3
 */

public class MyMaxImageView extends ImageView {

    private float mHeight = 0;

    public MyMaxImageView(Context context) {
        super(context);
    }

    public MyMaxImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyMaxImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int withSpec = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpec = MeasureSpec.getSize(heightMeasureSpec);
        Zx.e("设置 宽： " + withSpec + "高： " + heightSpec);
        Zx.e(getMeasuredWidth()+"  "+getWidth());
        if (heightSpec == 0) {
            setMeasuredDimension(withSpec, 760);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
//        Zx.i("onMeasuse" + widthMeasureSpec + heightMeasureSpec);
//        Zx.i("onMeasure" + getWidth() + "  " + getHeight());
//        Drawable drawable = getDrawable();
//        if (drawable != null) {
//            int width = MeasureSpec.getSize(widthMeasureSpec);
//            int height = (int) Math.ceil((float) width * (float) drawable.getIntrinsicHeight() / (float) drawable.getIntrinsicWidth());
//            setMeasuredDimension(width, height);
//        } else {
//            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
//        }

        if (mHeight != 0) {
//            Zx.d(mHeight);
            int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
            int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);   //当前高
//            int resultHeight = (int) Math.max(mHeight, sizeHeight);  //当前的高度和缩放的高度哪个大取哪个值

//            if (resultHeight >= ScreenSizeUtil.getScreenHeight((Activity) getContext())) {
//                resultHeight = ScreenSizeUtil.getScreenHeight((Activity) getContext()) / 3;
//            }
            Zx.d("设置宽高： " + sizeWidth + "   " + (int) mHeight);
            setMeasuredDimension(sizeWidth, (int) mHeight);
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }

    //设置一个位图作为这个ImageView的内容
//    @Override
//    public void setImageBitmap(Bitmap bm) {
//        Zx.d("setImageBitmap"+bm.getWidth());
//        if (bm != null) {
//            getBitmapHeight(bm);
//        }
//        super.setImageBitmap(bm);
//        requestLayout();  //重新测量
//    }


//    @Override
//    public void setImageDrawable(@Nullable Drawable drawable) {
//        Zx.d("setImageDrawable");
//        if (drawable != null) {
//            Zx.d(drawable.getIntrinsicWidth());
//            Zx.d(drawable.getIntrinsicHeight());
//            getBitmapHeight(getBitmapForDrawable(drawable));
//        }
//        super.setImageDrawable(drawable);
//        requestLayout();  //重新测量
//    }

    //拿到图片缩放后的高度
//    private void getBitmapHeight(Bitmap bitmap) {
//        Zx.d(bitmap.getWidth());
//        Zx.d(bitmap.getHeight());
//        float bitmapWidth = bitmap.getWidth();
//        float bitmapHeight = bitmap.getHeight();
//        Zx.d("图片宽高： " + bitmapWidth + "   " + bitmapHeight);
//
//        if (bitmapWidth > 0 && bitmapHeight > 0) {
//            //拿到宽度的缩放值
//            float scaleWidth = getWidth() / bitmapWidth;
//            //拿到高度根据宽度缩放后的高度
//            mHeight = bitmapHeight * scaleWidth;
//            Zx.d("缩放后宽高： " + getWidth() + "   " + mHeight);
//        }
//    }

//    private Bitmap getBitmapForDrawable(Drawable drawable) {
//        if (drawable != null) {
//            if (drawable instanceof GifDrawable){
//                Zx.d("是GIF图片,第一帧");
//                GifDrawable gifDrawable= (GifDrawable) drawable;
//                return gifDrawable.getFirstFrame();
//            }else if (drawable instanceof BitmapDrawable){
//                Zx.d("是bitmap图片");
//                BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
//                return bitmapDrawable.getBitmap();
//            }else {
//                Zx.d("未知图片");
//                return null;
//            }
//        } else {
//            return null;
//        }
//    }

}
