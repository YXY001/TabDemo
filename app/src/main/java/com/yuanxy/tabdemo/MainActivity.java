package com.yuanxy.tabdemo;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager viewPager1;
    private List<Fragment> list_fragment1;
    private LinearLayout l1,l2,l3,l4;
    private ImageView i1,i2,i3,i4;
    private TextView t1,t2,t3,t4;

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /*设置状态栏颜色*/
        getWindow().setStatusBarColor(Color.parseColor("#FF8000"));


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //初始化界面
        initView();

        //点击事件
        click();
    }

    /**
     * 点击事件
     */
    private void click() {
        this.l1.setOnClickListener(this);
        this.l2.setOnClickListener(this);
        this.l3.setOnClickListener(this);
        this.l4.setOnClickListener(this);
    }

    /**
     * 初始化界面
     */
    private void initView() {

        this.l1 = (LinearLayout) findViewById(R.id.ll_main_page);
        this.l2 = (LinearLayout) findViewById(R.id.ll_main_find);
        this.l3 = (LinearLayout) findViewById(R.id.ll_main_mess);
        this.l4 = (LinearLayout) findViewById(R.id.ll_main_mine);

        this.t1 = (TextView) findViewById(R.id.txt_main);
        this.t2 = (TextView) findViewById(R.id.txt_find);
        this.t3 = (TextView) findViewById(R.id.txt_mess);
        this.t4 = (TextView) findViewById(R.id.txt_mine);

        this.i1 = (ImageView) findViewById(R.id.img_main);
        this.i2 = (ImageView) findViewById(R.id.img_find);
        this.i3 = (ImageView) findViewById(R.id.img_mess);
        this.i4 = (ImageView) findViewById(R.id.img_mine);


        viewPager1 = (ControlScrollViewPager) findViewById(R.id.viewPager1);


        Fragment3 f3 = new Fragment3();
        Fragment4 f4 = new Fragment4();
        Fragment5 f5 = new Fragment5();
        Fragment6 f6 = new Fragment6();

        list_fragment1 = new ArrayList<>();

        list_fragment1.add(f3);
        list_fragment1.add(f4);
        list_fragment1.add(f5);
        list_fragment1.add(f6);

        MyAdapter1 m1 = new MyAdapter1(getSupportFragmentManager());

        viewPager1.setAdapter(m1);

    }



    private class MyAdapter1 extends FragmentPagerAdapter {
        public MyAdapter1(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return list_fragment1.get(position);
        }

        @Override
        public int getCount() {
            return list_fragment1.size();
        }
    }




    private void showHome(){
        i1.setImageResource(R.mipmap.tabbar_home_highlighted);
        t1.setTextColor(getResources().getColor(R.color.colorOrange,null));
        i3.setImageResource(R.mipmap.tabbar_message_center);
        t3.setTextColor(getResources().getColor(R.color.colorBalck,null));
        i2.setImageResource(R.mipmap.tabbar_discover);
        t2.setTextColor(getResources().getColor(R.color.colorBalck,null));
        i4.setImageResource(R.mipmap.tabbar_profile);
        t4.setTextColor(getResources().getColor(R.color.colorBalck,null));
        viewPager1.setCurrentItem(0);
    }

    private void showFind(){
        i2.setImageResource(R.mipmap.tabbar_discover_highlighted);
        t2.setTextColor(Color.parseColor("#FF8000"));
        i1.setImageResource(R.mipmap.tabbar_home);
        t1.setTextColor(Color.parseColor("#000000"));
        i3.setImageResource(R.mipmap.tabbar_message_center);
        t3.setTextColor(Color.parseColor("#000000"));
        i4.setImageResource(R.mipmap.tabbar_profile);
        t4.setTextColor(Color.parseColor("#000000"));
        viewPager1.setCurrentItem(1);
    }

    private void showMess(){
        i3.setImageResource(R.mipmap.tabbar_message_center_highlighted);
        t3.setTextColor(Color.parseColor("#FF8000"));
        i1.setImageResource(R.mipmap.tabbar_home);
        t2.setTextColor(Color.parseColor("#000000"));
        i2.setImageResource(R.mipmap.tabbar_discover);
        t2.setTextColor(Color.parseColor("#000000"));
        i4.setImageResource(R.mipmap.tabbar_profile);
        t4.setTextColor(Color.parseColor("#000000"));
        viewPager1.setCurrentItem(2);
    }

    private void showMine(){
        i4.setImageResource(R.mipmap.tabbar_profile_highlighted);
        t4.setTextColor(Color.parseColor("#FF8000"));
        i1.setImageResource(R.mipmap.tabbar_home);
        t1.setTextColor(Color.parseColor("#000000"));
        i3.setImageResource(R.mipmap.tabbar_message_center);
        t3.setTextColor(Color.parseColor("#000000"));
        i2.setImageResource(R.mipmap.tabbar_discover);
        t2.setTextColor(Color.parseColor("#000000"));
        viewPager1.setCurrentItem(3);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_main_page:
                showHome();
                break;
            case R.id.ll_main_find:
                showFind();
                break;
            case R.id.ll_main_mess:
                showMess();
                break;
            case R.id.ll_main_mine:
                showMine();
                break;
        }
    }
}
