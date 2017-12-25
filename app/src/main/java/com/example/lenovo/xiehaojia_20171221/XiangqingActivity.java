package com.example.lenovo.xiehaojia_20171221;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/12/14.
 */

public class XiangqingActivity extends AppCompatActivity {

    @BindView(R.id.gwc)
    Button gwc;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_xiangqing);
        ButterKnife.bind(this);

    }


    @OnClick(R.id.gwc)
    public void onClick() {
        startActivity(new Intent(XiangqingActivity.this, CarActivity.class));

    }
}
