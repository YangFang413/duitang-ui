package com.yf.duitang.personalui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.yf.duitang.R;
import com.yf.duitang.model.TrendItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/17.
 */
public class HorizontalTrendView extends LinearLayout {

    private int[] imageResources = {R.drawable.gallery0, R.drawable.gallery1, R.drawable.gallery2,
            R.drawable.gallery3, R.drawable.gallery4, R.drawable.gallery5};

    private String[] imageDescriptions = {"权利的游戏", "风吹的风景", "插画背景",
            "美食君", "吃", "你好四月"};

    private List<TrendItem> trendItemList;

    public HorizontalTrendView(Context context, AttributeSet attrs) {
        super(context, attrs);
        if (isInEditMode()){return;}
        initData();
        addTrendView();
    }

    private void initData() {
        trendItemList = new ArrayList<>();
        for (int i = 0; i < imageResources.length; i++) {
            TrendItem trendItem = new TrendItem();
            trendItem.setImageResource(imageResources[i]);
            trendItem.setText(imageDescriptions[i]);
            trendItemList.add(trendItem);
        }
    }

    private void addTrendView(){
        for (int i = 0; i < trendItemList.size(); i++) {
            View view = LayoutInflater.from(getContext()).inflate(R.layout.trend_item, this, false);
            ImageView imageView = ButterKnife.findById(view, R.id.trend_item_imageview);
            TextView textView = ButterKnife.findById(view, R.id.trend_item_textview);
            Picasso.with(getContext()).load(trendItemList.get(i).getImageResource()).into(imageView);
            textView.setText(trendItemList.get(i).getText());
            addView(view);
        }
    }
}
