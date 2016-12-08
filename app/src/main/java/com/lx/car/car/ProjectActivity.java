package com.lx.car.car;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.lx.car.Bean.ProjectBean;

import java.util.ArrayList;
import java.util.List;


public class ProjectActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private List<ProjectBean> beanList = new ArrayList<>();
    private List<ProjectBean> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project);
        getData();
        initView();

    }

    /**
     * 初始化控件
     */
    private void initView() {
        ListView listView = (ListView) findViewById(R.id.project_list);
        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);
        ImageView btn_back = (ImageView) findViewById(R.id.project_image_back);
        btn_back.setOnClickListener(this);
        listView.setOnItemClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_project, menu);
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

    public List<ProjectBean> getData() {
        List<ProjectBean> list = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            ProjectBean bean = new ProjectBean();
        }


        return data;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.project_image_back:
                finish();
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(this, ProjectDetailActivity.class));
    }

    class MyAdapter extends BaseAdapter {
        public MyAdapter() {

        }

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
            View inflate = getLayoutInflater().inflate(R.layout.item_project, null);
            return inflate;
        }
    }
}
