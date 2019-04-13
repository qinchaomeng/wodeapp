package com.bwie.mvpdome.loginmvp;

/**
 * @Auther: lenovo
 * @Date: 2019/4/12
 * @Description:
 */
public interface Contract {
    //Iview
    public interface ILoginView{
        //获取数据方法
        void getPresenter(String name);
    }
    //Imodel
    public interface ILoginModel{
        void login(ILoginModel.CallBack callBack);
        interface CallBack{
            //成功返回
            void onSuccess(String names);
            //失败返回
            void onFail();
        }
    }
    //Ipresenter
    public interface ILoginPresenter{
        void getModel();
        //绑定
        void attch(ILoginView view);
        //解绑
        void detch();
    }
}
