package com.example.lenovo.xiehaojia_20171221.model;

import com.example.lenovo.xiehaojia_20171221.bean.CartBean;
import com.example.lenovo.xiehaojia_20171221.newWork.OnNetListine;
import com.example.lenovo.xiehaojia_20171221.newWork.RetrofitHolder;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by lenovo on 2017/12/21.
 */

public class ShowModel {
    public void getshow(final OnNetListine<CartBean> onNetListine){
        RetrofitHolder.getApi().tags("android")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<CartBean>() {
                    @Override
                    public void accept(CartBean cartBean) throws Exception {
                        onNetListine.OnSucc(cartBean);
                    }
                });
    }
}
