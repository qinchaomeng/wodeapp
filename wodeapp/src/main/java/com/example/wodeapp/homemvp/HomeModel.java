package com.example.wodeapp.homemvp;

import com.example.wodeapp.net.AsyncHttpClient;

/**
 * Time:2019/4/13
 * Author:秦超蒙
 * Description:
 */
public class HomeModel implements Contract.ILoginModel{
    public static final String BaseUrl="http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas?page=1&count=10";

    @Override
    public void login(final Contract.ILoginModel.CallBack callBack) {
        AsyncHttpClient.getInstance().GetAsync(BaseUrl, new AsyncHttpClient.AsyncCallback() {
            @Override
            public void Error(int errorcode, String message) {

            }

            @Override
            public void Succorce(String result) {
callBack.onSuccess(result);
            }
        });

    }
}
