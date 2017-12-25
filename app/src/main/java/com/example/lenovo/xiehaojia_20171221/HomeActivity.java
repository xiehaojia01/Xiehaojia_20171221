package com.example.lenovo.xiehaojia_20171221;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lenovo.xiehaojia_20171221.adapter.Myadapter;
import com.example.lenovo.xiehaojia_20171221.bean.ShopBean;
import com.example.lenovo.xiehaojia_20171221.presenter.LoginActivityPresenter;
import com.example.lenovo.xiehaojia_20171221.presenter.Persenter;
import com.example.lenovo.xiehaojia_20171221.view.Iview;
import com.example.lenovo.xiehaojia_20171221.view.LoginActivityViewListener;
import com.facebook.drawee.backends.pipeline.Fresco;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by lenovo on 2017/12/21.
 */

public class HomeActivity extends AppCompatActivity implements Iview {

    @BindView(R.id.xrv)
    RecyclerView rv;
    Persenter pp;
    Myadapter rvadapter;
    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.ll1)
    LinearLayout ll1;
    @BindView(R.id.et)
    EditText et;
    @BindView(R.id.ll2)
    LinearLayout ll2;
    List<ShopBean.DataBean> listtj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fresco.initialize(this);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        pp = new Persenter(this, this);
        listtj=new ArrayList<>();
    }

    @Override
    public void ShowView(ShopBean bean) {
        listtj=bean.getData();
        LinearLayoutManager manager = new LinearLayoutManager(this);
        rv.setLayoutManager(manager);
        rv.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));

        rvadapter = new Myadapter(this, bean);
        rv.setAdapter(rvadapter);
        rvadapter.setOnItemClickListener(new Myadapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
//                Intent intent = new Intent(HomeActivity.this, XiangqingActivity.class);
//                intent.putExtra("pid", listtj.get(position).getPid()+"");
//                startActivity(intent);
                startActivity(new Intent(HomeActivity.this, XiangqingActivity.class));
            }
        });
    }

    @OnClick(R.id.btn)
    public void onClick() {
        String s = et.getText().toString();
        if(!TextUtils.isEmpty(s)){
            pp.getData(s);
        }else{
            Toast.makeText(this, "请输入内容", Toast.LENGTH_SHORT).show();
        }
    }
}