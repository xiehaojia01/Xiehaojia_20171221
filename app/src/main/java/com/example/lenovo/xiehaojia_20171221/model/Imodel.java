package com.example.lenovo.xiehaojia_20171221.model;

/**
 * Created by lenovo on 2017/12/13.
 */


import com.example.lenovo.xiehaojia_20171221.bean.ShopBean;

import rx.Observer;

public  interface Imodel {
    //将观察者传（bean）进去
    public void shuju(Observer<ShopBean> observer, String name);
}