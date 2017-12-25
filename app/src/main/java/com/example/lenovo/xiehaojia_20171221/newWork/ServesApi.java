package com.example.lenovo.xiehaojia_20171221.newWork;

import com.example.lenovo.xiehaojia_20171221.bean.CartBean;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by lenovo on 2017/12/21.
 */


public interface ServesApi {
    //查询购物车
    @GET(UrlUtils.TAG)
    Flowable<CartBean> tags(@Query("source") String str);

    //删除购物车
    @GET(UrlUtils.DELETE)
    Flowable<CartBean> delete();

    //更新购物车购物车
    @GET(UrlUtils.GEN)
    Flowable<CartBean> GEN();
}