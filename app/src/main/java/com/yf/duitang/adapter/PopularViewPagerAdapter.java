package com.yf.duitang.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.yf.duitang.R;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016/9/20.
 */

public class PopularViewPagerAdapter extends PagerAdapter implements ViewPager.OnPageChangeListener{

    private Context context;

    private LinearLayout potLayout;
    private int lastposition;


    private int[] imageResourceIds = {R.drawable.top1, R.drawable.top2, R.drawable.top3, R.drawable.top4};
    private String[] imageTimes = {"9月20日 周二", "9月30日 周五", "10月1日 周六", "9月15日 周四"};
    private String[] imageTitles = {"我所经历的生活", "橡皮擦初心", "一只喵的幸福生活", "手绘电影场景"};

    public PopularViewPagerAdapter(Context context){
        this.context = context;
    }

    @Override
    public int getCount() {
        return imageResourceIds.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewpager_item, container, false);
        container.addView(view);
        ImageView imageView = ButterKnife.findById(view, R.id.viewpager_image);
        TextView imageTitle = ButterKnife.findById(view, R.id.image_title);
        TextView imageTime = ButterKnife.findById(view, R.id.image_time);
        potLayout = ButterKnife.findById(view, R.id.pot);
        setLinearLayout(position);
        imageView.setImageResource(imageResourceIds[position]);
        imageTitle.setText(imageTitles[position]);
        imageTime.setText(imageTimes[position]);
        return view;
    }

    private void setLinearLayout(int position){
        for (int i = 0; i < imageResourceIds.length; i++){
            ImageView point = new ImageView(context); // 设置指示点
            //配置参数信息
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.rightMargin = 20;
            params.bottomMargin = 20;
            //指示点添加参数
            point.setLayoutParams(params);
            //设置指示点图片
            point.setBackgroundResource(R.drawable.point);
            //设定第一个为白色，其他为灰色
            if(i == position){
                point.setEnabled(false);
            }else{
                point.setEnabled(true);
            }
            potLayout.addView(point);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        potLayout.getChildAt(position).setEnabled(false);
        potLayout.getChildAt(lastposition).setEnabled(true);
        lastposition = position;
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
