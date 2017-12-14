package com.wmg.ddd.dotdy.view;

import android.app.Fragment;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.wmg.ddd.dotdy.R;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by 明光 on 2017/10/16.
 */

public class DataFragment extends AbstractFragment {
    @BindView(R.id.tab_data)
    TabLayout vTabs;
    @BindView(R.id.vp_data)
    ViewPager vViewPager;

    @Override
    protected int setResourceLayout() {
        return R.layout.fragment_data;
    }

    @Override
    protected void initViewValues() {

    }

    @Override
    protected void doOnData() {

    }

    @Override
    protected void lazyLoad() {

    }

    @OnClick(R.id.iv_add)
    public void clickOnAddFragment(View view){
        AddDataTypeActivity.start(getContext());
    }
}
