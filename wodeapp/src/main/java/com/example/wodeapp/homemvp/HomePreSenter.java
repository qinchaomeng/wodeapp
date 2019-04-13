package com.example.wodeapp.homemvp;

/**
 * Time:2019/4/13
 * Author:秦超蒙
 * Description:
 */
public class HomePreSenter implements Contract.ILoginPresenter {
    public static final String TAG="HomePreSenter";
    private HomeModel loginModel;
    private Contract.ILoginView view;
    @Override
    public void getModel() {

    }

    @Override
    public void attch(final Contract.ILoginView view) {
        //初始化model
        loginModel = new HomeModel();
        this.view=view;
        loginModel.login(new Contract.ILoginModel.CallBack() {
            @Override
            public void onSuccess(String names) {
                view.getPresenter(names);
            }

            @Override
            public void onFail() {

            }
        });
    }

    @Override
    public void detch() {
        if (view!=null){
            view=null;
        }
        if (loginModel!=null){
            loginModel=null;
        }
        //防止内存溢出
        System.gc();
    }
}
