package com.example.lenovo.xiehaojia_20171221;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.xiehaojia_20171221.view.RegActivityViewListener;

import butterknife.BindView;


public class ZhuCeActivity extends AppCompatActivity implements RegActivityViewListener {
    @BindView(R.id.main_zhangaho)
    EditText mainZhangaho;
    @BindView(R.id.mian_mima)
    EditText mianMima;
    @BindView(R.id.btn_reg)
    Button btnReg;
    private EditText mZhangahoMain;
    private EditText mMimaMian;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhuce);
        initView();

    }

    private void initView() {
        mZhangahoMain = (EditText) findViewById(R.id.main_zhangaho);
        mMimaMian = (EditText) findViewById(R.id.mian_mima);
    }

    public void main_zhuce(View view) {
        if (mMimaMian != null && mZhangahoMain != null) {
            if (mZhangahoMain.length() == 11) {

                success(this);
            } else {
                Toast.makeText(this, "请输入11为手机号", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "不能为空", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public void success(Object object) {
        startActivity(new Intent(ZhuCeActivity.this, MainActivity.class));
    }

    @Override
    public void onfailed() {

    }
}