package com.app.mvpdemo.mvp.HomePage;

import java.util.ArrayList;

public class HomePageViewClass {
    public interface HomePageView {
        void showProgressDialog();

        void hideProgressDialog();

        void onLoadDataFinish(ArrayList<String> list);
    }

    interface onFinishLoadData {
        void onFinish(ArrayList<String> list);
    }
}