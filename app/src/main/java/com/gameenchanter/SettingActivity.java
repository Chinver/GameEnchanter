package com.gameenchanter;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.gameenchanter.bd.DatabaseHelper;
import com.gameenchanter.es.model.Event;
import com.gameenchanter.es.service.serviceImpl.EventServiceImpl;

import java.io.FileInputStream;
import java.io.InputStream;

import jxl.Sheet;
import jxl.Workbook;

public class SettingActivity extends BaseActivity  implements View.OnClickListener{
    private static final String PATH= Environment.getExternalStorageDirectory().getPath() + "/ES/";
    private static final String TAG = "SettingActivity";

    private EventServiceImpl eventService;
    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        databaseHelper = new DatabaseHelper(this);
        if (eventService == null) {
            eventService = new EventServiceImpl();
        }

        RelativeLayout eventLayout = (RelativeLayout) findViewById(R.id.layout_import_event_excel);
        eventLayout.setOnClickListener(this);
    }



    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.layout_import_event_excel:
                if (importFromExcel() > 0) {
                    Toast.makeText(this, "导入成功。", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "导入失败。", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    private int importFromExcel() {
        int countFailure = 0;
        int countSuccess = 0;
        try {
            InputStream is = new FileInputStream(PATH + "Events.xls");
            Workbook book = Workbook.getWorkbook(is);
//            int num = book.getNumberOfSheets();
            // 获得第一个工作表对象
            Sheet sheet = book.getSheet(0);
            int rows = sheet.getRows();
            int cols = sheet.getColumns();
            Log.d(TAG, "当前工作表的名字:" + sheet.getName());
            Log.d(TAG, "总行数:" + rows);
            Log.d(TAG, "总列数:" + cols);
            Event event;
            for (int i = 1; i <= rows; i++) {//从第一行开始取值
                event = new Event();
                event.setIdol((sheet.getCell(0, i)).getContents());//第一列
                event.setMini1((sheet.getCell(1, i)).getContents());//第二列
                event.setAnswer1((sheet.getCell(2, i)).getContents());
                event.setMini2((sheet.getCell(3, i)).getContents());
                event.setAnswer2((sheet.getCell(4, i)).getContents());
                event.setMini3((sheet.getCell(5, i)).getContents());
                event.setAnswer3((sheet.getCell(6, i)).getContents());
                event.setMini4((sheet.getCell(7, i)).getContents());
                event.setAnswer4((sheet.getCell(8, i)).getContents());
                event.setClose1((sheet.getCell(9, i)).getContents());
                event.setPart1((sheet.getCell(10, i)).getContents());
                event.setClose2((sheet.getCell(11, i)).getContents());
                event.setPart2((sheet.getCell(12, i)).getContents());
                event.setClose3((sheet.getCell(13, i)).getContents());
                event.setPart3((sheet.getCell(14, i)).getContents());
                int insertResult = eventService.insertEvent(databaseHelper, event);
                if (insertResult == 10) {
                    countSuccess++;
                } else {
                    int updateResult = eventService.UpdateEvent(databaseHelper, event);
                    if (updateResult == 1) {
                        countSuccess++;
                    } else {
                        countFailure++;
                    }
                }
            }
            book.close();
        } catch (Exception e) {
            Log.d(TAG, e.toString());
        } finally {
            Log.d(TAG, "importFromExcel: Success=" + countSuccess + " Failure=" + countFailure);
        }
        return countSuccess;
    }
}
