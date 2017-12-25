package com.example.lenovo.xiehaojia_20171221;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

public class CustomView extends LinearLayout{
    public CustomView(Context context) {
        super(context);
    }

    public CustomView(final Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        View view = LayoutInflater.from(context).inflate(R.layout.custom_layout,null);
        addView(view);
        Button jian = (Button) view.findViewById(R.id.jian);
        Button jia = (Button) view.findViewById(R.id.jia);
        final EditText num = (EditText) view.findViewById(R.id.num);
        //减号
        jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = num.getText().toString().trim();
                int integerResult = Integer.valueOf(result);
                //给做个限制
                if(integerResult > 1){
                    integerResult = integerResult - 1;
                    num.setText(integerResult + "");
                }else{
                    Toast.makeText(context, "最小数量为1", Toast.LENGTH_SHORT).show();
                }
                if(listener != null){
                    listener.onChange(integerResult);
                }
            }
        });
        //加号
        jia.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String result = num.getText().toString().trim();
                int integerResult = Integer.valueOf(result);
                if(integerResult < 10000){
                    integerResult = integerResult + 1;
                    num.setText(integerResult +"");
                }else{
                    Toast.makeText(context, "已经超出最大值", Toast.LENGTH_SHORT).show();
                }
                if(listener != null ){
                    listener.onChange(integerResult);
                }
            }
        });

        num.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.i("beforeTextChanged",s+"-----"+start+"-------"+count+"-----"+after);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("onTextChanged",s+"-----"+start+"-------"+before+"-----"+count);

            }

            @Override
            public void afterTextChanged(Editable s) {
                if(listener != null ){
                    listener.onChange(Long.valueOf(s.toString()));
                }
            }
        });
    }

    public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ChangeListener listener;
    public void setListener(ChangeListener listener){
        this.listener = listener;
    }
    public interface ChangeListener{
        public void onChange(long count);
    }
}