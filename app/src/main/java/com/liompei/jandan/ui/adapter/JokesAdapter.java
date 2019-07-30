package com.liompei.jandan.ui.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.liompei.jandan.R;
import com.liompei.jandan.bean.OtherBean;
import com.liompei.jandan.util.TimeUtil;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Liompei
 * time : 2017/11/9 13:39
 * 1137694912@qq.com
 * remark:
 */

public class JokesAdapter extends RecyclerView.Adapter<JokesAdapter.MyHolder> {

    private List<OtherBean.CommentsBean> mCommentsBeanList;

    public JokesAdapter() {
        mCommentsBeanList = new ArrayList<>();
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_jokes_list, parent, false));
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        OtherBean.CommentsBean commentsBean = mCommentsBeanList.get(position);
        holder.tv_author.setText(commentsBean.getComment_author());
        holder.tv_content.setText(commentsBean.getText_content());
        holder.tv_like.setText(commentsBean.getVote_positive());
        holder.tv_un_like.setText(commentsBean.getVote_negative());
        holder.tv_comment.setText("吐槽 " + commentsBean.getSub_comment_count());
        try {
            holder.tv_time.setText(TimeUtil.getTimeFormatText(TimeUtil.stringToDate(commentsBean.getComment_date(), "yyyy-MM-dd HH:mm:ss")));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return mCommentsBeanList.size();
    }

    public void newData(List<OtherBean.CommentsBean> commentsBeanList){
        mCommentsBeanList.clear();
        mCommentsBeanList.addAll(commentsBeanList);
        notifyDataSetChanged();
    }

    class MyHolder extends RecyclerView.ViewHolder {

        CardView cv_content;  //
        TextView tv_author;  //作者
        TextView tv_time;  //时间
        TextView tv_content;  //段子内容
        TextView tv_like;  //OO
        TextView tv_un_like;  //XX
        TextView tv_comment;  //吐槽

        public MyHolder(View itemView) {
            super(itemView);
            cv_content=itemView.findViewById(R.id.cv_content);
            tv_author=itemView.findViewById(R.id.tv_author);
            tv_time=itemView.findViewById(R.id.tv_time);
            tv_content=itemView.findViewById(R.id.tv_content);
            tv_like=itemView.findViewById(R.id.tv_like);
            tv_un_like=itemView.findViewById(R.id.tv_un_like);
            tv_comment=itemView.findViewById(R.id.tv_comment);
        }
    }
}
