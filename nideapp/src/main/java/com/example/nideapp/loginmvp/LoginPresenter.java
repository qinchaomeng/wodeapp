package com.example.nideapp.loginmvp;

import com.example.nideapp.MainActivity;

/**
 * Time:2019/4/13
 * Author:秦超蒙
 * Description:
 */
public class LoginPresenter implements LoginContract.ILoginPresenter{
    private LoginModel loginModel;
    private LoginContract.ILoginView iLoginView;

    @Override
    public void attch(MainActivity mainActivity) {
this.iLoginView=mainActivity;
loginModel=new LoginModel();
    }

    @Override
    public void detch() {

        if (iLoginView!=null){
            iLoginView=null;
        }
        if (loginModel!=null){
            loginModel=null;
        }
        System.gc();
    }

    @Override
    public void toLogin(String url, String username, String pswd) {
loginModel.getRequest(url, username, pswd, new LoginContract.ILoginModel.DeCallBack() {
    @Override
    public void onSeccess(String data) {
        iLoginView.getXinxi(data);
    }

    @Override
    public void onFail() {

    }
});
    }
}
