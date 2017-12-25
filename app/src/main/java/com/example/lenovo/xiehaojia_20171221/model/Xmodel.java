package com.example.lenovo.xiehaojia_20171221.model;

import rx.Observer;

public  interface Xmodel {
    //将观察者传（bean）进去
    public void getXData(String goods_id, Observer observer);
}