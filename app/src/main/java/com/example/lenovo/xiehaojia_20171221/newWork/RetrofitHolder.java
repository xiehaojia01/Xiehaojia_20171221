package com.example.lenovo.xiehaojia_20171221.newWork;

/**
 * Created by lenovo on 2017/12/21.
 */

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitHolder {
    private static OkHttpClient okHttpClient;
    private static ServesApi servesApi;
    static {
        initRetrofitHolder();
    }
    private static void initRetrofitHolder(){
        if(okHttpClient==null){
            synchronized (RetrofitHolder.class){
                if(okHttpClient==null){
                    okHttpClient=new OkHttpClient.Builder().build();
                }
            }
        }
    }

    public static ServesApi getApi(){
        if(servesApi==null){
            synchronized (ServesApi.class){
                if(servesApi==null){
                    servesApi=RetrofitHolder.creatApi(ServesApi.class,UrlUtils.HOST);
                }
            }
        }
        return servesApi;
    }

    /**
     *
     * @param clazz
     * @param url
     * @param <T>
     * @return
     */
    public static <T> T creatApi(Class<T> clazz,String url){
        Retrofit retrofit = new Retrofit.Builder().baseUrl(UrlUtils.HOST)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(clazz);
    }
}