package com.example.nideapp.loginmvp;

import com.example.nideapp.MainActivity;

/**
 * Time:2019/4/13
 * Author:秦超蒙
 * Description:
 */
public interface LoginContract {
    //view层

    interface ILoginView{
void getXinxi(String data);
    }
    //model层
    interface ILoginModel{
        void getRequest(String url,String username,String pswd, DeCallBack deCallBack);

        interface DeCallBack{
            void onSeccess(String data);
            void onFail();
        }
    }
    //p层
    interface ILoginPresenter{
void attch(MainActivity mainActivity);
void detch();
void toLogin(String url,String username,String pswd);
    }
}
