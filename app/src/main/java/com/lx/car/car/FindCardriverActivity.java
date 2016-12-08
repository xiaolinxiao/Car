package com.lx.car.car;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;


public class FindCardriverActivity extends BaseActivity implements AdapterView.OnItemClickListener {

    private String activitylog;//根绝出传入的参数改变listview显示内容

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_cardriver);
        initView();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        Intent intent = getIntent();
        EditText edit_search = (EditText) findViewById(R.id.search_edit);
        activitylog = intent.getStringExtra("ACTIVITYLOG");
        if ("FindWorkerActivity".equalsIgnoreCase(activitylog)) {
            edit_search.setHint(getResources().getString(R.string.searchworker));
        } else {
            edit_search.setHint(getResources().getString(R.string.searchdriver));
        }
        ListView listView = (ListView) findViewById(R.id.findcardriver_listview);
        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_find_car, menu);
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
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(this, CardriverDetailActivity.class));
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 30;
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
            View inflate;
            if ("FindWorkerActivity".equalsIgnoreCase(activitylog)) {
                inflate = getLayoutInflater().inflate(R.layout.item_findworker, null);
            } else {
                inflate = getLayoutInflater().inflate(R.layout.item_findcardriver, null);
            }
            return inflate;
        }
    }
}
