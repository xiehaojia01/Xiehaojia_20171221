package com.example.lenovo.xiehaojia_20171221;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.lenovo.xiehaojia_20171221.MyEvenBus.MessageEvent;
import com.example.lenovo.xiehaojia_20171221.MyEvenBus.PriceAndCountEvent;
import com.example.lenovo.xiehaojia_20171221.adapter.UserAdapter;
import com.example.lenovo.xiehaojia_20171221.bean.CartBean;
import com.example.lenovo.xiehaojia_20171221.presenter.ShowPrenester;
import com.example.lenovo.xiehaojia_20171221.view.IMainActivity;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class CarActivity extends AppCompatActivity implements IMainActivity {


    @BindView(R.id.elv)
    ExpandableListView elv;
    @BindView(R.id.checkbox2)
    CheckBox checkbox2;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_num)
    TextView tvNum;

    private ExpandableListView mElv;
    private CheckBox mCheckbox2;
    private TextView mTvPrice;
    private TextView mTvNum;
    private UserAdapter userAdapter;
    private ShowPrenester showPrenester;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
        initView();
        showPrenester = new ShowPrenester(CarActivity.this);
        showPrenester.getshow();
        mCheckbox2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userAdapter.changeAllListCbState(mCheckbox2.isChecked());
            }
        });
    }

    @Override
    public void show(List<CartBean.DataBean> grouplist, List<List<CartBean.DataBean.ListBean>> childlist) {
        userAdapter = new UserAdapter(this, grouplist, childlist);
        mElv.setAdapter(userAdapter);
        mElv.setGroupIndicator(null);
        //默认让其全部展开
        for (int i = 0; i < grouplist.size(); i++) {
            mElv.expandGroup(i);
        }

    }

    private void initView() {
        mElv = (ExpandableListView) findViewById(R.id.elv);
        mCheckbox2 = (CheckBox) findViewById(R.id.checkbox2);
        mTvPrice = (TextView) findViewById(R.id.tv_price);
        mTvNum = (TextView) findViewById(R.id.tv_num);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
        showPrenester.detach();
    }

    @Subscribe
    public void onMessageEvent(MessageEvent event) {
        mCheckbox2.setChecked(event.isChecked());
    }


    @Subscribe
    public void onMessageEvent(PriceAndCountEvent event) {
        mTvNum.setText("去支付(" + event.getCount() + ")");
        mTvPrice.setText(event.getPrice() + "");
    }
}