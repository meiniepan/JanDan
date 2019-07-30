package com.liompei.jandan.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.liompei.jandan.JDApplication;
import com.liompei.jandan.R;
import com.trello.rxlifecycle2.components.support.RxAppCompatActivity;

/**
 * Created by Liompei
 * time : 2017/11/7 14:21
 * 1137694912@qq.com
 * remark:
 */

public abstract class BaseActivity extends RxAppCompatActivity {

    protected BaseActivity mBaseActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        JDApplication.getInstance().addActivity(this);
        mBaseActivity=this;
        setContentView(getLayoutId());
        initViews(savedInstanceState);
        initData();
        onEvent();
    }

    public abstract int getLayoutId();

    public abstract void initViews(Bundle savedInstanceState);

    public abstract void initData();

    public abstract void onEvent();

    protected Toolbar getToolbar(CharSequence title, boolean showHomeAsUp) {
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(showHomeAsUp);
        return toolbar;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
        JDApplication.getInstance().deleteActivity(this);
        super.onDestroy();
    }

    @Override
    public void finish() {
        super.finish();
    }

    protected void toast(final String s) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(JDApplication.getInstance(), s, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
