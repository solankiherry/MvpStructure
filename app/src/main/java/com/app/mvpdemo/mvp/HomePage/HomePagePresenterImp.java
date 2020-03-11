package com.app.mvpdemo.mvp.HomePage;

import android.os.Handler;

import java.util.ArrayList;

public class HomePagePresenterImp {
    HomePageViewClass.onFinishLoadData onFinishLoadData;

    public HomePagePresenterImp(HomePageViewClass.onFinishLoadData onFinishLoadData) {
        this.onFinishLoadData = onFinishLoadData;
    }

    public void getData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ArrayList<String> list = new ArrayList<>();
                for (int i = 0; i < 20; i++) {
                    list.add("List Item Counter" + i);
                }
                onFinishLoadData.onFinish(list);
            }
        }, 2500);
    }
}