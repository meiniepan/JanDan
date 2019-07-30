package com.liompei.jandan.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.liompei.jandan.R;
import com.liompei.jandan.base.BaseFragment;
import com.liompei.jandan.bean.OtherBean;
import com.liompei.jandan.contract.OtherContract;
import com.liompei.jandan.listener.OnItemChildClickListener;
import com.liompei.jandan.network.base.HttpConfig;
import com.liompei.jandan.presenter.OtherPresenter;
import com.liompei.jandan.ui.adapter.PictureAdapter;
import com.prim.primweb.core.PrimWeb;

/**
 * 树洞
 */

public class TreeHoleFragment extends BaseFragment {

    private WebView webView;


    @Override
    public int getLayoutResId() {
        return R.layout.fragment_tree;
    }

    @Override
    protected void initView(@Nullable Bundle savedInstanceState) {
        webView = findViewById(R.id.web);
    }

    @Override
    protected void initData() {
        PrimWeb.with(getActivity())
                .setWebParent(webView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT))
                .useDefaultUI()
                .useDefaultTopIndicator()
                .setWebViewType(PrimWeb.WebViewType.X5)
//                .setListenerCheckJsFunction(getActivity())
                .buildWeb()
                .lastGo()
                .launch("http://jandan.net/treehole");
//        webView.loadUrl("http://jandan.net/treehole");
    }

    @Override
    protected void onEvent() {

    }


}
