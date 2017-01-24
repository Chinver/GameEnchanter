package com.gameenchanter;

import android.os.Bundle;
import android.widget.TextView;

import com.gameenchanter.bd.DatabaseHelper;
import com.gameenchanter.es.model.Event;
import com.gameenchanter.es.service.serviceImpl.EventServiceImpl;
import com.jaredrummler.materialspinner.MaterialSpinner;

public class SpecialEventsActivity extends BaseActivity {
    private static final String TAG = "SpecialEventsActivity";
    private EventServiceImpl eventService;
    private DatabaseHelper databaseHelper;
    private MaterialSpinner spinner;
    private static String[] ITEMS= {"南云铁虎", "紫之创", "真白友也", "葵日向", "高峯翠", "姬宫桃李", "仙石忍", "葵裕太", "天满光", "朱樱司", "明星昴流",
            "冰鹰北斗", "游木真", "神崎飒马", "乙狩阿多尼斯", "大神晃牙", "朔间凛月", "衣更真绪", "伏见弓弦", "鸣上岚", "莲巳敬人", "天祥院英智",
            "羽风熏", "濑名泉", "守泽千秋", "鬼龙红郎", "日日树涉", "深海奏汰", "朔间零", "仁兔成鸣"};;

    private Event event;
    private TextView mini1;
    private TextView mini1Answer;
    private TextView mini2;
    private TextView mini2Answer;
    private TextView mini3;
    private TextView mini3Answer;
    private TextView mini4;
    private TextView mini4Answer;
    private TextView close1;
    private TextView close1Answer;
    private TextView close2;
    private TextView close2Answer;
    private TextView close3;
    private TextView close3Answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_special_events);

        databaseHelper = new DatabaseHelper(this);
        if (eventService == null) {
            eventService = new EventServiceImpl();
        }
        if (event == null) {
            event = new Event();
        }

        initSpinner();
        initView();
        initEvent();
    }

    private void initSpinner() {
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, ITEMS);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //        spinner.setAdapter(adapter);
        spinner = (MaterialSpinner) findViewById(R.id.spinner_special_events_idol);
        spinner.setItems(ITEMS);
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                initEvent();
            }
        });
    }

    private void initView() {
        mini1 = (TextView) findViewById(R.id.text_special_events_mini_1);
        mini1Answer = (TextView) findViewById(R.id.text_special_events_mini_1_answer);
        mini2 = (TextView) findViewById(R.id.text_special_events_mini_2);
        mini2Answer = (TextView) findViewById(R.id.text_special_events_mini_2_answer);
        mini3 = (TextView) findViewById(R.id.text_special_events_mini_3);
        mini3Answer = (TextView) findViewById(R.id.text_special_events_mini_3_answer);
        mini4 = (TextView) findViewById(R.id.text_special_events_mini_4);
        mini4Answer = (TextView) findViewById(R.id.text_special_events_mini_4_answer);
        close1 = (TextView) findViewById(R.id.text_special_events_close_1);
        close1Answer = (TextView) findViewById(R.id.text_special_events_close_1_part);
        close2 = (TextView) findViewById(R.id.text_special_events_close_2);
        close2Answer = (TextView) findViewById(R.id.text_special_events_close_2_part);
        close3 = (TextView) findViewById(R.id.text_special_events_close_3);
        close3Answer = (TextView) findViewById(R.id.text_special_events_close_3_part);
    }

    private void initEvent() {
        String idol = ITEMS[spinner.getSelectedIndex()];
        event = eventService.selectEventByIdol(databaseHelper, idol);

        if (event.getIdol() != null) {
            mini1.setText(event.getMini1());
            mini1Answer.setText(event.getAnswer1());
            mini2.setText(event.getMini2());
            mini2Answer.setText(event.getAnswer2());
            mini3.setText(event.getMini3());
            mini3Answer.setText(event.getAnswer3());
            mini4.setText(event.getMini4());
            mini4Answer.setText(event.getAnswer4());
            close1.setText(event.getClose1());
            close1Answer.setText(event.getPart1());
            close2.setText(event.getClose2());
            close2Answer.setText(event.getPart2());
            close3.setText(event.getClose3());
            close3Answer.setText(event.getPart3());
        }

    }
}
