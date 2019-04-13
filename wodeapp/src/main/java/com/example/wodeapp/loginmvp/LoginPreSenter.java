package com.example.wodeapp.loginmvp;

/**
 * Time:2019/4/13
 * Author:秦超蒙
 * Description:
 */
public class LoginPreSenter implements LoginContract.IloginPresenter {
    private LoginModel loginModel;
    private LoginContract.IloginView iloginView;
    @Override
    public void attch(LoginActivity loginActivity) {
       this.iloginView=loginActivity;
        loginModel = new LoginModel();
    }

    @Override
    public void detch() {

        if(iloginView!=null){
            iloginView=null;
        }
        if(loginModel!=null){
            loginModel=null;
        }
        System.gc();

    }

    @Override
    public void login(String url, String username, String pswd) {
loginModel.getRequester(url, username, pswd, new LoginContract.IloginModel.ModelCallBack() {
    @Override
    public void onSeccess(String data) {
        iloginView.getPreDate(data);
    }

    @Override
    public void onFail() {

    }
});
    }
}
