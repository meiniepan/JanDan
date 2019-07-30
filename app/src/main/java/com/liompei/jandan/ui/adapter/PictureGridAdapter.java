package com.liompei.jandan.ui.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liompei
 * time : 2017/11/9 15:49
 * 1137694912@qq.com
 * remark:
 */

public class PictureGridAdapter extends BaseAdapter {

    private List<String> pics;

    public PictureGridAdapter() {
        pics=new ArrayList<>();
    }

    @Override
    public int getCount() {
        return pics.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        return null;
    }

    class MyHolder {

    }
}
