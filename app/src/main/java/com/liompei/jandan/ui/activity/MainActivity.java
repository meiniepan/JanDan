package com.liompei.jandan.ui.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.liompei.jandan.R;
import com.liompei.jandan.base.BaseActivity;
import com.liompei.jandan.ui.adapter.TabMainAdapter;
import com.liompei.jandan.ui.fragment.JokesFragment;
import com.liompei.jandan.ui.fragment.NewsFragment;
import com.liompei.jandan.ui.fragment.OoxxFragment;
import com.liompei.jandan.ui.fragment.PicFragment;
import com.liompei.jandan.ui.fragment.TreeHoleFragment;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class MainActivity extends BaseActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    private String[] tabNames;
    private Fragment[] fragments;
    private TabMainAdapter mTabMainAdapter;

    private Fragment mNewsFragment;
    private Fragment mPicFragment;
    private Fragment mOoxxFragment;
    private Fragment mJokesFragment;
    private Fragment mTree;

    private int nowCurrentItem = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void initViews(Bundle savedInstanceState) {
        getToolbar("煎蛋", false);
        mTabLayout = findViewById(R.id.tab_layout);
        mViewPager = findViewById(R.id.viewpager);
        mNewsFragment = new NewsFragment();
        mPicFragment = new PicFragment();
        mOoxxFragment = new OoxxFragment();
        mJokesFragment = new JokesFragment();
        mTree = new TreeHoleFragment();
        tabNames = new String[]{"新鲜事", "无聊图", "妹子图","树洞"};
        fragments = new Fragment[]{mNewsFragment, mPicFragment, mOoxxFragment, mTree};
        mTabMainAdapter = new TabMainAdapter(getSupportFragmentManager(), tabNames, fragments);
    }

    @Override
    public void initData() {
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setAdapter(mTabMainAdapter);
        mViewPager.setOffscreenPageLimit(tabNames.length);
        mViewPager.setCurrentItem(nowCurrentItem);
    }

    @Override
    public void onEvent() {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                Toast.makeText(MainActivity.this,"暂未开放",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_1:
                Toast.makeText(MainActivity.this,"暂未开放",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_2:
                Toast.makeText(MainActivity.this,"暂未开放",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_3:
                Toast.makeText(MainActivity.this,"暂未开放",Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_about_me:
                new AlertDialog.Builder(this)
                        .setTitle("Solang")
                        .setMessage("https://github.com/meiniepan")
                        .setPositiveButton("支持我", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Toast.makeText(MainActivity.this,"心领了先",Toast.LENGTH_LONG).show();
                            }
                        })
                        .show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
