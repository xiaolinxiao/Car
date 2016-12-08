package com.lx.car.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.lx.car.car.FindCarActivity;
import com.lx.car.car.FindCardriverActivity;
import com.lx.car.car.FindWorkerActivity;
import com.lx.car.car.GuaranteeActivity;
import com.lx.car.car.ProjectActivity;
import com.lx.car.car.R;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements View.OnClickListener {
    private View view;//整体view
    private ViewPager viewPager;//存放广告
    private List<ImageView> list_point = new ArrayList<>();//广告点的list
    private int bef_point = 0;// 记录前一个变色的点位置
    private int currentItem = 0;//广告的下标
    private boolean isPlay = false;//判断是否广告要跳转

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {

            view = inflater.inflate(R.layout.fragment_home, container, false);
            initView();
        }
        return view;
    }

    /**
     * 初始化控件
     */
    private void initView() {
        viewPager = (ViewPager) view.findViewById(R.id.home_viewpage_ad);
        FragmentManager fm = getFragmentManager();
        MyAdapter myAdapter = new MyAdapter(fm);
        viewPager.setAdapter(myAdapter);
        viewPager.postDelayed(new Runnable() {

            @Override
            public void run() {
                if (!isPlay) {
                    //广告条跳转
                    currentItem = viewPager.getCurrentItem();
                    currentItem++;
                    viewPager.setCurrentItem(currentItem);
                }
                viewPager.postDelayed(this, 3000);
            }
        }, 3000);

        //把广告下的小点放进来
        list_point.add((ImageView) view.findViewById(R.id.point1));
        list_point.add((ImageView) view.findViewById(R.id.point2));
        list_point.add((ImageView) view.findViewById(R.id.point3));
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (isAdded()) {
                    int num = position % 3;
                    list_point.get(num).setBackground(getResources().getDrawable(R.drawable.xnoblank));
                    list_point.get(bef_point).setBackground(getResources().getDrawable(R.drawable.xblank));
                    bef_point = num;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                switch (state) {
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        isPlay = true;
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:
                        isPlay = false;
                        break;
                    default:
                        break;
                }
            }
        });

        ImageButton imageButton_findproject = (ImageButton) view.findViewById(R.id.home_image_findengineer);
        imageButton_findproject.setOnClickListener(this);
        ImageButton imageButton_finddriver = (ImageButton) view.findViewById(R.id.home_image_finddriver);
        imageButton_finddriver.setOnClickListener(this);
        ImageButton imageButton_findworker = (ImageButton) view.findViewById(R.id.home_image_findworker);
        imageButton_findworker.setOnClickListener(this);
        ImageButton imageButton_findCar = (ImageButton) view.findViewById(R.id.home_image_findcar);
        imageButton_findCar.setOnClickListener(this);
        ImageView imageView_yijianbaoxiu = (ImageView) view.findViewById(R.id.home_image_yijianbaoxiu);
        imageView_yijianbaoxiu.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_image_findengineer:
                startActivity(new Intent(getActivity(), ProjectActivity.class));
                break;
            case R.id.home_image_finddriver:
                startActivity(new Intent(getActivity(), FindCardriverActivity.class));
                break;
            case R.id.home_image_findworker:
                startActivity(new Intent(getActivity(), FindWorkerActivity.class));
                break;
            case R.id.home_image_findcar:
                startActivity(new Intent(getActivity(), FindCarActivity.class));
                break;
            case R.id.home_image_yijianbaoxiu:
                startActivity(new Intent(getActivity(), GuaranteeActivity.class));
                break;


        }
    }

    class MyAdapter extends FragmentPagerAdapter {


        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            BannerFragment bannerFragment = new BannerFragment();
            return bannerFragment;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public int getCount() {
            return 500000;
        }

    }

    @Override
    public void onDestroyView() {
        ViewGroup parent = (ViewGroup) view.getParent();
        parent.removeAllViews();
        super.onDestroyView();
    }
}
