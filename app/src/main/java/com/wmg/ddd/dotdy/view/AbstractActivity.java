package com.wmg.ddd.dotdy.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import butterknife.ButterKnife;

/**
 * Created by 明光 on 2017/10/14.
 */

public abstract class AbstractActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setResourceLayout());
        ButterKnife.bind(this);
        initViewValues();
    }

    @LayoutRes
    protected abstract int setResourceLayout();

    protected abstract void initViewValues();
}
