package com.yf.duitang.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.origamilabs.library.views.StaggeredGridView;
import com.yf.duitang.R;
import com.yf.duitang.adapter.StaggeredGridViewAdapter;
import com.yf.duitang.model.StaggeredGridViewItem;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private Handler handler;

    @Bind(R.id.staggeredgridview_new)
    StaggeredGridView staggeredGridView;

    @Bind(R.id.swiperefreshlayout_new)
    SwipeRefreshLayout swipeRefreshLayout;

    private List<StaggeredGridViewItem> itemList;

    private String[] imageDescriptions = {"萤火之森", "龙族--我们都是小怪兽，终有一天会被正义的奥特曼杀死",
            "废物利用", "不一样的剪纸", "微型休憩空间", "#壁纸#",
            "简笔画分享", "创意生活", "英伦风", "机智的立夏在学习蹭WiFi"};
    private int[] imageResources = {R.drawable.pic0, R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
            R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7,
            R.drawable.pic8, R.drawable.pic9};
    private int[] userImageResources = {R.drawable.thumb0, R.drawable.thumb1,
            R.drawable.thumb2, R.drawable.thumb3, R.drawable.thumb4};
    private String[] userNames = {"默念那曾时", "来自原始森林的帝企鹅", "年华逝水", "荒年信徒", "红秀",
            "水若印心", "千离", "乖兽", "我不是Candy", "千年老妖"};
    private String[] collectionNames = {"超轻粘土", "龙族", "大白", "文字控", "虫不知",
            "布纸喜欢你", "百味美食堂", "备忘录的秘密", "吃吃吃", "插画那些事"};

    public NewFragment(){
        initListData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_new, container, false);
        ButterKnife.bind(this, view);
        handler = new Handler();
        initData();
        return view;
    }

    private void initListData(){
        itemList = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            StaggeredGridViewItem item = new StaggeredGridViewItem();
            item.setImageDescription(imageDescriptions[9 - i]);
            item.setImageResource(imageResources[9 - i]);
            item.setUserImageResource(userImageResources[i % 5]);
            item.setCollectionName(collectionNames[9 - i]);
            item.setUserName(userNames[9 - i]);
            item.setCollectionNumber((int)(Math.random() * 200));
            itemList.add(item);
        }
    }

    private void initData(){
        swipeRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.blue));
        swipeRefreshLayout.setOnRefreshListener(this);

        StaggeredGridViewAdapter adapter = new StaggeredGridViewAdapter(getContext(),
                R.layout.staggeredgridview_item, itemList);
        staggeredGridView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        staggeredGridView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_MOVE:
                        swipeRefreshLayout.setEnabled(false);
                        break;
                    case MotionEvent.ACTION_UP:
                        swipeRefreshLayout.setEnabled(false);
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        swipeRefreshLayout.setEnabled(true);
                        break;
                    case MotionEvent.ACTION_DOWN:
                        swipeRefreshLayout.setEnabled(true);
                        break;
                }
                return false;
            }
        });

    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
                Toast.makeText(getActivity(), "刷新成功", Toast.LENGTH_LONG).show();
            }
        }, 3000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacksAndMessages(null);
    }
    
}
