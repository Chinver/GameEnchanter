package com.gameenchanter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import com.gameenchanter.es.adapter.MainAdapter;
import com.github.florent37.materialviewpager.MaterialViewPager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private MaterialViewPager mViewPager;
    private List<View> views; //图片指示器
    private Intent intent=new Intent();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewPager();
    }

    private void initViewPager() {
        mViewPager = (MaterialViewPager) findViewById(R.id.materialViewPager_activity_main);
        ViewPager viewPager = mViewPager.getViewPager();

//After set an adapter to the ViewPager
        if (views != null && views.size() > 0) {
            views.clear();
        } else {
            views = new ArrayList<>();
        }
        LayoutInflater mInflater = getLayoutInflater();
        View view1 = mInflater.inflate(R.layout.activity_es, null);
        View view2 = mInflater.inflate(R.layout.activity_fz, null);
        views.add(view1);
        views.add(view2);
        MainAdapter mainAdapter = new MainAdapter(this, views);
        RelativeLayout eventsLayout = (RelativeLayout) view1.findViewById(R.id.layout_activity_special_events);
        eventsLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setClass(MainActivity.this, SpecialEventsActivity.class);
                startActivity(intent);
            }
        });
        RelativeLayout settingLayout = (RelativeLayout) view1.findViewById(R.id.layout_activity_setting);
        settingLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent.setClass(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
        viewPager.setAdapter(mainAdapter);
        viewPager.setCurrentItem(0);

        mViewPager.getPagerTitleStrip().setViewPager(mViewPager.getViewPager());
    }


}
