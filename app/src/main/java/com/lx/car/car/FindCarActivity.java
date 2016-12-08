package com.lx.car.car;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.lx.car.fragment.FindCarFragment;


public class FindCarActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    private int[] textIndex = new int[]{R.id.rentV, R.id.allstyleV, R.id.brandV, R.id.defaultV};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_car);
        initView();
    }

    private void initView() {
        ViewPager viewPager = (ViewPager) findViewById(R.id.findcar_viewpager);
        FragmentManager fm = getSupportFragmentManager();
        MyAdapter adapter = new MyAdapter(fm);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < textIndex.length; i++) {
            TextView textView = (TextView) findViewById(textIndex[i]);
            if (position == i) {
                textView.setTextColor(getResources().getColor(R.color.yellow));
            } else {
                textView.setTextColor(Color.BLACK);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new FindCarFragment();
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}
