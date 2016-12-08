package com.lx.car.car;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lx.car.fragment.WorkerFragment;


public class FindWorkerActivity extends BaseActivity implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private int[] textIndex = new int[]{R.id.worker_text_engine, R.id.worker_text_transmission, R.id.worker_text_bridge,
            R.id.worker_text_electrical, R.id.worker_text_tyre, R.id.worker_text_electricappliance};
    private ViewPager viewPager;//内容
    private TextView text_slide;//小滑块
    private HorizontalScrollView scrollView;//滑动父控件

    private int windowWidth;//屏幕宽度
    private float offset;//计算滑块的距离


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_worker);
        initView();
    }

    private void initView() {
        //获取屏幕宽度
        windowWidth = getWindowWidth();
        initScrollView();
        initYellow();
        viewPager.setOnPageChangeListener(this);
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

    /**
     * 设置小滑块宽度
     */
    private void initYellow() {
        scrollView = (HorizontalScrollView) findViewById(R.id.worker_scrollView);
        text_slide = (TextView) findViewById(R.id.worker_text_slide);
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) text_slide
                .getLayoutParams();
        layoutParams.width = windowWidth / 5;
        text_slide.setLayoutParams(layoutParams);
        viewPager = (ViewPager) findViewById(R.id.worker_viewpager);
        FragmentManager fm = getSupportFragmentManager();
        MyAdapter adapter = new MyAdapter(fm);
        viewPager.setAdapter(adapter);

        EditText edit_search = (EditText) findViewById(R.id.search_edit);
        edit_search.setHint(getResources().getString(R.string.searchworker));
        TextView text_search = (TextView) findViewById(R.id.text_search);
        text_search.setOnClickListener(this);
    }

    /**
     * 设置小标题的宽度
     */
    private void initScrollView() {
        for (int i = 0; i < textIndex.length; i++) {
            TextView textView = (TextView) findViewById(textIndex[i]);
            if (i == 0) {
                textView.setTextColor(getResources().getColor(R.color.yellow));
            }
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(15);
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) textView.getLayoutParams();
            params.width = windowWidth / 5;
            textView.setLayoutParams(params);
            final int itemIndex = i;
            textView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    viewPager.setCurrentItem(itemIndex);
                }
            });

        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        android.widget.RelativeLayout.LayoutParams layoutParams = (android.widget.RelativeLayout.LayoutParams) text_slide.getLayoutParams();
        offset = position + positionOffset;
        int screenWidth = getWindowWidth();
        int width = screenWidth / 5;
        if (position < 2) {
            layoutParams.leftMargin = (int) (offset * width);
            text_slide.setLayoutParams(layoutParams);
        } else if (position >= 2 && position < 3) {
            // 滑块不动，HorizontalScrollView滑动
            int offsetX = (int) ((offset - 2) * width);
            scrollView.scrollTo(offsetX, 0);
            layoutParams.leftMargin = (int) (2 * width);
            text_slide.setLayoutParams(layoutParams);
        } else {
            layoutParams.leftMargin = (int) ((offset - 1) * width);
            text_slide.setLayoutParams(layoutParams);
        }
    }

    @Override
    public void onPageSelected(int position) {

        for (int i = 0; i < textIndex.length; i++) {
            TextView textview = (TextView) findViewById(textIndex[i]);
            if (position == i) {
                textview.setTextColor(getResources().getColor(R.color.yellow));
            } else {
                textview.setTextColor(Color.BLACK);
            }
        }

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_search:
                Intent intent = new Intent(this, FindCardriverActivity.class);
                intent.putExtra("ACTIVITYLOG", "FindWorkerActivity");
                startActivity(intent);
                break;
        }
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return new WorkerFragment();
        }

        @Override
        public int getCount() {
            return 6;
        }
    }
}
