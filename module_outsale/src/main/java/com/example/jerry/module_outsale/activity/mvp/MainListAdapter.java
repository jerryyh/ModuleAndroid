package com.example.jerry.module_outsale.activity.mvp;

import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.text.Html;
import android.text.TextUtils;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.jerry.module_outsale.R;
import com.example.jerry.comment_data.bean.FeedArticleData;

import java.util.List;

/**
 * @Created by jerry .
 * @时间 2018/6/1 13:49
 * @描述 ${adapter}
 */

public class MainListAdapter extends BaseQuickAdapter<FeedArticleData, BaseViewHolder> {

    private boolean isSearchPage = false;
    private boolean isCollectPage = false;

    public MainListAdapter(@Nullable List<FeedArticleData> data) {
        super(R.layout.mall_item_home_info, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, FeedArticleData item) {
        if (!TextUtils.isEmpty(item.getTitle())) {
            helper.setText(R.id.item_home_title, Html.fromHtml(item.getTitle()));
        }
        if (item.isCollect() || isCollectPage) {
            helper.setImageResource(R.id.item_home_like_iv, R.mipmap.icon_like_article_selected);
        } else {
            helper.setImageResource(R.id.item_home_like_iv, R.mipmap.icon_like_article_not_selected);
        }
        if (!TextUtils.isEmpty(item.getAuthor())) {
            helper.setText(R.id.item_home_author, mContext.getString(R.string.mall_item_article_author, item.getAuthor()));
        }
        if (!TextUtils.isEmpty(item.getChapterName())) {
            helper.setText(R.id.item_home_chapterName, mContext.getString(R.string.mall_item_article_classify, item.getChapterName()));
        }
        if (!TextUtils.isEmpty(item.getNiceDate())) {
            helper.setText(R.id.item_home_niceDate, mContext.getString(R.string.mall_item_article_time, item.getNiceDate()));
        }
        if (isSearchPage) {
            CardView cardView = helper.getView(R.id.item_home_card_view);
            cardView.setForeground(null);
            cardView.setBackground(ContextCompat.getDrawable(mContext, R.drawable.mall_selector_search_item_bac));
        }

        helper.addOnClickListener(R.id.item_home_like_iv);
    }
}
