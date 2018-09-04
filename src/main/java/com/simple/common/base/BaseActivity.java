package com.simple.common.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public abstract class BaseActivity extends AppCompatActivity
        implements View.OnClickListener {

    protected Context mContext;
    public static List<Activity> mActivitys = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        mActivitys.add(this);
        setContentView(initLayout());
        initView(savedInstanceState);
        initEvent();
    }

    protected abstract int initLayout();

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract void initEvent();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mActivitys.remove(this);
    }

    public static void exit() {
        for (Activity activity : mActivitys) {
            if (activity == null || activity.isFinishing()) return;
            activity.finish();
        }
    }
}
