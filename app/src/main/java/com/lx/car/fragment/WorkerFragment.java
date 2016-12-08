package com.lx.car.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.lx.car.car.R;
import com.lx.car.car.WorkerDetailActivity;

public class WorkerFragment extends Fragment implements AdapterView.OnItemClickListener {

    public WorkerFragment() {
        // Required empty public constructor
    }

    private View inflate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (inflate == null) {
            inflate = inflater.inflate(R.layout.fragment_worker, container, false);
            initView();
        }
        return inflate;
    }

    private void initView() {
        ListView listView = (ListView) inflate.findViewById(R.id.worker_listview);
        MyAdapter myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(getActivity(), WorkerDetailActivity.class));
    }

//    @Override
//    public void onDestroyView() {
//        ViewGroup viewGroup = (ViewGroup) inflate.getParent();
//        viewGroup.removeAllViews();
//        super.onDestroyView();
//    }


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
            View inflate = getActivity().getLayoutInflater().inflate(R.layout.item_findworker, null);
            return inflate;
        }
    }
}
