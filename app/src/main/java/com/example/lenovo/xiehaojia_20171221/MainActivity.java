package com.example.lenovo.xiehaojia_20171221;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lenovo.xiehaojia_20171221.presenter.LoginActivityPresenter;
import com.example.lenovo.xiehaojia_20171221.view.LoginActivityViewListener;
import com.example.lenovo.xiehaojia_20171221.utils.Md5Utils;

import butterknife.BindView;


public class MainActivity extends AppCompatActivity implements LoginActivityViewListener {

    @BindView(R.id.main_zhangaho)
    EditText mainZhangaho;
    @BindView(R.id.mian_mima)
    EditText mianMima;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.btn_reg)
    Button btnReg;
    private EditText mZhangahoMain;
    private EditText mMimaMian;
    private LoginActivityPresenter presenter;
    private SharedPreferences sp;
    private long exitTime = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        presenter = new LoginActivityPresenter(this);
        initView();
    }

    private void initView() {
        mZhangahoMain = (EditText) findViewById(R.id.main_zhangaho);
        mMimaMian = (EditText) findViewById(R.id.mian_mima);
       // SharedPreferences.Editor editor = sp.edit();

    }

    public void main_login(View view) {
        if (mZhangahoMain != null && mMimaMian != null) {
            if (mZhangahoMain.length() != 11) {
                Toast.makeText(this, "请输入是一位手机号", Toast.LENGTH_SHORT).show();
            } else {
                MyLogin();
            }
        }
    }

    private void MyLogin() {

        presenter.login(mZhangahoMain.getText().toString().trim(), mMimaMian.getText().toString().trim());
        System.out.println(mZhangahoMain + "====" + mMimaMian);

        success(this);
    }

    public void main_zhuce(View view) {
        startActivity(new Intent(MainActivity.this, ZhuCeActivity.class));
    }

    @Override
    public void success(Object object) {
        startActivity(new Intent(MainActivity.this, HomeActivity.class));

    }

    @Override
    public void onfailed() {

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exit();
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    public void exit() {
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            Toast.makeText(getApplicationContext(), "再按一次退出程序",
                    Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
            System.exit(0);
        }
    }
}
