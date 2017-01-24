package com.gameenchanter;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class ESActivity extends BaseActivity implements View.OnClickListener{
    private Intent intent;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_es);

        initView();
        initIntent();
    }

    private void initView() {
//        RelativeLayout blueLayout = (RelativeLayout) findViewById(R.id.layout_activity_blue);
//        blueLayout.setOnClickListener(this);
        RelativeLayout eventsLayout = (RelativeLayout) findViewById(R.id.layout_activity_special_events);
        eventsLayout.setOnClickListener(this);
        RelativeLayout settingLayout = (RelativeLayout) findViewById(R.id.layout_activity_setting);
        settingLayout.setOnClickListener(this);
    }

    private void initIntent() {
        intent = getIntent();
        if (intent == null) {
            intent = new Intent();
        }
        bundle = intent.getExtras();
        if (bundle == null) {
            bundle = new Bundle();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.layout_activity_blue:
//                intent.setClass(this, BlueActivity.class);
//                startActivity(intent);
//                break;
//            case R.id.layout_activity_special_events:
//                intent.setClass(this, SpecialEventsActivity.class);
//                startActivity(intent);
//                break;
//            case R.id.layout_activity_setting:
//                intent.setClass(this, SettingActivity.class);
//                startActivity(intent);
//                break;
        }
    }
}
