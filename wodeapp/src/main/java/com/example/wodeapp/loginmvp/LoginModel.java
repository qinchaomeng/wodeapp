package com.example.wodeapp.loginmvp;

import com.example.wodeapp.net.AsyncHttpClient;

/**
 * Time:2019/4/13
 * Author:秦超蒙
 * Description:
 */
public class LoginModel implements LoginContract.IloginModel {

    @Override
    public void getRequester(String url, String username, String pswd, final ModelCallBack modelCallBack) {
        AsyncHttpClient.getInstance().PostAsync(url, username, pswd, new AsyncHttpClient.AsyncCallback() {
            @Override
            public void Error(int errorcode, String message) {

            }

            @Override
            public void Succorce(String result) {
            modelCallBack.onSeccess(result);
            }
        });
    }
}
