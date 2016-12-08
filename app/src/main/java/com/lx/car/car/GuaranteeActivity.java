package com.lx.car.car;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class GuaranteeActivity extends BaseActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guarantee);
        initView();
    }

    private void initView() {
        TextView text_title = (TextView) findViewById(R.id.text_toptitle);
        text_title.setText("一键保修");
        ListView listView = (ListView) findViewById(R.id.guarantee_listview);
        listView.setAdapter(new MyAdapter());
        listView.setOnItemClickListener(this);
        Button btn_jinquebaoxiu = (Button) findViewById(R.id.guarantee_btn_jinquebaoxiu);
        btn_jinquebaoxiu.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_guarantee, menu);
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
        startActivity(new Intent(this, WorkerDetailActivity.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.guarantee_btn_jinquebaoxiu:
                startActivity(new Intent(this, PreciseWarrantyActivity.class));
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
            View inflate = getLayoutInflater().inflate(R.layout.item_findworker, null);
            return inflate;
        }
    }
}
