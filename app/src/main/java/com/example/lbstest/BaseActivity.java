package com.example.lbstest;

import android.app.Activity;
import android.os.Bundle;

import com.baidu.mapapi.SDKInitializer;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Viktor on 2018/1/16.
 */

public abstract class BaseActivity extends Activity {
    public abstract int getContentViewId();
    private Unbinder unbinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext()); //放在ManinActivity里写会报错
        setContentView(getContentViewId());
        unbinder = ButterKnife.bind(this);
        initAllMembersView(savedInstanceState);

        /*new Thread(new Runnable() {
            @Override
            public void run() {

            }
        }).start();*/
        System.out.println("id: "+getTaskId());
    }

    protected abstract void initAllMembersView(Bundle savedInstanceState);

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unbinder.unbind();// 解除绑定，官方文档只对 fragment 做了解绑
    }

}
