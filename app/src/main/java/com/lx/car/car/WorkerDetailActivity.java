package com.lx.car.car;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.lx.car.linxlibrary.widgth.ListView4ScrollView;
import com.lx.car.linxlibrary.widgth.ScrollViewExtend;


public class WorkerDetailActivity extends BaseActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_detail);
        initView();
    }

    private void initView() {
        ListView4ScrollView listView4ScrollView = (ListView4ScrollView) findViewById(R.id.workerdetail_listView);
        MyAdapter myAdapter = new MyAdapter();
        listView4ScrollView.setAdapter(myAdapter);
        ScrollViewExtend scrollViewExtend = (ScrollViewExtend) findViewById(R.id.scrollView3);
        // 移到最上端
        scrollViewExtend.smoothScrollTo(0, 0);
        RelativeLayout rl_moreevaludte = (RelativeLayout) findViewById(R.id.workerdetail_moreevaludte);
        rl_moreevaludte.setOnClickListener(this);

        Button btn_baoxiu = (Button) findViewById(R.id.worker_btn_guarantee);
        btn_baoxiu.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_worker_detail, menu);
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
            case R.id.workerdetail_moreevaludte:
                startActivity(new Intent(this, MoreEvaluateActivity.class));
                break;
            case R.id.worker_btn_guarantee:
                startActivity(new Intent(this, DesignatedMaintenanceActivity.class));
                break;
        }

    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 20;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View inflate = getLayoutInflater().inflate(R.layout.item_evaluate, null);
            return inflate;
        }
    }
}
