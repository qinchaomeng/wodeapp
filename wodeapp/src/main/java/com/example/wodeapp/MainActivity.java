package com.example.wodeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.wodeapp.adapter.HomeAdapter;
import com.example.wodeapp.bean.HomeBean;
import com.example.wodeapp.homemvp.Contract;
import com.example.wodeapp.homemvp.HomePreSenter;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract.ILoginView{
    private HomePreSenter loginPreSenter;
    private ListView list_view;
    private Gson gson;
    private HomeBean homeBean;
    private List<HomeBean.ResultBean> homeBeanResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        loginPreSenter=new HomePreSenter();
        loginPreSenter.attch(this);
    }

    private void init() {

        list_view = findViewById(R.id.list_view);

    }

    @Override
    public void getPresenter(String name) {
        gson = new Gson();
        homeBean = gson.fromJson(name, HomeBean.class);
        homeBeanResult = homeBean.getResult();
        list_view.setAdapter(new HomeAdapter(this,homeBeanResult));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPreSenter.detch();
    }
}
