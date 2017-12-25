package com.example.lenovo.xiehaojia_20171221.utils;



import com.example.lenovo.xiehaojia_20171221.bean.ShopBean;
import com.example.lenovo.xiehaojia_20171221.bean.XiangBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;


public interface GetRequest_In {
    //https://www.zhaoapi.cn/product/searchProducts?keywords=笔记本&page=1
    @GET("searchProducts?page=1")
    Call<ShopBean> getCall(@Query("keywords") String name);

    @GET("getProductDetail")
    Observable<XiangBean> getxiang(@Query("pid") String pid, @Query("source") String str);
}
