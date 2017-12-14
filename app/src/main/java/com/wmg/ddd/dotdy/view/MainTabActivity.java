package com.wmg.ddd.dotdy.view;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.wmg.ddd.dotdy.R;
import com.wmg.ddd.dotdy.view.adapter.MainTabPagerAdapter;
import com.wmg.ddd.dotdy.widget.NoScrollViewPager;

import butterknife.BindView;

/**
 * Created by 明光 on 2017/10/16.
 */

public class MainTabActivity extends AbstractActivity {
    @BindView(R.id.vp_main)
    NoScrollViewPager vViewPager;
    @BindView(R.id.tab_main)
    TabLayout vTabs;

    private MainTabPagerAdapter mAdapter;

    @Override
    protected int setResourceLayout() {
        return R.layout.activity_main_tab;
    }

    @Override
    protected void initViewValues() {
        mAdapter = new MainTabPagerAdapter(getSupportFragmentManager());
        mAdapter.setContext(this);
        vViewPager.setNoScroll(true);
        vViewPager.setAdapter(mAdapter);
        vTabs.setupWithViewPager(vViewPager);

        int tabCount = vTabs.getTabCount();
        for(int i= 0; i< tabCount; i++){
            vTabs.getTabAt(i).setCustomView(mAdapter.getTabView(i));
        }
    }
}
