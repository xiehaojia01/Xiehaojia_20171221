package com.example.lenovo.xiehaojia_20171221.presenter;

import com.example.lenovo.xiehaojia_20171221.model.LoginActivityModel;
import com.example.lenovo.xiehaojia_20171221.model.LoginActivityModelListener;
import com.example.lenovo.xiehaojia_20171221.view.LoginActivityViewListener;

/**
 * Created by lenovo on 2017/12/21.
 */

public class RegActivityPresenter {

    private LoginActivityViewListener listener ;
    private LoginActivityModel model;
    public RegActivityPresenter(LoginActivityViewListener loginActivityViewListener){

        this.listener = loginActivityViewListener;
        this.model = new LoginActivityModel();

    }

    public void login(String username,String password){

        // 空判断 合法性
        model.login(username, password, new LoginActivityModelListener() {
            @Override
            public void success(Object object) {
                listener.success(object);
            }

            @Override
            public void onfailed() {
                listener.onfailed();
            }
        });


    }
}
