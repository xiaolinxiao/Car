package com.lx.car.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lx.car.car.LoginActivity;
import com.lx.car.car.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MeFragment extends Fragment implements View.OnClickListener {


    private View inflate;

    public MeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (inflate == null) {
            inflate = inflater.inflate(R.layout.fragment_me, container, false);
            initView();
        }
        return inflate;
    }

    private void initView() {
        ImageView image_login = (ImageView) inflate.findViewById(R.id.me_imageview_loginow);
        image_login.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.me_imageview_loginow:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                break;
        }
    }
}
