package com.example.lenovo.xiehaojia_20171221.view;

import com.example.lenovo.xiehaojia_20171221.bean.CartBean;

import java.util.List;

/**
 * Created by lenovo on 2017/12/21.
 */


public interface IMainActivity {
    public void show(List<CartBean.DataBean> grouplist, List<List<CartBean.DataBean.ListBean>> childlist);
}