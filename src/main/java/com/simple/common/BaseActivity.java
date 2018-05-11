package com.simple.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class BaseActivity extends AppCompatActivity
        implements View.OnClickListener {

    protected Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(initLayout());
        initView(savedInstanceState);
        initEvent();
    }

    protected abstract int initLayout();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initEvent();

    protected void loading() {

    }

    protected void dismissLoading() {

    }

}
