package com.example.lianxi.contract;

/**
 * Time:2019/4/13
 * Author:秦超蒙
 * Description:
 */
public interface ContractInteface {

    //view层
    public interface ProductInteface{
        public void ShowDisplay(Object obj);
    }

    //P层
    public interface PresenterInteface{
        public void toProduct();
    }
}
