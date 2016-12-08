package com.lx.car.car;

import android.os.Bundle;
import android.widget.TextView;


public class CarDetaliActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_detali);
        initView();
    }

    private void initView() {
        TextView text_title = (TextView) findViewById(R.id.text_toptitle);
        text_title.setText("车辆详情");
    }
}
