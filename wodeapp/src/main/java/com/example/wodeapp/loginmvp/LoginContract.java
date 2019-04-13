package com.example.wodeapp.loginmvp;

/**
 * Time:2019/4/13
 * Author:秦超蒙
 * Description:
 */
public interface LoginContract {
    //view层接口   Iview
    interface  IloginView{
        void  getPreDate(String data);

    }

    // model层接口   Imodel
    interface  IloginModel{
        void  getRequester(String url,String username,String pswd,ModelCallBack modelCallBack);
        interface ModelCallBack{
            void onSeccess(String data);
            void onFail();

        }

    }
    //p层接口    Ipresenter
    interface   IloginPresenter{
        void  attch(LoginActivity loginActivity);
        void  detch();
        void  login(String url,String username,String pswd);

    }
}
