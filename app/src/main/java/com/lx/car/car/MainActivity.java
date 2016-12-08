package com.lx.car.car;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TextView;

import com.lx.car.fragment.HomeFragment;
import com.lx.car.fragment.MeFragment;


public class MainActivity extends BaseActivity {
    private FragmentTabHost mTabHost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        mTabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        mTabHost.setup(this, getSupportFragmentManager(), R.id.realtabcontent);
        setTab(R.string.home_page, HomeFragment.class, R.drawable.homepage_tabselect);
        setTab(R.string.me, MeFragment.class, R.drawable.mepage_tabselect);
    }

    private void setTab(int indicator, Class<?> cls, int srcId) {
        TabHost.TabSpec newTabSpec = mTabHost.newTabSpec(indicator + "");
        View view = getLayoutInflater().inflate(R.layout.inducator_item, null);
        TextView textview = (TextView) view.findViewById(R.id.textView1);
        textview.setText(indicator);
        textview.setTextSize(12);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView1);
        Drawable drawable = getResources().getDrawable(srcId);
        imageView.setBackground(drawable);
        mTabHost.addTab(newTabSpec.setIndicator(view), cls, null);
    }
}
