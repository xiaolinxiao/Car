package com.lx.car.car;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lx.car.fragment.MoreEvaluateFragment;


public class MoreEvaluateActivity extends BaseActivity implements ViewPager.OnPageChangeListener {
    private int windowWidth;//屏幕宽度
    private float offset;//计算滑块的距离
    private TextView text_slider;
    private int[] evaluteIndex = new int[]{R.id.goodevalute, R.id.normalevalute, R.id.badevalute};
    private int[] numIndex = new int[]{R.id.goodevalutenum, R.id.normalevalutenum, R.id.badevalutenum};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_evaluate);
        iniView();
    }

    private void iniView() {
        windowWidth = getWindowWidth();
        TextView text_toptitle = (TextView) findViewById(R.id.text_toptitle);
        text_toptitle.setText(getResources().getString(R.string.moreevaluate));
        initSlider();
        ViewPager viewPager = (ViewPager) findViewById(R.id.exalute_viewpager);
        viewPager.setOnPageChangeListener(this);
        FragmentManager fm = getSupportFragmentManager();
        MyAdapter adapter = new MyAdapter(fm);
        viewPager.setAdapter(adapter);
    }

    /**
     * 获取屏幕宽度
     */
    private int getWindowWidth() {
        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        @SuppressWarnings("deprecation")
        int width = windowManager.getDefaultDisplay().getWidth();
        return width;
    }

    private void initSlider() {
        text_slider = (TextView) findViewById(R.id.text_slider);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) text_slider.getLayoutParams();
        layoutParams.width = windowWidth / 6;
        layoutParams.leftMargin = (int) windowWidth / 12;
        text_slider.setLayoutParams(layoutParams);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_more_evaluate, menu);
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
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        Log.e("position", "===" + position);
        Log.e("positionOffset", "===" + positionOffset);
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) text_slider.getLayoutParams();
        offset = position + positionOffset;
        int width = getWindowWidth() / 3;
//        if (position == 0) {
//            layoutParams.leftMargin = windowWidth / 12;
//            text_slider.setLayoutParams(layoutParams);
//        } else {
        layoutParams.leftMargin = (int) (offset * width + getWindowWidth() / 12);
        text_slider.setLayoutParams(layoutParams);
//        }
    }

    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < 3; i++) {
            TextView textView = (TextView) findViewById(evaluteIndex[i]);
            TextView numTextView = (TextView) findViewById(numIndex[i]);
            if (position == i) {
                textView.setTextColor(getResources().getColor(R.color.yellow));
                numTextView.setTextColor(getResources().getColor(R.color.yellow));
            } else {
                textView.setTextColor(Color.BLACK);
                numTextView.setTextColor(Color.BLACK);
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
            return new MoreEvaluateFragment();
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
