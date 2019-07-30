package com.liompei.jandan.ui.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.liompei.jandan.R;
import com.liompei.jandan.bean.NewsBean;
import com.liompei.jandan.util.GlideUtil;
import com.liompei.jandan.util.TimeUtil;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liompei
 * time : 2017/11/8 14:48
 * 1137694912@qq.com
 * remark:
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyHolder> {

    private List<NewsBean.PostsBean> mPostsBeanList;

    public NewsAdapter() {
        mPostsBeanList = new ArrayList<>();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_list, parent, false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        NewsBean.PostsBean postsBean = mPostsBeanList.get(position);

        GlideUtil.load(holder.iv_img.getContext(), postsBean.getCustom_fields().getThumb_c().get(0), holder.iv_img);
        holder.tv_title.setText(postsBean.getTitle());
        holder.tv_author.setText(postsBean.getAuthor().getNickname());
        holder.tv_comment.setText(postsBean.getComment_count() + "评论");
        try {
            holder.tv_time.setText(TimeUtil.getTimeFormatText(TimeUtil.stringToDate(postsBean.getDate(), "yyyy-MM-dd HH:mm:ss")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return mPostsBeanList.size();
    }

    public void newData(List<NewsBean.PostsBean> postsBeanList){
        mPostsBeanList.clear();
        mPostsBeanList.addAll(postsBeanList);
        notifyDataSetChanged();
    }

    class MyHolder extends RecyclerView.ViewHolder {
        ImageView iv_img;
        TextView tv_title;
        TextView tv_author;
        TextView tv_time;
        TextView tv_comment;

        public MyHolder(View itemView) {
            super(itemView);
            iv_img = itemView.findViewById(R.id.iv_img);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_author = itemView.findViewById(R.id.tv_author);
            tv_time = itemView.findViewById(R.id.tv_time);
            tv_comment = itemView.findViewById(R.id.tv_comment);
        }
    }


}
