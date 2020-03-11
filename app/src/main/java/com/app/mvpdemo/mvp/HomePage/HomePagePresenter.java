package com.app.mvpdemo.mvp.HomePage;

import java.util.ArrayList;

public class HomePagePresenter implements HomePageViewClass.onFinishLoadData {
    HomePageViewClass.HomePageView homePageView;
    HomePagePresenterImp homePagePresenterImp;

    public HomePagePresenter(HomePageViewClass.HomePageView homePageView) {
        this.homePageView = homePageView;
        homePagePresenterImp = new HomePagePresenterImp(this);
    }

    public void onLoadListData() {
        homePageView.showProgressDialog();
        homePagePresenterImp.getData();
    }

    @Override
    public void onFinish(ArrayList<String> list) {
        homePageView.hideProgressDialog();
        homePageView.onLoadDataFinish(list);
    }
}