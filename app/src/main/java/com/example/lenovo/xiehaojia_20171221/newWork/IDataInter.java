package com.example.lenovo.xiehaojia_20171221.newWork;

import com.example.lenovo.xiehaojia_20171221.view.IMainActivity;

/**
 * Created by lenovo on 2017/12/21.
 */

//P层解绑
public interface IDataInter<T extends IMainActivity> {
    void attach(T view);
    void detach();
}