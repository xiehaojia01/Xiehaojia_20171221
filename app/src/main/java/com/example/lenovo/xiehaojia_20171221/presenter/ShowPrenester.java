package com.example.lenovo.xiehaojia_20171221.presenter;

import com.example.lenovo.xiehaojia_20171221.bean.CartBean;
import com.example.lenovo.xiehaojia_20171221.model.ShowModel;
import com.example.lenovo.xiehaojia_20171221.newWork.IDataInter;
import com.example.lenovo.xiehaojia_20171221.newWork.OnNetListine;
import com.example.lenovo.xiehaojia_20171221.view.IMainActivity;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2017/12/21.
 */

public class ShowPrenester implements IDataInter<IMainActivity> {

    ShowModel showModel;
    private SoftReference<IMainActivity> softReference;

    public ShowPrenester(IMainActivity iMainActivity) {
        attach(iMainActivity);
        showModel = new ShowModel();
    }

    public void getshow() {
        showModel.getshow(new OnNetListine<CartBean>() {
            @Override
            public void OnSucc(CartBean cartBean) {
                List<CartBean.DataBean> data = cartBean.getData();
                List<List<CartBean.DataBean.ListBean>> childlist = new ArrayList<List<CartBean.DataBean.ListBean>>();
                for (int i = 0; i < data.size(); i++) {
                    List<CartBean.DataBean.ListBean> list = data.get(i).getList();
                    childlist.add(list);
                }
                softReference.get().show(data, childlist);
            }

            @Override
            public void OnFile(String str) {

            }
        });
    }

    @Override
    public void attach(IMainActivity view) {
        softReference = new SoftReference<IMainActivity>(view);
    }

    @Override
    public void detach() {
        softReference.clear();
    }
}
