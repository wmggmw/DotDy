package com.wmg.ddd.dotdy.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.wmg.ddd.dotdy.R;
import com.wmg.ddd.dotdy.view.CommunityFragment;
import com.wmg.ddd.dotdy.view.DataFragment;
import com.wmg.ddd.dotdy.view.MeFragment;
import com.wmg.ddd.dotdy.view.StatisticsFragment;

/**
 * Created by 明光 on 2017/10/16.
 */

public class MainTabPagerAdapter extends FragmentPagerAdapter {
    private int PAGE_COUNT = 4;
    private Context mContext;

    public MainTabPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void setContext(Context context){
        this.mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        if( position < PAGE_COUNT){
            switch (position){
                case 0:
                    return new DataFragment();
                case 1:
                    return new StatisticsFragment();
                case 2:
                    return new CommunityFragment();
                case 3:
                    return new MeFragment();
                default:
                    return new MeFragment();
            }
        } else {
            try {
                throw new Exception("");
            } catch (Exception e) {
                e.printStackTrace();
            }
            return new DataFragment();
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if( mContext != null) {
            String[] tabArray = mContext.getResources().getStringArray(R.array.array_main_tab);
            if( tabArray != null && position < tabArray.length){
                return tabArray[position];
            } else {
                return "unknown";
            }
        } else {
            switch (position) {
                case 0:
                    return "unknown";
                case 1:
                    return "unknown";
                case 2:
                    return "unknown";
                default:
                    return "unknown";
            }
        }
    }

    public View getTabView(int position){
        if( mContext != null){
            View view = LayoutInflater.from(mContext).inflate(R.layout.layout_main_tab, null);
            TextView tv = (TextView)view.findViewById(R.id.tv_tab);
            String[] tabArray = mContext.getResources().getStringArray(R.array.array_main_tab);
            if( tabArray != null && position < tabArray.length){
                tv.setText(tabArray[position]);
            }
            return view;
        } else {
            return null;
        }

    }
}
