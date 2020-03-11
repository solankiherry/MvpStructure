package com.app.mvpdemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.app.mvpdemo.mvp.HomePage.HomePagePresenter;
import com.app.mvpdemo.mvp.HomePage.HomePageViewClass;
import com.app.mvpdemo.mvp.HomePage.ListAdapter;

import java.util.ArrayList;

public class HomePageActivity extends AppCompatActivity implements HomePageViewClass.HomePageView {
    RecyclerView rcList;
    HomePagePresenter presenter;
    ProgressDialog dialog;
    ListAdapter adapter;
    ArrayList<String> list = new ArrayList<>();
    SwipeRefreshLayout swipeLayoput;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage_layout);

        rcList = findViewById(R.id.rcList);
        swipeLayoput = findViewById(R.id.swipeLayoput);
        rcList.setLayoutManager(new LinearLayoutManager(this));

        dialog = new ProgressDialog(this);
        dialog.setTitle("Please wait...");
        presenter = new HomePagePresenter(this);

        adapter = new ListAdapter(list, new ListAdapter.Listener() {
            @Override
            public void onItemClicked(String item) {
                Toast.makeText(HomePageActivity.this, "" + item, Toast.LENGTH_SHORT).show();
            }
        });
        rcList.setAdapter(adapter);

        presenter.onLoadListData();

        swipeLayoput.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.onLoadListData();
            }
        });
    }

    @Override
    public void showProgressDialog() {
        if (!dialog.isShowing())
            dialog.show();
    }

    @Override
    public void hideProgressDialog() {
        if (dialog.isShowing())
            dialog.dismiss();
    }

    @Override
    public void onLoadDataFinish(ArrayList<String> listData) {
        this.list.addAll(listData);
        adapter.notifyDataSetChanged();
    }
}