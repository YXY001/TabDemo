package com.yuanxy.tabdemo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment implements View.OnClickListener,ViewPager.OnPageChangeListener  {

    private List<Fragment> list_fragment;
    private ViewPager viewPager;
    private TextView textView1,textView2;
    public Fragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_fragment3, container, false);
        initView(v);
        //初始化两个界面
        setTimeColor();

        click();
        return v;
    }

    private void initView(View v){
        this.textView1 = (TextView) v.findViewById(R.id.TView_activityList_time);
        this.textView2 = (TextView) v.findViewById(R.id.TView_activityList_Recently);

        viewPager = (ViewPager) v.findViewById(R.id.viewPager);
        Fragment1 f1 = new Fragment1();
        Fragment2 f2 = new Fragment2();
        list_fragment = new ArrayList<>();
        list_fragment.add(f1);
        list_fragment.add(f2);
        MyAdapter m = new MyAdapter(getChildFragmentManager());
        viewPager.setAdapter(m);

    }

    private void click(){
        this.textView1.setOnClickListener(this);
        this.textView2.setOnClickListener(this);
        this.viewPager.setOnPageChangeListener(this);
    }
    /**
     * 设置点击时间时背景以及字体颜色
     */
    public void setTimeColor(){
        textView2.setBackgroundResource(R.drawable.textview_background_white_right);
        textView1.setBackgroundResource(R.drawable.textview_background_blue_left);
        textView1.setTextColor(getResources().getColor(R.color.colorWhite));
        textView2.setTextColor(getResources().getColor(R.color.colorBalck));
        viewPager.setCurrentItem(0);
    }
    /**
     * 设置点击地点时背景以及字体颜色
     */
    public void setLocationColor(){
        textView2.setBackgroundResource(R.drawable.textview_background_blue_right);
        textView1.setBackgroundResource(R.drawable.textview_background_white_left);
        textView1.setTextColor(getResources().getColor(R.color.colorBalck));
        textView2.setTextColor(getResources().getColor(R.color.colorWhite));
        viewPager.setCurrentItem(1);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.TView_activityList_time:
                setTimeColor();
                break;
            case R.id.TView_activityList_Recently:
                setLocationColor();
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        switch (position){
            case 0:
                setTimeColor();
                break;
            case 1:
                setLocationColor();
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    private class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list_fragment.get(position);
        }

        @Override
        public int getCount() {
            return list_fragment.size();
        }
    }

}
