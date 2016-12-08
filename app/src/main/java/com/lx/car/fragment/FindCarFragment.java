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

import com.lx.car.car.CarDetaliActivity;
import com.lx.car.car.R;

public class FindCarFragment extends Fragment implements AdapterView.OnItemClickListener {

    private View inflate;

    public FindCarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (inflate == null) {
            inflate = inflater.inflate(R.layout.fragment_find_car, container, false);
            initView();
        }
        return inflate;
    }

    private void initView() {
        ListView listView = (ListView) inflate.findViewById(R.id.findcar_listview);
        listView.setAdapter(new MyAdapter());
        listView.setOnItemClickListener(this);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        startActivity(new Intent(getActivity(), CarDetaliActivity.class));
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 8;
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
            View inflate = getActivity().getLayoutInflater().inflate(R.layout.item_findcar, null);
            return inflate;
        }
    }
}
