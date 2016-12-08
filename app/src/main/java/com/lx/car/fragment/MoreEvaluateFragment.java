package com.lx.car.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.lx.car.car.R;

public class MoreEvaluateFragment extends Fragment {

    private View inflate;

    public MoreEvaluateFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (inflate == null) {
            inflate = inflater.inflate(R.layout.fragment_more_evaluate, container, false);
            initView();
        }
        return inflate;
    }

    private void initView() {
        ListView listView = (ListView) inflate.findViewById(R.id.moreEvaluateF_listview);
        MyAdapter adapter = new MyAdapter();
        listView.setAdapter(adapter);
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return 6;
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
            View inflate = getActivity().getLayoutInflater().inflate(R.layout.item_more_evalute, null);
            return inflate;
        }
    }

}
