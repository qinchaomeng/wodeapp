package com.example.lianxi.m;

import android.util.Log;

import com.example.lianxi.bean.HomeBean;
import com.example.lianxi.util.HttpUtil;
import com.google.gson.Gson;

/**
 * Time:2019/4/13
 * Author:秦超蒙
 * Description:
 */
public class MyModel {

    public void getRequest(final HttpUtil.MyCallBack myCallBack){
        HttpUtil.MyTask("http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas?page=1&count=10", new HttpUtil.MyCallBack() {
            @Override
            public void getData(String str) {
              myCallBack.getData(str);
                Gson gson=new Gson();
                HomeBean homeBean = gson.fromJson(str, HomeBean.class);
            }
        });

    }
}
