package com.example.jerry.module_outsale.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.jerry.comment_data.d_arouter.RouterURLS;
import com.example.jerry.module_outsale.R;

@Route(path = RouterURLS.MALL_MAIN)
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mall_activity_main);
    }
}
