package com.example.nideapp.loginmvp;

import com.example.nideapp.util.AsyncHttpClient;

/**
 * Time:2019/4/13
 * Author:秦超蒙
 * Description:
 */
public class LoginModel implements LoginContract.ILoginModel {
    @Override
    public void getRequest(String url, String username, String pswd, final DeCallBack deCallBack) {
        AsyncHttpClient.getOurInstance().postAsync(url, username, pswd, new AsyncHttpClient.AsyncCallBack() {
            @Override
            public void success(String result) {
deCallBack.onSeccess(result);
            }

            @Override
            public void error(int errorcode, String message) {

            }
        });
    }
}
