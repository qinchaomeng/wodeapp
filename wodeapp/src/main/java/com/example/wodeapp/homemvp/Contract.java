package com.example.wodeapp.homemvp;

/**
 * Time:2019/4/13
 * Author:秦超蒙
 * Description:
 */
public interface Contract {

    //view层接口   Iview
    public interface ILoginView {
        // 获取数据方法
        void getPresenter(String name);
    }

    //model等接口   Imodel
    public interface ILoginModel {
        //业务数据处理， 数据库，网络数据
        /**
         * 1.定义接口
         *
         */
        void  login(ILoginModel.CallBack callBack);

        interface CallBack{
            //成功返回
            void  onSuccess(String names);
            //失败返回
            void  onFail();
        }
    }
    //p层接口    Ipresenter
    public interface ILoginPresenter {
        /*
         * presenter 提供view与model 交互的纽带
         * */
        //
        void  getModel();
        //绑定
        void  attch(ILoginView view);
        //解绑
        void  detch();

    }



}
