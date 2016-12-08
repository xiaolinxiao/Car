package com.lx.car.car;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class PreciseWarrantyActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_precise_warranty);
        initView();
    }

    private void initView() {
        TextView text_title = (TextView) findViewById(R.id.text_toptitle);
        text_title.setText("精确保修");
        RelativeLayout rl_faulttype = (RelativeLayout) findViewById(R.id.precise_rl_faulttype);
        rl_faulttype.setOnClickListener(this);
        RelativeLayout rl_location = (RelativeLayout) findViewById(R.id.precise_rl_location);
        rl_location.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_precise_warranty, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.precise_rl_faulttype:
                startActivity(new Intent(this, FaultTypeActivity.class));
                break;
            case R.id.precise_rl_location:
                startActivity(new Intent(this,LocationActivity.class));
                break;
        }

    }
}
