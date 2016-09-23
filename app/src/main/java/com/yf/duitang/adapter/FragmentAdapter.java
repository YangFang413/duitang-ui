package com.yf.duitang.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.yf.duitang.fragment.DiscoverFragment;
import com.yf.duitang.fragment.MsgFragment;
import com.yf.duitang.fragment.NewFragment;
import com.yf.duitang.fragment.PopularFragment;

/**
 * Created by Administrator on 2016/9/14.
 */
public class FragmentAdapter extends FragmentStatePagerAdapter {

    private String[] pageTitle = {"热门", "发现", "动态", "消息"};

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new PopularFragment();
            case 1:
                return new DiscoverFragment();
            case 2:
                return new NewFragment();
            case 3:
                return new MsgFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return pageTitle.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return pageTitle[position];
    }
}
