package com.bwie.mvpdome;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.bwie.mvpdome.adapter.HomeAdapter;
import com.bwie.mvpdome.bean.HomeBean;
import com.bwie.mvpdome.loginmvp.Contract;
import com.bwie.mvpdome.loginmvp.LoginPreSenter;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Contract.ILoginView {
    private LoginPreSenter loginPreSenter;
    private RequestQueue requestQueue;
    private Gson gson;
    private HomeBean homeBean;
    private ListView mlistview;
    private List<HomeBean.ResultBean> homeBeanResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestQueue = Volley.newRequestQueue(this);
        init();
        //初始化presenter
        loginPreSenter = new LoginPreSenter();
        loginPreSenter.attch(this);
    }
    private void init(){
        mlistview = findViewById(R.id.home_lv);

    }

    @Override
    public void getPresenter(String name) {
        //buttonLogin.setText(name);
        gson=new Gson();
        homeBean=gson.fromJson(name,HomeBean.class);
        homeBeanResult=homeBean.getResult();
        mlistview.setAdapter(new HomeAdapter(this,homeBeanResult));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loginPreSenter.detch();
    }
}
