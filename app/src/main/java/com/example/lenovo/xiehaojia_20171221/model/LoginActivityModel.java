package com.example.lenovo.xiehaojia_20171221.model;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by lenovo on 2017/12/21.
 */

public class LoginActivityModel {
    public void login(String username, String password,final LoginActivityModelListener listener) {


        OkHttpClient okHttpClient = new OkHttpClient();

        final Request request = new Request.Builder().url("http://120.27.23.105/user/login").build();

        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                listener.onfailed();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                listener.success(response.body().string());
            }
        });


    }
}
